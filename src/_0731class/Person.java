package _0731class;

public class Person {
    public String name;
    public int age;
    public String address;
    public Person(){
        System.out.println("空参构造方法");
    }
    public Person(String name){
        System.out.println("带有String的构造方法");
    }
    private Person(String name ,int age){
        System.out.println("私有构造方法");
    }
    public Person(String name ,int age ,String address){
        System.out.println("带有String，age，String的构造方法");
    }
    public void f1(){
        System.out.println("没有返回值没有参数的方法");
    }
    public void f2(String name){
        System.out.println("有参数，没有返回值的方法="+name);
    }
    public void f3(){
        System.out.println("有返回值没有参数的方法");
    }
    public String f4(String name){
        System.out.println("有返回值有参数的方法");
        return "haha"+name;
    }
    private void f5(){
        System.out.println("私有方法");
    }
}
