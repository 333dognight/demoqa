import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {

    String currentAddress = "Москва, ул. Виноградная",
     state = "NCR",
     city = "Delhi";


    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName()
                .setLastName()
                .setUserEmail()
                .selectGender("1")
                .setCurrentAddress(currentAddress)
                .setPhoneNumber()
                .setBirthDate("30", "December", "2002")
                .selectHobbies("1")
                .selectHobbies("2")
                .selectHobbies("3")
                .selectState(state)
                .selectCity(city);

        $("#submit").click();

        registrationPage.checkRegistrationModalWindow()
                .checkResultInModalWindow("Student Name", firstName + " " + lastName)
                .checkResultInModalWindow("Student Email", userEmail)
                .checkResultInModalWindow("Gender", "Male")
                .checkModalWindowIsClose();

    }
}
