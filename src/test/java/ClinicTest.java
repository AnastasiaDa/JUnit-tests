import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClinicTest {

    static LocalDate day = LocalDate.of(2022, 5, 10);

    static Client client1 = new Client(new Animal("Cat", "Barsik", 2, "Masha"),
            day, "cold");
    static Client client2 = new Client(new Animal("Dog", "Sharik", 1, "Pasha"),
            day.plusDays(2), "cold");
    static Client client3 = new Client(new Animal("Hamster", "Mouse", 3, "Ira"),
            day.plusDays(5), "cold");
    static Client client4 = new Client(new Animal("Cat", "Barsik", 2, "Masha"),
            day.plusDays(7), "cold");

    @Test
    @DisplayName("Тестирование добавления новых клиентов")
    void addNewClient() {

        Clinic.addNewClient(client1);
        Clinic.addNewClient(client2);
        Clinic.addNewClient(client3);
        Clinic.addNewClient(client4);

        List<Client> expected = new ArrayList<>();
        expected.add(client1);
        expected.add(client2);
        expected.add(client3);
        expected.add(client4);

        List<Client> actual = Clinic.getClientList();

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тестированание вывода медицинской истории")
    void outputMedicalHistory() {

        Clinic.addNewClient(client1);
        Clinic.addNewClient(client2);
        Clinic.addNewClient(client3);
        Clinic.addNewClient(client4);

        List<Client> actual = Clinic.outputMedicalHistory("Barsik", "Masha");

        List<Client> expected = new ArrayList<>();
        expected.add(client2);
        expected.add(client3);

        List<Client> expected2 = new ArrayList<>();
        expected2.add(client1);
        expected2.add(client4);

        Assertions.assertNotEquals(expected, actual);
        Assertions.assertEquals(expected2, actual);
    }

    @Test
    @DisplayName("Тестирование вывода списка клиентов по дате")
    void outputTodayClient() {

        Clinic.addNewClient(client1);
        Clinic.addNewClient(client2);
        Clinic.addNewClient(client3);
        Clinic.addNewClient(client4);

        List<Client> actual = Clinic.outputTodayClients(15, 5);

        List<Client> expected = new ArrayList<>();
        expected.add(client3);

        Assertions.assertEquals(expected, actual);
    }
}
