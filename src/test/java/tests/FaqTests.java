package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CookiePopUp;
import pages.FaqPage;
import pages.MainPage;

@Tag("POSITIVE")
@Story("Позитивный тест")
@Owner("@perepelovaas")
public class FaqTests extends TestBase {
  FaqPage faqPage = new FaqPage();
  MainPage mainPage = new MainPage();
  CookiePopUp cookie = new CookiePopUp();

  @Test
  @Severity(SeverityLevel.TRIVIAL)
  @DisplayName("Проверка меню Помощь")
  void checkFaqTitleTest() {
    mainPage.openMainPage();
    mainPage.checkMainHeader();
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    mainPage.clickOnFaq();
    faqPage.checkTitleName();
    faqPage.checkTextInFaqStart();
    faqPage.checkTextInFaqBuying();
    faqPage.checkTextInFaqAuction();
    faqPage.checkTextInFaqPurchase();
    faqPage.checkTextInFaqSelling();
    faqPage.checkTextInFaqEds();
    faqPage.checkTextInFaqBankruptcy();
    faqPage.checkTextInFaqDocuments();
    faqPage.checkTextInFaqFeedsAutoload();
  }
}
