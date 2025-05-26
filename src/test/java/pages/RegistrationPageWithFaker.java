package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import demoqa.builders.TestData;
import demoqa.models.RegistrationPageApiModel;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static demoqa.builders.TestData.*;

public class RegistrationPageWithFaker {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    Faker faker = new Faker(new Locale("ru"));
    TestData testData = new TestData();
    RegistrationPageApiModel registrationPageApiModel;

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

    String[] subjectItems = {"Chemistry", "Physics", "English", "Arts"};

    public RegistrationPageWithFaker openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public RegistrationPageWithFaker setFirstName() {
        firstNameInput.setValue(getRegistrationApiModel().getFirstName());
        return this;
    }

    public RegistrationPageWithFaker setLastName() {
       lastNameInput.setValue(getRegistrationApiModel().getLastName());
        return this;
    }

    public RegistrationPageWithFaker setUserEmail() {
        userEmailInput.setValue(getRegistrationApiModel().getUserEmail());
        return this;
    }

    public RegistrationPageWithFaker setCurrentAddress() {
        currentAddressInput.setValue(faker.address().fullAddress());
        return this;
    }

    public RegistrationPageWithFaker setPhoneNumber() {
        phoneNumberInput.setValue(faker.phoneNumber().subscriberNumber(10));
        return this;
    }

    public RegistrationPageWithFaker setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPageWithFaker setSubjects() {
        subjectInput.setValue(randomSubjectItem(subjectItems));
        return this;
    }

    public RegistrationPageWithFaker selectHobbies(String hobbiesCheckbox) {
        $("#hobbies-checkbox-" + hobbiesCheckbox).click(ClickOptions.usingJavaScript());
        return this;
    }

    public RegistrationPageWithFaker selectState(String state) {
        $("#state").click();
        stateSelect.$(byText(state)).click();
        return this;
    }

    public RegistrationPageWithFaker selectCity(String city) {
        $("#city").click();
        citySelect.$(byText(city)).click();
        return this;
    }

    public RegistrationPageWithFaker selectGender(String genderRadio) {
        $("#gender-radio-" + genderRadio).click(ClickOptions.usingJavaScript());
        return this;
    }

    public RegistrationPageWithFaker checkRegistrationModalWindow() {
        registrationResultsModal.checkModalWindowIsAppear();
        return this;
    }

    public RegistrationPageWithFaker checkResultInModalWindow(String key, String value) {
        registrationResultsModal.checkResultInModalWindow(key, value);
        return this;
    }

    public RegistrationPageWithFaker checkModalWindowIsClose() {
        registrationResultsModal.checkModalWindowIsClose();
        return this;
    }


}

