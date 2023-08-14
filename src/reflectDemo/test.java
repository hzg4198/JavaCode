package reflectDemo;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.WeakHashMap;

public class test {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();
        System.out.println(Arrays.toString(fields));
    }
}
