package tests;

import org.junit.jupiter.api.Tag;
import pages.components.RegistrationPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationPageObject extends TextBoxTests {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("simple")
    void fillformTest() {
        step("Открываем страницу с формой", () -> {

            registrationPage.openPage();
        });
        step("Убираем рекламу", () -> {

            registrationPage.removeBanner();
        });
        step("Заполняем обязательные поля", () -> {

            registrationPage

                    .setFirstName("Alexander")
                    .setLastName("Drozenko")
                    .setUserEmail("drozenko21@gmail.com")
                    .setGender("Male")
                    .setUserNumber("0506488515")
                    .setDateOfBirth("21", "September", "1993")
                    .setSubjectsInput("Arts")
                    .setHobbies("Sports")
                    .setHobbies("Reading")
                    .setHobbies("Music")
                    .setPicture()
                    .setCurrentAddress("Discovery gardens.")
                    .setState("Uttar Pradesh")
                    .setCity("Merrut")
                    .pressSubmit();
        });
        step("Проверяем отображение введенных значений в таблице", () -> {
            registrationPage.checkResult("Student Name", "Alexander Drozenko")
                    .checkResult("Student Email", "drozenko21@gmail.com")
                    .checkResult("Gender", "Male")
                    .checkResult("Mobile", "0506488515")
                    .checkResult("Date of Birth", "21 September,1993")
                    .checkResult("Subjects", "Arts")
                    .checkResult("Hobbies", "Sports, Reading, Music")
                    .checkResult("Picture", "IMG_0063.JPG")
                    .checkResult("Address", "Discovery gardens.")
                    .checkResult("State and City", "Uttar Pradesh Merrut");
        });

    }

    @Test
    @Tag("positive")
    void minimalData() {
        step("Открываем страницу с формой", () -> {

            registrationPage.openPage();
        });
        step("Убираем рекламу", () -> {

            registrationPage.removeBanner();
        });
        step("Заполняем обязательные поля", () -> {
            registrationPage
                    .setFirstName("Alexander")
                    .setLastName("Drozenko")
                    .setUserEmail("drozenko21@gmail.com")
                    .setGender("Male")
                    .setUserNumber("0506488515")
                    .pressSubmit();
        });
        step("Проверяем отображение введенных значений в таблице", () -> {
            registrationPage.checkResult("Student Name", "Alexander Drozenko")
                    .checkResult("Student Email", "drozenko21@gmail.com")
                    .checkResult("Gender", "Male")
                    .checkResult("Mobile", "0506488515");
        });

    }

    @Test
    @Tag("negative")
    void negativeTest() {

        step("Открываем страницу с формой", () -> {

            registrationPage.openPage();
        });
        step("Убираем рекламу", () -> {

            registrationPage.removeBanner();
        });
        step("Подтверждаем заполнение полей данных кнопкой Submit", () -> {
            registrationPage.pressSubmit();
        });


        step("Проверяем что обязательные поля выделены красным цветом", () -> {
            registrationPage
                    .checkNotCompleteForm();
        });


    }

}

