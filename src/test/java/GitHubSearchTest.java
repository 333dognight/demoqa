import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSearchTest extends TestBase {
    @Test
    void checkSelenideRepositoryInTopOfTheSearchList() {
        // открыть браузер на странице github
        open("https://github.com/");
        // ввести в поиск Selenide и нажать Enter
        $(".header-search-button").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();

        // проверить, что репозиторий Selenide на 1-м месте в результатах поиска
        $("[data-testid='results-list']").$$("div").get(0).$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

        //SelenideElement secondItem = $$(".list .item").findBy(Condition.text("Второй"));
    }
}
