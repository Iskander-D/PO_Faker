package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class RegistrationForm {
    CalendarComponents calendarComponents = new CalendarComponents();
    TableComponents tableComponents = new TableComponents();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesSelector = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            pressSubmitButton = $("#submit");


    public RegistrationForm openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationForm removePage() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove");
        return this;
    }

    public RegistrationForm setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationForm setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationForm setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationForm setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationForm setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationForm setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponents.setDate(day, month, year);
        return this;
    }

    public RegistrationForm setHobbies(String value) {
        hobbiesSelector.$(byText(value)).click();
        return this;
    }

    public RegistrationForm setSubjectsInput(String value) {
        subjectsInput.val(value).pressEnter();
        return this;
    }

    public RegistrationForm setPicture(String image) {
        uploadPictureInput.uploadFromClasspath("IMG_0063.JPG");
        return this;
    }

    public RegistrationForm setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationForm setState(String value) {
        selectState.val(value).pressEnter();
        return this;
    }

    public RegistrationForm setCity(String value) {
        selectCity.val(value).pressEnter();
        return this;
    }

    public RegistrationForm pressSubmit() {
        pressSubmitButton.pressEnter();
        return this;
    }

    public RegistrationForm checkResult(String key, String value) {
       tableComponents.checkTableResult(key, value);

        return this;
    }
    public RegistrationForm checkNotCompleteForm() {
        firstNameInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }
}

