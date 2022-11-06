package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.properties.Property;
import guru.qa.utils.AddAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.browser = Property.browser();
        Configuration.browserVersion = Property.browserVersion();
        Configuration.browserSize = Property.browserSize();
        if (!Property.remoteUrl().equals("")) {
            Configuration.remote = Property.remoteUrl();
        }
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void addAttachments() {
        AddAttachments.screenshotAs("Last screenshot");
        AddAttachments.addVideo();
        AddAttachments.pageSource();
        AddAttachments.browserConsoleLogs();
    }

}
