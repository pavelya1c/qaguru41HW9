import com.codeborne.selenide.Configuration;

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