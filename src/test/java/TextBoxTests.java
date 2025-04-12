import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {

    String firstName = "Andrey";
    String lastName = "Petrov";
    String userEmail = "abc123@lookout.com";
    String currentAddress = "Москва, ул. Виноградная";
    String state = "NCR";
    String city = "Delhi";

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPhoneNumber()
                .setBirthDate("30", "December", "2002")
                .selectState(state)
                .selectCity(city);

        $("#gender-radio-1").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-1").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-2").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-3").click(ClickOptions.usingJavaScript());
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $("#closeLargeModal").click();
        $(".modal-content").shouldNotBe(visible);


    }
}
