package classDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo {
    public static void main(String[] args) throws IOException {
        readCnText();
    }

    private static void readCnText() throws IOException {
        FileReader fr = new FileReader("Test.txt");
        int ch = 0;
        while ((ch = fr.read())!= -1){
            System.out.println(ch);
            System.out.println((char) ch);
        }
    }

}
