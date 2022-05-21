import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

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

    public static void main(String[] args) {

        System.out.println("You are welcomed by the veterinary clinic \"33 parrots\"!");

        while (true) {
            System.out.format("Please choose the number of the next step \n" +
                    "1. Enter the information about a Client \n" +
                    "2. Show a list of all clients \n" +
                    "3. Show the list of Clients for the date \n" +
                    "4. Show the medical story \n" +
                    "5. Exit the menu \n");

            String input = scanner.nextLine();
            int number = Integer.parseInt(input);
            Client patient = null;

            switch (number) {
                case 1:
                    patient = enterClient();
                    Client.addNewClient(patient);
                    continue;
                    
                case 2:
                    patient.getClientList().forEach(System.out::println);
                    continue;

                case 3:
                    System.out.println("Enter the day ");
                    String inputDay = scanner.nextLine();
                    int setDay = Integer.parseInt(inputDay);

                    System.out.println("Enter the month ");
                    String inputMonth = scanner.nextLine();
                    int setMonth = Integer.parseInt(inputMonth);

                    System.out.println(patient.outputTodayClients(setDay, setMonth));
                    continue;

                case 4:
                    System.out.println("Please enter the name of your pet");
                    String petName = scanner.nextLine();
                    System.out.println("Please enter your name");
                    String ownerName = scanner.nextLine();
//                    patient.outputMedicalHistory(petName, ownerName);

                    System.out.println(Client.outputMedicalHistory(petName, ownerName));
                    continue;

                case 5:
                    System.out.println("Have a nice day! Take care!");
                    break;
            }
        }
    }

    public static Client enterClient () {
        System.out.println("What kind of pet did you bring to us?");
        String petType = scanner.nextLine();

        System.out.println("What is the name of your pet?");
        String petName = scanner.nextLine();

        System.out.println("How old is your " + petName + " ?");
        String inputAge = scanner.nextLine();
        int petAge = Integer.parseInt(inputAge);

        System.out.println("Please tell me your name");
        String ownerName = scanner.nextLine();

        Animal pet = new Animal(petType, petName, petAge, ownerName);
        Client patient = new Client(pet, LocalDate.now(), illnesses[(int) Math.random() * 10]);
        return patient;
    }
}
