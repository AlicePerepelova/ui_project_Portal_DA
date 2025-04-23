package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CookiePopUp;
import pages.MainPage;
import pages.RuStorePage;

@Tag("POSITIVE")
@Story("Позитивный тест")
@Owner("@perepelovaas")
public class SwitchToRuStoreTests extends TestBase {
  MainPage mainPage = new MainPage();
  CookiePopUp cookie = new CookiePopUp();
  RuStorePage ruStorePage = new RuStorePage();

  @Test
  @Severity(SeverityLevel.TRIVIAL)
  @DisplayName("Проверка кнопки 'Скачать приложение в RuStore")
  void checkBtnRuStore() {
    String url="https://www.rustore.ru/catalog/app/ru.activebc.portal.da";
    Configuration.pollingInterval = 500;
    mainPage.openMainPage();
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    ruStorePage.clickRuStoreBtn();
    ruStorePage.checkRuStoreOpened(url);
  }
}
