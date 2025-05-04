import demoqa.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPageWithFaker;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {

    RegistrationPageWithFaker registrationPageWithFaker = new RegistrationPageWithFaker();
    TestData testData = new TestData();

    String state = "NCR",
     city = "Delhi";


    @Test
    void fillFormTest() {

        registrationPageWithFaker.openPage()
                .setFirstName()
                .setLastName()
                .setUserEmail()
                .selectGender("1")
                .setCurrentAddress()
                .setPhoneNumber()
                .setBirthDate("30", "December", "2002")
                //.setSubjects()
                .selectHobbies("1")
                .selectHobbies("2")
                .selectHobbies("3")
                .selectState(state)
                .selectCity(city);

        $("#submit").click();

        registrationPage.checkRegistrationModalWindow()
                //.checkResultInModalWindow("Student Name", )
                //.checkResultInModalWindow("Student Email", )
                //.checkResultInModalWindow("Gender", "Male")
                .checkModalWindowIsClose();

    }
}
