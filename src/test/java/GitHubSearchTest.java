import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSearchTest extends TestBase {
    @Test
    void checkSelenideRepositoryInTopOfTheSearchList() {
        // открыть браузер на странице github
        open("https://github.com/");
        // ввести в поиск Selenide и нажать Enter
        $(".header-search-button").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();

        // проверить, что репозиторий Selenide на 1-м месте в результатах поиска
        $("#results-list div").click();

    }
}
