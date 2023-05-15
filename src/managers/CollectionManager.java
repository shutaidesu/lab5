package managers;

import model.Flat;
import model.House;
import com.google.common.collect.Iterables;
import util.console.Console;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Оперирует коллекцией.
 * @author shutaidesu
 */
public class CollectionManager {
    private Hashtable<Flat, String> collection = new Hashtable<Flat, String>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private final FileManager fileManager;

    public CollectionManager(FileManager fileManager) throws FileNotFoundException {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.fileManager = fileManager;

        loadCollection();
    }

    public void validateAll(Console console) {
        House.allHouse().values().forEach(house -> {
            if (!house.validate()) {
                console.printError("Дом с name=" + house.getName() + " имеет невалидные поля.");
            }
        });

        (new ArrayList<>(this.getCollection())).forEach(Flat -> {
            if (!Flat.validate()) {
                console.printError("Квартира с id=" + Flat.getId() + " имеет невалидные поля.");
            }
        });
        console.println("! Загруженные здания валидны.");
    }

    public double minValue(){
        if(collection.isEmpty())
            return 0L;
        return getCollection().stream().min(Comparator.comparing(Flat::getArea)).get().getArea();
    }

    /**
     * @return коллекция.
     */
    public Set<Flat> getCollection() {
        return collection.keySet();
    }

    public Hashtable<Flat, String> getCollectionForSet() {
        return collection;
    }

    /**
     * @return Последнее время инициализации.
     */
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * @return Последнее время сохранения.
     */
    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    /**
     * @return Имя типа коллекции.
     */
    public String collectionType() {
        return collection.getClass().getName();
    }

    /**
     * @return Размер коллекции.
     */
    public int collectionSize() {
        return collection.size();
    }

    /**
     * @return Первый элемент коллекции (null если коллекция пустая).
     */
    public String getFirst() {
        if (collection.isEmpty()) return null;
        return collection.entrySet().iterator().next().getValue();

    }

    /**
     * @return Последний элемент коллекции (null если коллекция пустая).
     */
    public Flat getLast() {
        if (collection.isEmpty()) return null;
        return Iterables.getLast(collection.keySet());
    }

    /**
     * @param id ID элемента.
     * @return Элемент по его ID или null, если не найдено.
     */
    public Flat getById(int id) {
        for (Flat element : collection.keySet()) {
            if (element.getId() == id) return element;
        }
        return null;
    }

    /**
     * @param id ID элемента.
     * @return Проверяет, существует ли элемент с таким ID.
     */
    public boolean checkExist(int id) {
        for (Flat element : collection.keySet()) {
            if (element.getId() == id) return true;
        }
        return false;
    }

    /**
     * @param elementToFind элемент, который нужно найти по значению.
     * @return Найденный элемент (null если нен найден).
     */
    public Flat getByValue(Flat elementToFind) {
        for (Flat element : collection.keySet()) {
            if (element.equals(elementToFind)) return element;
        }
        return null;
    }

    /**
     * Добавляет элемент в коллекцию
     * @param element Элемент для добавления.
     */
    public void addToCollection(Flat element) {
        collection.put(element, null);
        Flat.touchNextId();
    }

    /**
     * Удаляет элемент из коллекции.
     * @param element Элемент для удаления.
     */
    public void removeFromCollection(Flat element) {
        collection.remove(element);
    }

    /**
     * Очищает коллекцию.
     */
    public void clearCollection() {
        collection.clear();
    }

    /**
     * Сохраняет коллекцию в файл
     */
    public void saveCollection() {
        fileManager.writeCollection((Map<Flat, String>) collection);
        lastSaveTime = LocalDateTime.now();
    }

    /**
     * Загружает коллекцию из файла.
     */
    private void loadCollection() throws FileNotFoundException {
        collection = (Hashtable<Flat, String>) fileManager.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        if (collection.isEmpty()) return "Коллекция пуста!";
        var last = getLast();

        StringBuilder info = new StringBuilder();
        for (Flat product : collection.keySet()) {
            info.append(product);
            if (product != last) info.append("\n\n");
        }
        return info.toString();
    }
}
