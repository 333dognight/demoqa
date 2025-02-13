import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @Test
    void fillFormTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

        open("/text-box");
        $("#userName").setValue("Andrey");
        $("#userEmail").setValue("abc123@lookout.com");
        $("#currentAddress").setValue("Москва, ул. Виноградная");
        $("#permanentAddress").setValue("Санкт-Петербург, ул. Московская");
        $("#submit").click();
        $("#output").shouldBe(visible);

    }
}
