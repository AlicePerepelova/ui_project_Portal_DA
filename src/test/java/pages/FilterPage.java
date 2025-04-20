package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FilterPage {
  private final SelenideElement
    filterDialogCard = $(".base-dialog-card--nopadding"),
    regionDropdown = $(byText("Все регионы и населенные пункты")),
    filterButton = $(byText("Фильтры")),
    moscowOption = $(byText("Москва")),
    readyButton = $(byText("Готово")),
    priceFilter = $("[test_id='filter_price']"),
    priceDropdownCard = $(".search-bar-dropdown-dialog"),
    minPriceInputField = $(".search-bar-dropdown-dialog input"),
    saleTypeDropdown = $("[test_id='filter_sale_type']"),
    pricePopup = $(".search-bar-dropdown-dialog"),
    readyButtonPrice = pricePopup.$(byText("Готово")),
    directPurchaseOption = $("#filter-sale_type-direct_purchase"),
    tradeOption = $("#filter-sale_type-trade"),
    biddingOption = $("#filter-sale_type-bidding"),
    sellerFilter = $("[test_id='filter_seller']"),
    sellerSearchBar = $(".search-bar-sellers-dropdown"),
    typeSelectButton = $(byText("По типу")),
    bankSellerOption = $("#filter-seller_type-bank"),
    governmentSellerOption = $("#filter-seller_type-government"),
    companySellerOption = $("#filter-seller_type-company"),
    arbitrationManagerSellerOption = $("#filter-seller_type-arbitration_manager"),
    userSellerOption = $("#filter-seller_type-user"),
    otherSellerOption = $("#filter-seller_type-other"),
    pledgeStatusFilter = $("[test_id='filter_pledge_status']"),
    bankruptcyFilter = $("[test_id='filter_bankruptcy']"),
    executionProcedureFilter = $("[test_id='filter_execution_procedure']"),
    primaryDialogButton = $(".base-dialog-card__btn-primary"),
    resultActiveFilter = $("span.content-layout__title--sup"),
    catalogBadgeFilter = $(".catalog-badge-filters.mt-4");
  private final ElementsCollection catalogItems = $$("div.catalog-grid div.catalog-grid__item"),
    minimumPriceInputs = $$("[test_id='filter_price'] input");

  @Step("Открытие окна фильтров")
  public void openFilter() {
    filterButton.click();
    filterDialogCard.shouldBe(visible);
  }

  @Step("Выбор региона")
  public void selectRegion() {
    regionDropdown.shouldBe(visible).click();
    moscowOption.click();
    readyButton.click();
  }

  @Step("Выбор диапазона цены")
  public void selectPriceRange() {
    priceFilter.shouldBe(interactable);
    priceFilter.click();
    priceDropdownCard.shouldBe(visible);
    minPriceInputField.sendKeys(Keys.BACK_SPACE);
    minimumPriceInputs.get(0).setValue("11");
    for (int i = 1; i < 5; i++) {
      minimumPriceInputs.get(1).sendKeys(Keys.BACK_SPACE);
    }
    minimumPriceInputs.get(1).setValue("55555");
    sleep(700);
    readyButtonPrice.click();
    sleep(700);
  }

  @Step("Выбор метода продаж")
  public void selectSaleMethod() {
    saleTypeDropdown.shouldBe(interactable);
    saleTypeDropdown.click();
    directPurchaseOption.click();
    tradeOption.click();
    biddingOption.click();
    readyButton.click();
  }

  @Step("Выбор продавца")
  public void selectSellerSelection() {
    sellerFilter.shouldBe(interactable);
    sellerFilter.click();
    sellerSearchBar.shouldBe(interactable);
    typeSelectButton.click();
    bankSellerOption.click();
    governmentSellerOption.click();
    companySellerOption.click();
    arbitrationManagerSellerOption.click();
    userSellerOption.click();
    otherSellerOption.click();
    readyButton.click();
  }

  @Step("Выбор статуса залога: Да")
  public void selectPledgeStatus() {
    pledgeStatusFilter.shouldBe(interactable)
      .$(byText("Да"))
      .shouldBe(visible)
      .click();
  }

  @Step("Выбор наличия банкротства: Да")
  public void selectBankruptcy() {
    bankruptcyFilter.shouldBe(interactable)
      .$(byText("Да"))
      .shouldBe(visible)
      .click();
  }

  @Step("Выбор процедуры исполнения: Да")
  public void selectExecutionProcedure() {
    executionProcedureFilter.shouldBe(interactable)
      .$(byText("Да"))
      .shouldBe(visible)
      .click();
  }

  @Step("Нажать кнопку показать")
  public void clickShowButton() {
    primaryDialogButton.click();
  }

  @Step("Проверка количества элементов в каталоге (должно быть больше {expectedCount})")
  public FilterPage verifyCatalogItemsCount(int expectedCount) {
    resultActiveFilter.shouldBe(visible);
    catalogItems.shouldHave(sizeGreaterThan(expectedCount));
    catalogItems.first().shouldBe(visible);
    return this;
  }

  @Step("Проверка что каталог не пустой")
  public FilterPage verifyCatalogNotEmpty() {
    return verifyCatalogItemsCount(0);
  }

  @Step("Проверка отображения активных фильтров")
  public FilterPage verifyActiveFiltersDisplayed(int min, int max) {
    catalogBadgeFilter.shouldBe(visible, Duration.ofSeconds(10));

    String filtersText = catalogBadgeFilter.getText();
    assertThat(filtersText.toLowerCase()).contains("прямая покупка, аукцион, +1");
    assertThat(filtersText)
      .contains("Регион: Москва")
      .containsPattern("\\d+ — \\d+ млн. ₽")
      .contains("Тип продавца:");

    assertThat(filtersText)
      .contains("В залоге: Да")
      .contains("Банкротство: Первые торги, Повторные торги, +2")
      .contains("Исполнительное производство: Первичные торги, Вторичные торги, +1");

    return this;
  }
}