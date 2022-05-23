import java.util.*;

public class Animal {

    private String type;
    private String name;
    private double age;
    private String nameOfOwner;

    public Animal() {
    }

    public Animal(String type, String name, double age, String nameOfOwner) {
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

    public double getAge() {
        return age;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    @Override
    public String toString() {
        return "\n Animal{" + "\n" +
                "  type= " + type + "\n" +
                "  name= " + name + "\n" +
                "  age= " + age + "\n" +
                "  nameOfOwner= " + nameOfOwner;
    }
}
