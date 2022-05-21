import java.util.*;

public class Animal {

    private String type;
    private String name;
    private int age;
    private String nameOfOwner;

    public Animal() {}

    public Animal(String type, String name, int age, String nameOfOwner) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.nameOfOwner = nameOfOwner;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nameOfOwner='" + nameOfOwner + '\'' +
                '}';
    }
}
