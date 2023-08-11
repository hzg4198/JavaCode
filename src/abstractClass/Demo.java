package abstractClass;

abstract class Person {
    public static String name = "jack";
    static void sayHello(String name){
        System.out.println(name+",hello");
    }
    abstract void eat();
}

class Javier extends Person{

    //继承抽象类的类必须重写父类所有的抽象方法
    @Override
    void eat() {
        System.out.println("eat apple");
    }
}

public class Demo {
    public static void main(String[] args) {
        System.out.println(Person.name);
        System.out.println(Javier.name);
        Person.sayHello("jack");
        Javier javier = new Javier();
        javier.eat();
    }
}


