package classDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InputStream inputStream = Files.newInputStream(Paths.get("prop.properties"));
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Person p = (Person) objectInputStream.readObject();
        System.out.println(p);
    }
}
