package sample;

public class Person{
    private String name;
    private String age;
    private String address;


    public Person(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(){
        this("name is Unknown","30","address is unknown");
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getAge() {
        return age;
    }

    public final void setAge(String age) {
        this.age = age;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        this.address = address;
    }

}
