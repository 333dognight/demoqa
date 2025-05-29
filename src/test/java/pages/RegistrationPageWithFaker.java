package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import demoqa.builders.DataGenerator;
import demoqa.builders.TestData;
import demoqa.models.RegistrationPageApiModel;
import org.junit.jupiter.api.BeforeEach;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static demoqa.builders.DataGenerator.fakerEN;
import static demoqa.builders.DataGenerator.fakerRU;
import static demoqa.builders.TestData.*;

public class RegistrationPageWithFaker {

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

    String[] subjectItems = {"Chemistry", "Physics", "English", "Arts"};

    public static RegistrationPageApiModel getRegistrationPageApiModel() {
        return RegistrationPageApiModel.builder()
                .firstName(fakerRU.name().firstName())
                .lastName(fakerRU.name().lastName())
                .userEmail(fakerEN.internet().emailAddress())
                .phoneNumber(fakerRU.expression("#{numerify '79#########'}"))
                .build();
    }

    public RegistrationPageWithFaker openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public RegistrationPageWithFaker fillFirstName() {
        firstNameInput.setValue(getRegistrationPageApiModel().getFirstName());
        return this;
    }

    public RegistrationPageWithFaker fillLastName() {
       lastNameInput.setValue(getRegistrationPageApiModel().getLastName());
       return this;
    }

    public RegistrationPageWithFaker fillUserEmail() {
        userEmailInput.setValue(getRegistrationPageApiModel().getUserEmail());
        return this;
    }

    public RegistrationPageWithFaker fillCurrentAddress() {
        currentAddressInput.setValue(DataGenerator.fakerRU.address().fullAddress());
        return this;
    }

    public RegistrationPageWithFaker fillPhoneNumber() {
        phoneNumberInput.setValue(getRegistrationPageApiModel().getPhoneNumber());
        return this;
    }

    public RegistrationPageWithFaker fillBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPageWithFaker fillSubjects() {
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

