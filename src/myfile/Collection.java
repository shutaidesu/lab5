package myfile;

import model.House;
import model.HouseComplex;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Comparator;
public class Collection {

    private Hashtable<HouseComplex, String> house;

    private LocalDateTime dateSave;

    private FileManager fileManager;

    public LocalDateTime getDateSave() {
        return dateSave;
    }

    public void save(){
        dateSave = LocalDateTime.now();
        fileManager.save(house);
    }

    public void saveAs(String fileName){
        FileManager fileManager1 = new FileManager(fileName);
        fileManager1.save(house);
    }

    private LocalDateTime dateInit;
    public Collection(FileManager fileManager) throws FileNotFoundException {
        this.house = fileManager.readFile();
        dateInit = LocalDateTime.now();
        this.fileManager = fileManager;
    }

    public LocalDateTime getDateInit() {
        return dateInit;
    }


    public Hashtable<HouseComplex, String> getHouse(){
        return house.get();
    }

    public void add(House houses){
        house.put(houses);
    }
    public String getType(){
        return house.getClass().getName();
    }
    public void clear(){
        house.clear();
    }
    public House getById(String name){
        for (House houses : house){
            if (houses.getName() == name){
                return houses;
            }
        }
        return null;
    }

    public HouseComplex getBySalary(float salary){
        for (HouseComplex worker : workers){
            if (worker.getSalary() == salary){
                return worker;
            }
        }
        return null;
    }
    public void removeById(long id) {
        Hashtable<HouseComplex, String> houseHashtable = new Hashtable<>(house);
        for (int i = 0; i < houseHashtable.size(); ++i) {
            if (houseHashtable.get(i).getId() == id) {
                houseHashtable.remove(i);
            }
        }
        house = new Hashtable<>(houseHashtable);
    }
    public Long maxId(){
        if (house.isEmpty()){
            return 0L;
        }
        return house.stream().max(Comparator.comparing(House::getId)).get().getId();
    }
    public int countElements(){
        return house.size();
    }
    public void removeGreater(float salary){
        house.removeIf(houses -> houses.getSalary() > salary);
    }
    public void removeFirst(){
        house.removeFirst();
    }
    public void showFirst() {
        System.out.println(house.peek());
    }

    public Hashtable<House, String> getHouse(){
        Hashtable<House, String> numberHouse = new Hashtable<>();
        for(House houses : house){
            if(!numberHouse.contains(houses.getName())){
                numberHouse.add(houses.getName());
            }
        }
        return numberHouse;
    }

    public void removeAllBySalary(float salary) {
        house.removeIf(houses -> houses.getSalary() == salary);
    }

    public void removeAllBy
}