package ru.netology.delivery.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
        var daysToAddForFirstMeeting = 4;
        var daysToAddForSecondMeeting = daysToAddForFirstMeeting + 7;

        
        // TODO: добавить логику теста в рамках которого будет выполнено планирование и перепланирование встречи.
        // Для заполнения полей формы можно использовать пользователя validUser и строки с датами в переменных
        // firstMeetingDate и secondMeetingDate. Можно также вызывать методы generateCity(locale),
        // generateName(locale), generatePhone(locale) для генерации и получения в тесте соответственно города,
        // имени и номера телефона без создания пользователя в методе generateUser(String locale) в датагенераторе

        $("[data-test-id='city'] .input__control").setValue(DataGenerator.generateCity("ru"));
        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(DataGenerator.generateDate(daysToAddForFirstMeeting));
        $("[data-test-id='name'] [name='name']").setValue(DataGenerator.generateName("ru"));
        $("[data-test-id='phone'] [name='phone']").setValue(DataGenerator.generatePhone("ru"));
        $("[data-test-id=agreement]").click();
        $(".button").click();
//        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(5));
//        $("[data-test-id='success-notification'] .notification__content")
//                .shouldHave(Condition.text("Встреча успешно забронирована на " + daysToAddForFirstMeeting), Duration.ofSeconds(15))
//                .shouldBe(visible);
        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(DataGenerator.generateDate(daysToAddForSecondMeeting));
        $(".button").click();
        $("[data-test-id='replan-notification'] .notification__content")
                .shouldHave(Condition.text("У вас уже запланирована встреча на другую дату." + " Перепланировать?"), Duration.ofSeconds(5))
                .shouldBe(visible);
        $(byText("Перепланировать")).click();
        $("[data-test-id='success-notification']").shouldHave(text("Встреча успешно запланирована на "
                + daysToAddForSecondMeeting));
    }




}
