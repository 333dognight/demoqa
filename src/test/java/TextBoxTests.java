import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import demoqa.DataGenerator;
import org.junit.jupiter.api.Test;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {

    DataGenerator dataGenerator = new DataGenerator();
    CalendarComponent calendarComponent = new CalendarComponent();

    String firstName = "Andrey";
    String lastName = "Petrov";
    String userEmail = "abc123@lookout.com";
    String currentAddress = "Москва, ул. Виноградная";

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPhoneNumber()
                .setCalendarDate();

        $("#gender-radio-1").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-1").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-2").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-3").click(ClickOptions.usingJavaScript());
        $("#state").click();
        $$("#state").shouldBe(CollectionCondition.sizeGreaterThan(0));
        $$("#state").find(Condition.text("NCR")).click();
        $("#city").click();
        $$("#city").shouldBe(CollectionCondition.sizeGreaterThan(0));
        $$("#city").find(Condition.text("Delhi")).click();
        $("#submit").click();
        $("#output").shouldBe(visible);

        $(".modal-content").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

    }
}
