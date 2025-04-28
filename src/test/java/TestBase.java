import com.codeborne.selenide.Configuration;
import demoqa.DataGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static demoqa.TestData.*;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "425x1080";
        Configuration.browser = "Firefox";
        Configuration.baseUrl = "https://demoqa.com";
    }

}
