package managers;

import java.time.LocalDateTime;
import java.util.Map;

import model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;

import com.google.common.reflect.TypeToken;
import model.Flat;
import util.console.Console;

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


    public FileManager(String fileName, Console console){
        if (!(new File(fileName).exists())) {
            fileName = "../" + fileName;
        }
        this.fileName = fileName;
        this.console = console;
    }
    /**
     * Записывает коллекцию в файл.
     */
/*
    public void writeCollection(Hashtable<Flat, String> collection){
        try(BufferedWriter collectionPrintWriter = new BufferedWriter(new FileWriter(fileName))){
            collectionPrintWriter.write();
            console.println("Коллекция успешна сохранена в файл!");
        } catch(IOException e){
            console.printError("Загрузочный файл не может быть открыт!");
        }
    }
    public Map<Flat, String> readCollection() throws FileNotFoundException{
        if(fileName != null && fileName.isEmpty()) {
            try (InputStreamReader inp = new InputStreamReader(new FileInputStream(fileName))) {
                var collectionType = new TypeToken<Hashtable<Flat, String>>(){}.getType();
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
                Hashtable<Flat, String> collection = ;
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
    }*/


    public static ArrayDeque<Flat> getData() {
        return data;
    }

    public void setData(ArrayDeque<Flat> data) {
        FileManager.data = data;
    }

    public static ArrayDeque<Flat> data = new ArrayDeque<>();

    /**
     * Loads database to data object.
     * @param path XML DB file path
     * @throws ParserConfigurationException
     * Throws when DB can't be parsed.
     */
    public static void loadData(String path) throws ParserConfigurationException {

        File checknull = new File(path);
        if(checknull.length() == 0){
            return;
        }

        Document doc = null;

        try {
            DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilt = dbFact.newDocumentBuilder();
            doc = dBuilt.parse(new File(path));

        } catch (SAXException sax) {
            System.err.println("Неверная конфигурация xml файла, проверьте исходный файл.");
            System.exit(-1);
        } catch (IOException io) {
            System.err.println("Ошибка доступа к базе, проверьте и повторите заного.");
            System.exit(-1);
        }

        ArrayDeque<Flat> data = new ArrayDeque<>();

        NodeList nodeList = doc.getElementsByTagName("Flat");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                String[] coordinates = eElement.getElementsByTagName("coordinates").item(0).getTextContent().trim().split("\\s+");
                String[] house = eElement.getElementsByTagName("house").item(0).getTextContent().trim().split("\\s+");
                int crdate = Integer.parseInt(eElement.getElementsByTagName("creationDate").item(0).getTextContent());

                Flat flat = new Flat(
                        eElement.getElementsByTagName("name").item(0).getTextContent(),
                        new Coordinates(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])),
                        LocalDateTime.ofInstant(Instant.ofEpochSecond(crdate), ZoneId.of("Europe/Moscow")),
                        Double.parseDouble(eElement.getElementsByTagName("area").item(0).getTextContent()),
                        Integer.parseInt(eElement.getElementsByTagName("numberOfRooms").item(0).getTextContent()),
                        Long.parseLong(eElement.getElementsByTagName("numberOfBathrooms").item(0).getTextContent()),
                        Furnish.valueOf(eElement.getElementsByTagName("furnish").item(0).getTextContent()),
                        Transport.valueOf(eElement.getElementsByTagName("transport").item(0).getTextContent()),

                        new House(
                                house[0],
                                Integer.parseInt(house[1]),
                                Long.parseLong(house[2]),
                                Integer.parseInt(house[3]),
                                Long.parseLong(house[4])
                        )
                );

                data.add(flat);

            }
        }

        FileManager.data = data;
    }

    /**
     * Adds new Flat element to the collection.
     * @param flat Flat object
     */
    public static void addElement(Flat flat){
        FileManager.data.add(flat);
    }
    public static void changeElement(int flatid, Flat flat){
        for(Flat f : FileManager.data){
            if (f.getId() == flatid){
                flat.setId(f.getId());
                flat.setCreationDate(f.getCreationDate());
                FileManager.data.remove(f);
                break;
            }
        }
        FileManager.data.add(flat);
    }

    /**
     * Clears data object.
     */
    public static void dropAll(){
        FileManager.data.clear();
    }

    /**
     * Writes new changes to DB file.
     * @param path XML DB file path
     * @return
     * @throws TransformerException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static boolean writeToFile(String path) throws TransformerException, ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element rootElement = doc.createElementNS(null, "data");
        doc.appendChild(rootElement);

        ArrayDeque<Flat> flats = FileManager.getData();

        if(flats.isEmpty()){
            try {
                new FileWriter(path, false).close();
            }
            catch (java.io.IOException io){
                System.err.println("Изменения не сохранены. Ошибка доступа к файлу, проверьте файл и попробуйте сохранить ещё раз.");
                return false;
            }
        }

        for(Flat flat: flats) {

            Element nodee = doc.createElement("Flat");
            Node q = rootElement.appendChild(nodee);

            q.appendChild(parseNode(doc, "id", String.valueOf(flat.getId())));
            q.appendChild(parseNode(doc, "name", flat.getName()));

            Element corelem = doc.createElement("coordinates");
            Node coordinates = q.appendChild(corelem);
            coordinates.appendChild(parseNode(doc, "x", String.valueOf(flat.getCoordinates().getX())));
            coordinates.appendChild(parseNode(doc, "y", String.valueOf(flat.getCoordinates().getY())));


            q.appendChild(parseNode(doc, "creationDate", String.valueOf(flat.getCreationDate())));
            q.appendChild(parseNode(doc, "area", String.valueOf(flat.getArea())));
            q.appendChild(parseNode(doc, "numberOfRooms", String.valueOf(flat.getNumberOfRooms())));
            q.appendChild(parseNode(doc, "furnish", String.valueOf(flat.getFurnish())));

            Element houseelem = doc.createElement("house");
            Node house = q.appendChild(houseelem);
            house.appendChild(parseNode(doc, "name", flat.getHouse().getName()));
            house.appendChild(parseNode(doc, "year", String.valueOf(flat.getHouse().getYear())));
            house.appendChild(parseNode(doc, "numberOfFloors", String.valueOf(flat.getHouse().getNumberOfFloors())));
            house.appendChild(parseNode(doc, "numberOfLifts", String.valueOf(flat.getHouse().getNumberOfLifts())));


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            try {
                StreamResult file = new StreamResult(new PrintWriter(path));
                transformer.transform(source, file);
            }
            catch (java.io.FileNotFoundException jxtt){
                System.err.println("Изменения не сохранены. Ошибка доступа к файлу, проверьте файл и попробуйте сохранить ещё раз.");
                return false;
            }

        }
        return true;
    }

    /**
     * Parses node.
     * @param doc
     * @param name
     * @param value
     * @return
     */
    private static Node parseNode(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}
