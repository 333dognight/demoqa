import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "425x1080";
        //Configuration.browser = "Firefox";
        Configuration.baseUrl = "https://demoqa.com";
    }

}
