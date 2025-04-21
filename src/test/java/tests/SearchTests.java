package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CookiePopUp;
import pages.MainPage;
import pages.SearchCatalogPage;
import pages.SearchInputPage;
@Tag("POSITIVE")
@Story("Позитивный тест")
@Owner("@perepelovaas")
public class SearchTests extends TestBase {
  CookiePopUp cookie = new CookiePopUp();
  SearchCatalogPage search = new SearchCatalogPage();
  SearchInputPage searchInput = new SearchInputPage();
  MainPage mainPage = new MainPage();

  @ParameterizedTest
  @ValueSource(strings = {
    "Офисное помещение",
    "Производство",
    "Оборудование"
  })
  @Tags({
    @Tag("SMOKE"),
    @Tag("WEB")
  })
  @Feature("Проверка поиска товара по категории")
  @Story("Позитивный тест")
  @Severity(SeverityLevel.CRITICAL)
  @DisplayName("Проверка поиска по категории каталога")
  void searchCatalogTestTest(String active) {
    mainPage.openMainPage();
    mainPage.checkMainHeader();
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    search.clickOnSearchBarItem(active);
    search.verifyCatalogContainsOfficeRooms(active);
  }

  @Test
  @Tags({
    @Tag("WEB")
  })
  @Feature("Проверка поиска товара по строке ввода")
  @Severity(SeverityLevel.CRITICAL)
  @DisplayName("Проверка поиска по строке ввода")
  void searchByInputStringTest() {
    mainPage.openMainPage();
    mainPage.checkMainHeader();
    cookie.checkCookiePopupDisplay();
    cookie.acceptCookie();
    searchInput.searchValue();
    searchInput.checkSearchResult();
  }
}
