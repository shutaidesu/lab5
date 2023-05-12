package managers;

import model.Flat;
import model.House;
import com.google.common.collect.Iterables;
import util.Console;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Оперирует коллекцией.
 * @author shutaidesu
 */
public class CollectionManager {
    private Queue<Flat> collection = new PriorityQueue<Flat>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private final FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.fileManager = fileManager;

        loadCollection();
    }

    public void validateAll(Console console) {
        House.allHouse().values().forEach(house -> {
            if (!house.validate()) {
                console.printError("Организация с id=" + house.getId() + " имеет невалидные поля.");
            }
        });

        (new ArrayList<>(this.getCollection())).forEach(flat -> {
            if (!flat.validate()) {
                console.printError("Продукт с id=" + flat.getId() + " имеет невалидные поля.");
            }
        });
        console.println("! Загруженные продукты валидны.");
    }

    /**
     * @return коллекция.
     */
    public Queue<Flat> getCollection() {
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
    public Flat getFirst() {
        if (collection.isEmpty()) return null;
        return collection.peek();
    }

    /**
     * @return Последний элемент коллекции (null если коллекция пустая).
     */
    public Flat getLast() {
        if (collection.isEmpty()) return null;
        return Iterables.getLast(collection);
    }

    /**
     * @param id ID элемента.
     * @return Элемент по его ID или null, если не найдено.
     */
    public Product getById(int id) {
        for (Product element : collection) {
            if (element.getId() == id) return element;
        }
        return null;
    }

    /**
     * @param id ID элемента.
     * @return Проверяет, существует ли элемент с таким ID.
     */
    public boolean checkExist(int id) {
        for (Product element : collection) {
            if (element.getId() == id) return true;
        }
        return false;
    }

    /**
     * @param elementToFind элемент, который нужно найти по значению.
     * @return Найденный элемент (null если нен найден).
     */
    public Product getByValue(Product elementToFind) {
        for (Product element : collection) {
            if (element.equals(elementToFind)) return element;
        }
        return null;
    }

    /**
     * Добавляет элемент в коллекцию
     * @param element Элемент для добавления.
     */
    public void addToCollection(Product element) {
        collection.add(element);
        Product.touchNextId();
    }

    /**
     * Удаляет элемент из коллекции.
     * @param element Элемент для удаления.
     */
    public void removeFromCollection(Product element) {
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
        dumpManager.writeCollection(collection);
        lastSaveTime = LocalDateTime.now();
    }

    /**
     * Загружает коллекцию из файла.
     */
    private void loadCollection() {
        collection = (PriorityQueue<Product>) dumpManager.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        if (collection.isEmpty()) return "Коллекция пуста!";
        var last = getLast();

        StringBuilder info = new StringBuilder();
        for (Product product : collection) {
            info.append(product);
            if (product != last) info.append("\n\n");
        }
        return info.toString();
    }
}