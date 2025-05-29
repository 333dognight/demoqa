import demoqa.models.RegistrationPageApiModel;
import org.junit.jupiter.api.Test;
import pages.RegistrationPageWithFaker;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {

    RegistrationPageApiModel registrationPageApiModel;
    RegistrationPageWithFaker registrationPageWithFaker = new RegistrationPageWithFaker();

    String state = "NCR",
     city = "Delhi";


    @Test
    void fillFormTest() {

        registrationPageWithFaker.openPage()
                .fillFirstName()
                .fillLastName()
                .fillUserEmail()
                .selectGender("1")
                .fillCurrentAddress()
                .fillPhoneNumber()
                .fillBirthDate("30", "December", "2002")
                //.setSubjects()
                .selectHobbies("1")
                .selectHobbies("2")
                .selectHobbies("3")
                .selectState(state)
                .selectCity(city);

        $("#submit").click();

        registrationPageWithFaker.checkRegistrationModalWindow()
                .checkResultInModalWindow("Student Name", registrationPageApiModel.getFirstName())
                //.checkResultInModalWindow("Student Email", )
                //.checkResultInModalWindow("Gender", "Male")
                .checkModalWindowIsClose();

    }
}
