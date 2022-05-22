import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ClientTest {

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

        Client.addNewClient(client1);
        Client.addNewClient(client2);
        Client.addNewClient(client3);
        Client.addNewClient(client4);

        List<Client> actual = new ArrayList<>();
        actual.add(client1);
        actual.add(client2);
        actual.add(client3);
        actual.add(client4);

        Assertions.assertNotNull(Client.getClientList());
        Assertions.assertEquals(Client.getClientList(), actual);
    }

    @Test
    @DisplayName("Тестированание вывода медицинской истории")
    void outputMedicalHistory() {

        Client.addNewClient(client1);
        Client.addNewClient(client2);
        Client.addNewClient(client3);
        Client.addNewClient(client4);

        List<Client> expected = Client.outputMedicalHistory("Barsik", "Masha");

        List<Client> actual = new ArrayList<>();
        actual.add(client2);
        actual.add(client3);

        List<Client> actual2 = new ArrayList<>();
        actual2.add(client1);
        actual2.add(client4);

        Assertions.assertNotEquals(expected, actual);
        Assertions.assertEquals(expected, actual2);
    }

    @Test
    @DisplayName("Тестирование вывода списка клиентов по дате")
    void outputTodayClient() {

        Client.addNewClient(client1);
        Client.addNewClient(client2);
        Client.addNewClient(client3);
        Client.addNewClient(client4);

        List<Client> expected = Client.outputTodayClients(15, 5);

        List<Client> actual = new ArrayList<>();
        actual.add(client3);

        Assertions.assertEquals(expected, actual);
    }
}
