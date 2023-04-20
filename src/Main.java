import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Hashtable;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        //importnig the path to the file
        String filePath = System.getenv("FILE");



        try {
            InputStream is = new FileInputStream(filePath);
            Reader isr = new InputStreamReader(is);
            int data = isr.read();
            while(data != -1){
                data = isr.read();
                char chr = (char) data;
                System.out.print(chr);
            }
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            String text = "Hello user! It's test setup";
            bw.write(text);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

}


