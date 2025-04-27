package pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.DataGenerator;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    DataGenerator dataGenerator = new DataGenerator();
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String TITLE_TEXT = "Student Registration Form";

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            phoneNumberInput = $("#userNumber"),
            stateSelect = $("#stateCity-wrapper"),
            citySelect = $("#stateCity-wrapper");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
       lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setPhoneNumber() {
        phoneNumberInput.setValue(dataGenerator.randomPhoneNumber(10));
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage selectState(String state) {
        $("#state").click();
        stateSelect.$(byText(state)).click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        $("#city").click();
        citySelect.$(byText(city)).click();
        return this;
    }

    public RegistrationPage checkRegistrationModalWindow() {
        registrationResultsModal.checkModalWindowIsAppear();
        return this;
    }

    public RegistrationPage checkResultInModalWindow(String key, String value) {
        registrationResultsModal.checkResultInModalWindow(key, value);
        return this;
    }

    public RegistrationPage checkModalWindowIsClose() {
        registrationResultsModal.checkModalWindowIsClose();
        return this;
    }


}

