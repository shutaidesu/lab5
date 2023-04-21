package myfile;

import model.HouseComplex;

import java.io.*;
import java.util.Hashtable;
import java.io.FileNotFoundException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FileManager {
    private String fileName;

    public FileManager(String filename){
        this.fileName = fileName;
    }
    public Hashtable<HouseComplex, String> readFile() throws FileNotFoundException{
        Hashtable<HouseComplex, String> houseComplex = new Hashtable<>();
        try(InputStreamReader inp = new InputStreamReader(new FileInputStream(fileName))){
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            if(!inp.ready()){
            } else{
                DefaultHandler handler = new DefaultHandler();

                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser = factory.newSAXParser();
                parser.parse(new File(fileName), handler);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return houseComplex;
    }

    //public void save(Hashtable<HouseComplex, String> hashtable){}

    //public boolean checkHouseComplexId(){}
}
