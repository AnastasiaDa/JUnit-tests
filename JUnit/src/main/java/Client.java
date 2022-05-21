import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client extends Animal {

    private Animal animal;
    private static LocalDate date;
    private String illness;

    private static List<Client> clientList = new ArrayList<>();
    private static List<Client> todayClients = new ArrayList<>();
    private static List<Client> medicalHistory = new ArrayList<>();

    public Client() {}

    public Client(Animal animal, LocalDate date, String illness) {
        this.animal = animal;
        this.date = date;
        this.illness = illness;
    }

    public static void addNewClient (Client client) {
        clientList.add(client);
    }

    public static List<Client> getClientList() {
        return clientList;
    }

//    метод, который выводит список клиентов по дате
    public static List<Client> outputTodayClients(int day, int month) {
//        List<Client> todayClients = new ArrayList<>();
        for (int i = 0; i < clientList.size(); i++) {
            if (day == date.getDayOfMonth() && month == date.getMonthValue()) {
                todayClients.add(clientList.get(i));
            }
        }
        return todayClients;
    }

//    метод отображающий историю болезни клиента
    public static List<Client> outputMedicalHistory(String animalName, String ownerName) {
//        List<Client> medicalHistory = new ArrayList<>();
        for (Client client : clientList) {
            if (animalName.equals(client.getName()) && ownerName.equals(client.getNameOfOwner())) {
                medicalHistory.add(client);
            }
        }
        return medicalHistory;
    }

    @Override
    public String toString() {
        return "Client{" +
                "animal=" + animal +
                ", date=" + date +
                ", illness=" + illness +
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
