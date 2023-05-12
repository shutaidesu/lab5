package myfile;

import model.HouseComplex;
import util.Console;

import javax.management.modelmbean.XMLParseException;
import java.io.*;
import java.util.HashSet;
import java.util.Hashtable;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 * Использует файл для сохранения и загрузки коллекции.
 * @author shutaidesu
 */

public class FileManager {
    private String fileName;
    private int id = 0;
    private final Console console;

    public FileManager(String filename, Console console){
        this.id++;
        this.fileName = fileName;
        this.console = console;
    }
    /**
     * Считывает коллекцию из файл.
     * @return Считанная коллекция
     */
    public Collection<HouseComplex> readFile() throws FileNotFoundException{
        if(fileName != null && fileName.isEmpty()) {
            try (InputStreamReader inp = new InputStreamReader(new FileInputStream(fileName))) {
                BufferedReader reader = new BufferedReader(inp);
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while((line = reader.readLine()) != null){
                    line = line.trim();
                    if(!(line.equals("")))
                        stringBuilder.append(line);
                }

                if(stringBuilder.length() == 0){
                    stringBuilder = new StringBuilder("[]");
                }
                Hashtable<HouseComplex, String> collection = ;
                console.println("Коллекция успешно загружена!");
                return collection;
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException exception) {
                console.printError("Загрузочный файл не найден!");
            } catch (NoSuchElementException exception) {
                console.printError("Загрузочный файл пуст!");
            } catch (XMLParseException exception) {
                console.printError("В загрузочном файле не обнаружена необходимая коллекция!");
            } catch (IllegalStateException | IOException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        } else {
            console.printError("Переменная окружения с путем загрузочного файла не найдена!");
        }
        return new Hashtable<>;
    }

    public void save(Hashtable<HouseComplex, String> hashtable){

    }

    /*public boolean checkHouseComplexId(Hashtable<HouseComplex, String> houseComplexs){
        HashSet<Long> set = new HashSet<>();
        for(HouseComplex houseComplex : houseComplexs){
            if(set.contains(houseComplex.getId())){
                return false;
            }
            set.add(houseComplex.getId());
        }
        return true;
    }

     */
}
