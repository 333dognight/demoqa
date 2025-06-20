import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideContributors extends TestBase {
    @Test
    void checkFirstPersonInContributorsBlock() {
        //open repository
        open("https://github.com/selenide/selenide/tree/main");
        //hover mouse over the first avatar in contribution block
        $("div .Layout-sidebar").find(byText("Contributors"))
                .ancestor("div").$$("ul li").first().hover();

        //check the first avatar in ASolntsev
        $$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
