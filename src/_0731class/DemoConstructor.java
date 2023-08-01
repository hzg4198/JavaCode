package _0731class;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class DemoConstructor {
    public static void main(String[] args) {
        //获取class对象
        Class<Person> personClass = Person.class;
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }


    }
}
