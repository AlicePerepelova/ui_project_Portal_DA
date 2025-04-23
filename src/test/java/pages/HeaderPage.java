package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
  private final SelenideElement
    headerBuy = $("#site-header-buy"),
    headerRent = $("#site-header-rent"),
    headerServices = $("a[href*='services']"),
    headerTariffs = $("a[href*='tariff']"),
    catalogName = $("h1.content-layout__title"),
    catalogNameTariffs = $("h1.title-h1");

  @Step("Выбрать хэдер 'Купить'")
  public void clickHeaderBuy() {
    headerBuy.shouldBe(interactable).click();
  }

  @Step("Проверить, что на странице отображается '{expectedText}'")
  public void checkHeaderText(String expectedText) {
    catalogName.shouldHave(text(expectedText));
  }

  @Step("Выбрать хэдер 'Снять'")
  public void clickHeaderRent() {
    headerRent.shouldBe(interactable).click();
  }

  @Step("Выбрать хэдер 'Сервисы'")
  public void clickHeaderServices() {
    headerServices.shouldBe(interactable).click();
  }

  @Step("Выбрать хэдер 'Тарифы'")
  public void clickHeaderTariffs() {
    headerTariffs.shouldBe(interactable).click();
  }

  @Step("Проверить, что на странице отображается  '{expectedText}'")
  public void checkHeaderTariffs(String expectedText) {
    catalogNameTariffs.shouldHave(text(expectedText));
  }
}
