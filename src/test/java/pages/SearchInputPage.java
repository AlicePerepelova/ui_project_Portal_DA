package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchInputPage {
  private final SelenideElement inputSearch = $(".text-input__input"),
    inputQuery = $("#query"),
    buttonSearch = $(".ml-4");
  private ElementsCollection catalogGrid = $$(".catalog-grid");

  @Step("Поиск по строке ввода")
  public void searchValue(String searchQuery) {
    inputSearch.click();
    inputQuery.setValue(searchQuery);
    buttonSearch.click();
  }

  @Step("Проверка результатов поиска по строке ввода")
  public void checkSearchResult(String searchQuery) {

    catalogGrid.shouldHave(texts(searchQuery));
  }
}
