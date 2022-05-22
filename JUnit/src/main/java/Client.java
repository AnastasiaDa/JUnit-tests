import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client extends Animal {

    private Animal animal;
    private LocalDate date;
    private String illness;

    private static List<Client> clientList = new ArrayList<>();
    private static List<Client> todayClients = new ArrayList<>();
    private static List<Client> medicalHistory = new ArrayList<>();

    public Client() {
    }

    public Client(Animal animal, LocalDate date, String illness) {
        this.animal = animal;
        this.date = date;
        this.illness = illness;
    }

    public static void addNewClient(Client client) {
        clientList.add(client);
    }

    public static List<Client> getClientList() {
        return clientList;
    }

    //    метод, который выводит список клиентов по дате
    public static List<Client> outputTodayClients(int day, int month) {
        for (int i = 0; i < clientList.size(); i++) {
            if (day == clientList.get(i).getDate().getDayOfMonth() && month == clientList.get(i).getDate().getMonthValue()) {
                todayClients.add(clientList.get(i));
            }
        }
        return todayClients;
    }

    //    метод отображающий историю болезни клиента
    public static List<Client> outputMedicalHistory(String animalName, String ownerName) {
        for (int j = 0; j < clientList.size(); j++) {
            if (animalName.equals(clientList.get(j).getAnimal().getName()) && ownerName.equals(clientList.get(j).getAnimal().getNameOfOwner())) {
                medicalHistory.add(clientList.get(j));
            }
        }
        return medicalHistory;
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
