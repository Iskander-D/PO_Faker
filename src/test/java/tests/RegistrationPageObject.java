package tests;

import org.junit.jupiter.api.Tag;
import pages.components.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationPageObject extends TextBoxTests {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("simple")
    void fillformTest() {

        registrationPage.openPage()
                .removeBanner()
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
    }

    @Test
    @Tag("simple")
    void minimalData() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Alexander")
                .setLastName("Drozenko")
                .setUserEmail("drozenko21@gmail.com")
                .setGender("Male")
                .setUserNumber("0506488515")
                .pressSubmit();
        registrationPage.checkResult("Student Name", "Alexander Drozenko")
                .checkResult("Student Email", "drozenko21@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0506488515");

    }

    @Test
    @Tag("simple")
    void negativeTest() {
        registrationPage.openPage()
                .removeBanner()
                .pressSubmit()
                .checkNotCompleteForm();

    }

}

