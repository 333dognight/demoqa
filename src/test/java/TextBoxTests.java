import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import demoqa.DataGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    DataGenerator dataGenerator = new DataGenerator();

    @BeforeAll

    static void beforeAll() {
        Configuration.browserSize = "425x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }


    String userName = "Andrey";
    String userEmail = "abc123@lookout.com";
    String currentAddress = "Москва, ул. Виноградная";
    String phoneNumber = dataGenerator.randomPhoneNumber(10);

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        $("#firstName").setValue(userName);
        $("#lastName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-1").click(ClickOptions.usingJavaScript());
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").scrollIntoView(true).click();
        $("#dateOfBirthInput").clear();
        $("#dateOfBirthInput").setValue(dataGenerator.RandomDate());
        $("#hobbies-checkbox-1").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-2").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-3").click(ClickOptions.usingJavaScript());
        $("#state").click();
        $$("#state").shouldBe(CollectionCondition.sizeGreaterThan(0));
        $$("#state").find(Condition.text("NCR")).click();
        $("#city").click();
        $$("#city").shouldBe(CollectionCondition.sizeGreaterThan(0));
        $$("#city").find(Condition.text("Delhi")).click();
        $("#currentAddress").setValue(currentAddress);
        $("#submit").click();
        $("#output").shouldBe(visible);

        $(".modal-content").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

    }
}
