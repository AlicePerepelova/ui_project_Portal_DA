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
  String value = "Офисное помещение";
  private ElementsCollection catalogGrid = $$(".catalog-grid");

  @Step("Поиск по строке ввода")
  public void searchValue() {
    inputSearch.click();
    inputQuery.setValue(value);
    buttonSearch.click();
  }

  @Step("Проверка результатов поиска по строке ввода")
  public void checkSearchResult() {

    catalogGrid.shouldHave(texts("Офисное помещение"));
  }
}
