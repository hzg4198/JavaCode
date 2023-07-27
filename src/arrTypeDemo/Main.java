package arrTypeDemo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[0];
        Person[] people = new Person[0];
        getValue(students);//由于Student类extends了Person类 即Student is-A Person
        getValue(people);
    }
    public static void getValue(Person[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
