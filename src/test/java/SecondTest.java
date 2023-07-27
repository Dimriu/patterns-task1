import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.delivery.data.DataGenerator;

import java.util.Locale;


public class SecondTest {

//    private Faker faker;
//
//    @BeforeEach
//    void setUpAll() {
//        faker = new Faker(new Locale("ru"));
//    }

    @Test
    void shouldPreventSendRequestMultipleTimes() {
        String date = DataGenerator.generateDate(3);
        String city = DataGenerator.generateCity("ru");
        String name = DataGenerator.generateName("ru");
        String phone = DataGenerator.generatePhone("ru");
        System.out.println(date);
        System.out.println(city);
        System.out.println(name);
        System.out.println(phone);

//        String user = String.valueOf(DataGenerator.Registration.generateUser("ru"));
//        System.out.println(user);


    }

    @Test
    void shouldPreventSendRequestMultipleTimes_1() {
        String date = DataGenerator.generateDate(3);
        String city = DataGenerator.generateCity("ru");
        String name = DataGenerator.generateName("ru");
        String phone = DataGenerator.generatePhone("ru");
        System.out.println(date);
        System.out.println(city);
        System.out.println(name);
        System.out.println(phone);

//        String user = String.valueOf(DataGenerator.Registration.generateUser("ru"));
//        System.out.println(user);


    }




}