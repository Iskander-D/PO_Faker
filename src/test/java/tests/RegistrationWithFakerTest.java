package tests;

import data.TestData;
import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class RegistrationWithFakerTest extends TextBoxTests {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void fillformTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubjectsInput(testData.subjects)
                .setHobbies(testData.hobbies)
                .setPicture()
                .setCurrentAddress(testData.streetAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .pressSubmit();
        registrationPage.checkResult("Student Name", testData.firstName)
                .checkResult("Student Name", testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City", testData.state)
                .checkResult("State and City", testData.city);
    }

    @Test
    void minimalData() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .pressSubmit();
        registrationPage.checkResult("Student Name", testData.firstName + "\n" + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Mobile", testData.userNumber);

    }

    @Test
    void negativeTest() {
        registrationPage.openPage()
                .removeBanner()
                .pressSubmit()
                .checkNotCompleteForm();

    }

}


