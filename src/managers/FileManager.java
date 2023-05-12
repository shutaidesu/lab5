package managers;

import java.util.Map;

import model.Flat;
import util.console.Console;

import javax.management.modelmbean.XMLParseException;
import java.io.*;
import java.util.Hashtable;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 * Использует файл для сохранения и загрузки коллекции.
 * @author shutaidesu
 */

public class FileManager {
    private String fileName;
    private final Console console;

    public FileManager(String filename, Console console){
        this.fileName = fileName;
        this.console = console;
    }
    /**
     * Записывает коллекцию в файл.
     * @param collection коллекция
     */

    public void writeCollection(Map<Flat, String> collection){
        try(BufferedWriter collectionPrintWriter = new BufferedWriter(new FileWriter(fileName))){
            collectionPrintWriter.write(collection);
            console.println("Коллекция успешна сохранена в файл!");
        } catch(IOException e){
            console.printError("Загрузочный файл не может быть открыт!");
        }
    }

    /**
     * Считывает коллекцию из файл.
     * @return Считанная коллекция
     */
    public Map<Flat, String> readCollection() throws FileNotFoundException{
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
                Hashtable<Flat, String> collection =;
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
        return new Hashtable<>();
    }
}
