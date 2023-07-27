package _0717homework;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.io.File;

public class Demo {
    public static void main(String[] args) {
        //1
        System.out.println("---------------第一题--------------");
        List<String> studentList = new ArrayList<>();
        Collections.addAll(studentList,"张三,21","李四,23","王五,22","赵六,25");
        Student[] students = new Student[studentList.size()];
        for (int i = 0; i < studentList.size(); i++) {
            Student student =new Student(studentList.get(i));
            students[i] =student;
        }
        System.out.println(Arrays.toString(students));


        List<Student> list = studentList.stream().map(Student::new).collect(Collectors.toList());//创建学生集合
        //2
        System.out.println("-------------第二题---------------");
        List<String> nameList = list.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(nameList);
        //3
        System.out.println("-------------第三题------------------");

        List<String> collect = list.stream().map(o -> o.getName().concat("-").concat(String.valueOf(o.getAge()))).collect(Collectors.toList());
        System.out.println(collect);

    }



}
