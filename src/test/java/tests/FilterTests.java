package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CookiePopUp;
import pages.FilterPage;
import pages.MainPage;

public class FilterTests extends TestBase {
  private MainPage mainPage = new MainPage();
  private CookiePopUp cookie = new CookiePopUp();
  private FilterPage filter = new FilterPage();
  @Tag("POSITIVE")
  @Story("Позитивный тест")
  @Owner("@perepelovaas")
  @Test
  @Severity(SeverityLevel.BLOCKER)
  @DisplayName("Проверка фильтра")
  void checkFilterTest() {
    mainPage.openMainPage();
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    filter.openFilter();
    filter.selectRegion();
    filter.selectPriceRange();
    filter.selectSaleMethod();
    filter.selectSellerSelection();
    filter.selectPledgeStatus();
    filter.selectBankruptcy();
    filter.selectExecutionProcedure();
    filter.clickShowButton();
    filter.verifyCatalogItemsCount(1);
    filter.verifyCatalogNotEmpty();
    filter.verifyActiveFiltersDisplayed(11,11555);
  }
}
