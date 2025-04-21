package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CookiePopUp;
import pages.HeaderPage;
import pages.MainPage;

public class HeaderTests extends TestBase {
  HeaderPage header = new HeaderPage();
  MainPage mainPage = new MainPage();
  CookiePopUp cookie = new CookiePopUp();
  @Tag("POSITIVE")
  @Story("Позитивный тест")
  @Owner("@perepelovaas")
  @Test
  @Severity(SeverityLevel.BLOCKER)
  @DisplayName("Проверка переходов по хэдерам")
  void checkHeaderTest() {
    mainPage.openMainPage();
    mainPage.checkMainHeader();
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    header.clickHeaderBuy();
    header.checkHeaderBuy();
    header.clickHeaderRent();
    header.checkHeaderRent();
    header.clickHeaderServices();
    header.checkHeaderServices();
    header.clickHeaderTariffs();
    header.checkHeaderTariffs();
  }
}
