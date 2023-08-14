package reflectDemo;

public class Person {
    public String name;
    public String address;
    private int age;

    public Person(){}

    public Person(String name){
        this.name = name;
    }

    public Person(String name ,String address){
        this.name = name;
        this.address = address;
    }

    public Person(String name,String address,int age){
        this.name = name;
        this.address = address;
        this.age = age;
    }

    private Person(int age){
        this.name = "马云";
        this.address="杭州";
        this.age=age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
