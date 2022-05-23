import java.time.LocalDate;

public class Client {

    private Animal animal;
    private LocalDate date;
    private String illness;

    public Client() {
    }

    public Client(Animal animal, LocalDate date, String illness) {
        this.animal = animal;
        this.date = date;
        this.illness = illness;
    }

    @Override
    public String toString() {
        return "\n Client{" + animal + "\n" +
                "date=" + date + "\n" +
                "illness=" + illness +
                '}';
    }

    public Animal getAnimal() {
        return animal;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getIllness() {
        return illness;
    }

}
