package classDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectStream {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = Files.newOutputStream(Paths.get("prop.properties"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(new Person("niko",12,"chengdu"));
        objectOutputStream.close();
    }
}
