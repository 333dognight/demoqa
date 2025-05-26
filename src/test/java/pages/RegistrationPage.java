package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static demoqa.builders.TestData.*;

public class RegistrationPage {
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
            citySelect = $("#stateCity-wrapper"),
            subjectInput = $("#subjectsContainer");

    String[] subjectItems = {"seed", "123987", "cherry", "bench", "bird", "Verstappen"};



    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public RegistrationPage setFirstName() {
        firstNameInput.setValue(randomString(10));
        return this;
    }

    public RegistrationPage setLastName() {
       lastNameInput.setValue(randomString(10));
        return this;
    }

    public RegistrationPage setUserEmail() {
        userEmailInput.setValue(randomEmail(10));
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setPhoneNumber() {
        phoneNumberInput.setValue(randomPhone("+7", 111111111L, 999999999L));
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects() {
        subjectInput.setValue(randomSubjectItem(subjectItems));
        return this;
    }

    public RegistrationPage selectHobbies(String hobbiesCheckbox) {
        $("#hobbies-checkbox-" + hobbiesCheckbox).click(ClickOptions.usingJavaScript());
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

    public RegistrationPage selectGender(String genderRadio) {
        $("#gender-radio-" + genderRadio).click(ClickOptions.usingJavaScript());
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

