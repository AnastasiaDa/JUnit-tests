import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clinic {

    public static String[] illnesses = {
            "cold",
            "conjunctivitis",
            "arthritis",
            "paw fracture",
            "bronchitis",
            "tonsillitis",
            "pneumonia",
            "gastritis",
            "covid-19",
            "depression"};

    private static Scanner scanner = new Scanner(System.in);

    static List<Client> clientList = new ArrayList<>();
    static List<Client> todayClients = new ArrayList<>();
    static List<Client> medicalHistory = new ArrayList<>();

    public static void addNewClient(Client client) {
        clientList.add(client);
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

    public static void outputMenuClinic() {
        System.out.println("You are welcomed by the veterinary clinic \"33 parrots\"!");

        while (true) {
            System.out.format("Please choose the number of the next step \n" +
                    "1. Enter the information about a Client \n" +
                    "2. Show a list of all clients \n" +
                    "3. Show the list of Clients for the date \n" +
                    "4. Show the medical story \n" +
                    "5. Exit the menu \n");

            try {
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                Client patient = null;

                switch (number) {
                    case 1:
                        try {
                            patient = enterClient();
                            Clinic.addNewClient(patient);
                            continue;
                        } catch (Exception en) {
                            System.out.println("Please enter your pet's age in numbers");
                            continue;
                        }

                    case 2:
                        clientList.forEach(System.out::println);
                        continue;

                    case 3:
                        System.out.println("Enter the day ");
                        String inputDay = scanner.nextLine();
                        int setDay = Integer.parseInt(inputDay);

                        System.out.println("Enter the month ");
                        String inputMonth = scanner.nextLine();
                        int setMonth = Integer.parseInt(inputMonth);

                        System.out.println(outputTodayClients(setDay, setMonth));
                        continue;

                    case 4:
                        System.out.println("Please enter the name of your pet");
                        String petName = scanner.nextLine();
                        System.out.println("Please enter your name");
                        String ownerName = scanner.nextLine();
                        outputMedicalHistory(petName, ownerName);

                        System.out.println(outputMedicalHistory(petName, ownerName));
                        continue;

                    case 5:
                        System.out.println("Have a nice day! Take care!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Mistake! Please enter the number from 1 to 5");
            }
        }
    }

    public static Client enterClient() throws NumberFormatException {
        System.out.println("What kind of pet did you bring to us?");
        String petType = scanner.nextLine();

        System.out.println("What is the name of your pet?");
        String petName = scanner.nextLine();

        System.out.println("How old is your " + petName + " ?");
        String inputAge = scanner.nextLine();
        Double petAge = Double.parseDouble(inputAge);

        System.out.println("Please tell me your name");
        String ownerName = scanner.nextLine();

        Animal pet = new Animal(petType, petName, petAge, ownerName);
        Client patient = new Client(pet, LocalDate.now(), illnesses[(int) (Math.random() * 10)]);
        return patient;
    }

    public static List<Client> getClientList() {
        return clientList;
    }
}
