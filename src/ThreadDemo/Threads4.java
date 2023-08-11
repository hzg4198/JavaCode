package ThreadDemo;

import java.util.Objects;

public class Threads4{
    public static void main(String[] args){
        class B extends A{
        }
//        B b = new B();
//        b.method2();
//        b.method1();
//        B.method1();
//        String a;

        Integer a1 = new Integer(9);
        long a2 = 9;
        System.out.println(Objects.equals(a1, a2));
    }



}
class A {
    static void method1(){
        System.out.println("A的静态方法");
    }
    void method2(){
        System.out.println("A的非静态方法，实例方法");
    }
    final void method3(){
        System.out.println("A的静态私有方法");
    }

}
