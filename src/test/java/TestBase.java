import com.codeborne.selenide.Configuration;
import demoqa.DataGenerator;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "425x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
