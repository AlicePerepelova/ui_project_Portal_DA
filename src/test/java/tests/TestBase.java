package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import config.WebDriverProvider;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
  @BeforeEach
  void setUp()
  {
    WebDriverProvider.setUp();
    SelenideLogger.addListener("allure", new AllureSelenide());
  }
  @AfterEach
  public void tearDown() {
    Attach.screenshotAs("Last screen");
    Attach.addVideo();
    Attach.browserConsoleLogs();
    Attach.pageSource();
    closeWebDriver();
  }
}