package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchCatalogPage {
  private final SelenideElement searchBarItem = $(".search-bar-item__right");
  private final SelenideElement pageTitleElement = $("h1.content-layout__title");
  private final SelenideElement catalogGrid = $(".asset-category-menu__popular");


  @Step("Ищем {active}")
  public void clickOnSearchBarItem(String active) {
    searchBarItem.shouldBe(interactable).click();
    catalogGrid.shouldBe(visible).shouldHave(text(active));
    final SelenideElement officeRoomOption = $(byText(active));
    officeRoomOption.click();
  }

  @Step("Проверяем, что {active} нашлось")
  public void verifyCatalogContainsOfficeRooms(String active) {
    pageTitleElement.shouldHave(text(active));
  }
}
