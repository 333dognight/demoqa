import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.RegistrationPage;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.setBinary("C:/chrome-for-testing/chrome-win64/Chrome.exe");
        Configuration.browserCapabilities = chromeOptions;


        //Configuration.browserSize = "425x1080";
        //Configuration.browser = "Firefox";
        Configuration.baseUrl = "https://demoqa.com";

    }

}
