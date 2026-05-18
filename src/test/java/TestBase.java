import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        String remoteUrl = System.getProperty("selenide.remote");

        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
        }

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        Configuration.headless = false;



    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}