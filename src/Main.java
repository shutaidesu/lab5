
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
public class Main {
    //importnig the path to the file
    private static String filePath = System.getenv("FILE");

    private static boolean bid, bname, barea, bcreationdate, bnumberOfRooms;

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException
    {
        // Create a File object with appropriate xml file name
        File file = new File(filePath);

        // Function for accessing the data
        parser(file);
    }

    public static void parser(File file) throws FileNotFoundException,
            XMLStreamException
    {
        // Variables to make sure whether a element
        // in the xml is being accessed or not
        // if false that means elements is
        // not been used currently , if true the element or the
        // tag is being used currently
        barea = bid = bname = bcreationdate = bnumberOfRooms = false;

        // Instance of the class which helps on reading tags
        XMLInputFactory factory = XMLInputFactory.newInstance();

        // Initializing the handler to access the tags in the XML file
        XMLEventReader eventReader =
                factory.createXMLEventReader(new FileReader(file));

        // Checking the availability of the next tag
        while (eventReader.hasNext())
        {
            // Event is actually the tag . It is of 3 types
            // <name> = StartEvent
            // </name> = EndEvent
            // data between the StartEvent and the EndEvent
            // which is Characters Event
            XMLEvent event = eventReader.nextEvent();

            // This will trigger when the tag is of type <...>
            if (event.isStartElement())
            {
                StartElement element = (StartElement)event;

                // Iterator for accessing the metadeta related
                // the tag started.
                // Here, it would name of the company
                Iterator<Attribute> iterator = element.getAttributes();
                while (iterator.hasNext())
                {
                    Attribute attribute = iterator.next();
                    QName name = attribute.getName();
                    String value = attribute.getValue();
                    System.out.println(name+" = " + value);
                }

                // Checking which tag needs to be opened for reading.
                // If the tag matches then the boolean of that tag
                // is set to be true.
                if (element.getName().toString().equalsIgnoreCase("id"))
                {
                    bid = true;
                }
                if (element.getName().toString().equalsIgnoreCase("area"))
                {
                    barea = true;
                }
                if (element.getName().toString().equalsIgnoreCase("name"))
                {
                    bname = true;
                }
                if (element.getName().toString().equalsIgnoreCase("creationDate"))
                {
                    bcreationdate = true;
                }
                if (element.getName().toString().equalsIgnoreCase("numberOfRooms"))
                {
                    bnumberOfRooms = true;
                }
            }

            // This will be triggered when the tag is of type </...>
            if (event.isEndElement())
            {
                EndElement element = (EndElement) event;

                // Checking which tag needs to be closed after reading.
                // If the tag matches then the boolean of that tag is
                // set to be false.
                if (element.getName().toString().equalsIgnoreCase("id"))
                {
                    bid = false;
                }
                if (element.getName().toString().equalsIgnoreCase("area"))
                {
                    barea = false;
                }
                if (element.getName().toString().equalsIgnoreCase("name"))
                {
                    bname = false;
                }
                if (element.getName().toString().equalsIgnoreCase("creationDate"))
                {
                    bcreationdate = false;
                }
                if (element.getName().toString().equalsIgnoreCase("numberOfRooms"))
                {
                    bnumberOfRooms = false;
                }
            }

            // Triggered when there is data after the tag which is
            // currently opened.
            if (event.isCharacters())
            {
                // Depending upon the tag opened the data is retrieved .
                Characters element = (Characters) event;
                if (bid)
                {
                    System.out.println(element.getData());
                }
                if (barea)
                {
                    System.out.println(element.getData());
                }
                if (bname)
                {
                    System.out.println(element.getData());
                }
                if (bcreationdate)
                {
                    System.out.println(element.getData());
                }
                if (bnumberOfRooms)
                {
                    System.out.println(element.getData());
                }
            }
        }
    }

}


