import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientTest {

    Client client1 = new Client(new Animal("Cat", "Barsik", 2, "Masha"),
            LocalDate.now(), Main.illnesses[(int) Math.random() * 10]);
    Client client2 = new Client(new Animal("Dog", "Sharik", 1, "Pasha"),
            LocalDate.now(), Main.illnesses[(int) Math.random() * 10]);
    Client client3 = new Client(new Animal("Hamster", "Mouse", 3, "Ira"),
            LocalDate.now(), Main.illnesses[(int) Math.random() * 10]);
    Client client4 = new Client(new Animal("Cat", "Barsik", 2, "Masha"),
            LocalDate.now(), Main.illnesses[(int) Math.random() * 10]);

    @Test
    public List<Client> outputTodayClients(int day, int month){

        List<Client> testList = new ArrayList<>();
        testList.add(client1);
        testList.add(client2);
        testList.add(client3);
        testList.add(client4);

        List<Client> expectList = Client.outputTodayClients(19, 05);

        Assertions.assertEquals(testList, expectList);

        return testList;
    }
}
