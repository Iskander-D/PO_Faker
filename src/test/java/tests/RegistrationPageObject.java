package tests;

import components.RegistrationForm;
import org.junit.jupiter.api.Test;

public class RegistrationPageObject extends TextBoxTests {
    RegistrationForm registrationForm = new RegistrationForm();
    @Test
    void fillformTest() {
        registrationForm.openPage()
                .removePage()
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
                .setPicture("IMG_0063.JPG")
                .setCurrentAddress("Discovery gardens.")
                .setState("Uttar Pradesh")
                .setCity("Merrut")
                .pressSubmit();

        registrationForm.checkResult("Student Name", "Alexander Drozenko")
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
    void inputMinimalData()
    {
        registrationForm.openPage()
                .removePage()
                .setFirstName("Alexander")
                .setLastName("Drozenko")
                .setGender("Male")
                .setCurrentAddress("Discovery gardens.")
                .pressSubmit();

        registrationForm.checkResult("Student Name", "Alexander Drozenko")
                .checkResult("Gender", "Male")
                .checkResult("Address", "Discovery gardens.");

    }
    @Test
     void negativeTest()
    {
        registrationForm.openPage()
                    .removePage()
                    .pressSubmit()
                    .checkNotCompleteForm();

    }

}

