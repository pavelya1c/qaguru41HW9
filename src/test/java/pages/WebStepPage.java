package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class WebStepPage {

    @Step("Выполнение поиска репозитория")
    public WebStepPage repositorySeaech(String value) {
        $(".search-input-container").click();
        $("#query-builder-test").setValue(value)
                .submit();
        return this;
    }

    @Step("Нажатие на ссылку репозитория")
    public WebStepPage clickOnRepositoryLink(String value) {
        $(linkText(value)).click();
        return this;
    }

    @Step("Нажатие на ISSUE")
    public WebStepPage clickOnIssueLink() {
        $("#issues-repo-tab-count").click();
        return this;
    }

    @Step("Поиск ISSUE с номером")
    public WebStepPage searchIssueNumberOnPage(int value) {
        $(withText(value + "")).shouldBe(Condition.exist);
        return this;
    }


}
