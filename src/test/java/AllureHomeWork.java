import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebStepPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureHomeWork extends TestBase {

    WebStepPage webStepPage = new WebStepPage();
    private static final String REPOSITORY = "d2iq-archive/marathon";
    private static final int ISSUE = 7276;

    @Test
    @DisplayName("Поиск репозитория" + " " + REPOSITORY)
    public void allureHomeWork () {
            open("https://github.com");
            $(".search-input-container").click();
            $("#query-builder-test").setValue(REPOSITORY)
                    .submit();
            $(linkText(REPOSITORY)).click();
            $("#issues-repo-tab-count").click();
            $(withText("7276")).shouldBe(Condition.exist);
    }

    @Test
    @DisplayName("Поиск репозитория" + " " + REPOSITORY + " " + "LambdaSteps")
    public void allureHomeWorkLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").setValue(REPOSITORY)
                    .submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликаем ISSUES ", () -> {
            $("#issues-repo-tab-count").click();
        });
        step("Ищем наличие ISSUE с номером " + ISSUE, () -> {
            $(withText("7276")).shouldBe(Condition.exist);
        });
    }


    @Test
    @DisplayName("Поиск репозитория" + " " + REPOSITORY + " " + "AnnotatedStep")
    public void allureHomeWorkAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        webStepPage.repositorySeaech(REPOSITORY)
                .clickOnRepositoryLink(REPOSITORY)
                .clickOnIssueLink()
                .searchIssueNumberOnPage(ISSUE);
    }


}
