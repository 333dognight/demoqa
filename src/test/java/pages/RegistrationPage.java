package pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.DataGenerator;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    DataGenerator dataGenerator = new DataGenerator();
    CalendarComponent calendarComponent = new CalendarComponent();

    private final String TITLE_TEXT = "Student Registration Form";

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            phoneNumberInput = $("#userNumber");


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

    public RegistrationPage setCalendarDate() {
        calendarComponent.setDate();
        return this;
    }


}

