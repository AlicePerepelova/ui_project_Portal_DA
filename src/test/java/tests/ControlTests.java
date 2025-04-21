package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.ControlPage;
import pages.CookiePopUp;
import pages.MainPage;

public class ControlTests extends TestBase {
  private MainPage mainPage = new MainPage();
  private CookiePopUp cookie = new CookiePopUp();
  private ControlPage control = new ControlPage();
  @Tag("POSITIVE")
  @Story("Позитивный тест")
  @Owner("@perepelovaas")
  @ParameterizedTest
  @Severity(SeverityLevel.TRIVIAL)
  @DisplayName("Проверка контролов")
  @ValueSource(ints = {
    18, 27, 54
  })
  void checkControlTest(int itemCount) {

    Configuration.pollingInterval = 500;
    mainPage.openMainPage();
    mainPage.checkMainHeader();
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    control.searchItem();
    control.selectControl(itemCount);
    control.checkControl(itemCount);
  }
}
