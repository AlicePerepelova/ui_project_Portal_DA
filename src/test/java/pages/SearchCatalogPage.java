package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchCatalogPage {
  private final SelenideElement searchBarItem = $(".search-bar-item__right");

  private final SelenideElement pageTitleElement = $("h1.content-layout__title");
  private final SelenideElement catalogGrid = $(".catalog-grid");


  @Step("Ищем {active}")
  public void clickOnSearchBarItem(String active) {
    catalogGrid.shouldBe(visible).shouldHave(text(active));
    searchBarItem.click();
    final SelenideElement officeRoomOption = $(byText(active));
    officeRoomOption.click();
  }

  @Step("Проверяем, что {active} нашлось")
  public void verifyCatalogContainsOfficeRooms(String active) {
    pageTitleElement.shouldHave(text(active));
    catalogGrid.shouldHave(text(active));
  }
}
