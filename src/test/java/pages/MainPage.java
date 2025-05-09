package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
  private final ElementsCollection headerMenu = $$(".site-header__nav-left");
 private final SelenideElement selectFaqHref = $("[href='/faq']");
  @Step("Открываем главную страницу")
  public void openMainPage() {
    open("/");
  }

  @Step("Проверка 'Шапки' главной страницы")
  public void checkMainHeader(String headerST) {
    headerMenu.shouldHave(texts(headerST));
  }

  @Step("Переход на страницу 'FAQ'")
  public void clickOnFaq() {
    selectFaqHref.shouldBe(interactable).click();
  }
}
