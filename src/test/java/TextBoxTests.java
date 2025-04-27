import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {

    String firstName = "Andrey";
    String lastName = "Petrov";
    String userEmail = "abc123@lookout.com";
    String currentAddress = "Москва, ул. Виноградная";
    String state = "NCR";
    String city = "Delhi";
    String genderRadio = "1";


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

        $("#gender-radio-" + genderRadio).click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-1").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-2").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-3").click(ClickOptions.usingJavaScript());
        $("#submit").click();

        registrationPage.checkRegistrationModalWindow()
                .checkResultInModalWindow("Student Name", firstName + " " + lastName)
                .checkResultInModalWindow("Student Email", userEmail)
                .checkResultInModalWindow("Gender", "Male")
                .checkModalWindowIsClose();

    }
}
