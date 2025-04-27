package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    public void checkModalWindowIsAppear() {
        $(".modal-dialog").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
    }

    public void checkResultInModalWindow(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void checkModalWindowIsClose() {
        $("#closeLargeModal").click();
        $(".modal-content").shouldNot(appear);
    }

}
