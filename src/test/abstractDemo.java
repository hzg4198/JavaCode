package test;

import javax.swing.table.TableCellEditor;
import java.util.Objects;

public  class abstractDemo {
    public static void main(String[] args) {
         int[] arr = new int[5];
        System.out.println(arr);
//        String a = "hello";
//        String b = "hello";
//        String c = new String("hello");
//        String d = new String("hello");
//        System.out.println(a==b);
//        System.out.println(a==c);
//        System.out.println(c==d);
//        System.out.println(Objects.equals(b,c));
    }

}
abstract class Class1{
    void A(){}//非抽象方法
    abstract void B();//抽象方法
    public Class1(){

    }

}
interface Class2{
    default void A(){
        System.out.println("接口1的A");
    }
    default void B(){}
    void C();
}
interface Class3{
    default void A(){
        System.out.println("接口2的A");
    }
    void D();
}
class Test extends Class1 implements Class2,Class3{
    @Override
    public void A() {
        Class2.super.A();
    }

    @Override
    public void D() {

    }

    @Override
    public void B() {
        Class2.super.B();
    }


    @Override
    public void C() {
        System.out.println("C");
    }
}
