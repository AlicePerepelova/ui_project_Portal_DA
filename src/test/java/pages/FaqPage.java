package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FaqPage {
  private final SelenideElement
    titleName = $("h1.content-layout__title"),
    faqStart = $("[href='/faq/start']"),
    faqBuying = $("[href='/faq/buying']"),
    faqAuction = $("[href='/faq/auction']"),
    faqPurchase = $("[href='/faq/purchase']"),
    faqSelling = $("[href='/faq/selling']"),
    faqEds = $("[href='/faq/eds']"),
    faqBankruptcy = $("[href='/faq/bankruptcy']"),
    faqDocuments = $("[href='/faq/documents']"),
    feedsAutoload = $("[href='/feeds/autoload']");
  String valueStart = "Начало работы",
    valueBuying = "Приобретение актива",
    valueAuction = "Аукционы",
    valuePurchase = "Покупка квартир и автомобилей с баланса Сбербанка",
    valueSelling = "Продажа актива",
    valueEds = "Электронная подпись",
    valueBankruptcy = "Банкротство",
    valueDocuments = "Документы",
    valueFeedsAutoload = "Автозагрузка объявлений";


  @Step("Проверка заголовка на странице")
  public void checkTitleName() {
    titleName.shouldHave(text("Часто задаваемые вопросы о сервисе Portal DA"));
  }

  @Step("Проверка текста карточке 'Начало работы'")
  public void checkTextInFaqStart() {
    faqStart.shouldBe(interactable).shouldHave(text(valueStart));
  }

  @Step("Проверка текста карточке 'Приобретение актива'")
  public void checkTextInFaqBuying() {
    faqBuying.shouldBe(interactable).shouldHave(text(valueBuying));
  }

  @Step("Проверка текста карточке 'Аукционы'")
  public void checkTextInFaqAuction() {
    faqAuction.shouldBe(interactable).shouldHave(text(valueAuction));
  }

  @Step("Проверка текста карточке 'Покупка квартир и автомобилей с баланса Сбербанка'")
  public void checkTextInFaqPurchase() {
    faqPurchase.shouldBe(interactable).shouldHave(text(valuePurchase));
  }

  @Step("Проверка текста карточке 'Продажа актива'")
  public void checkTextInFaqSelling() {
    faqSelling.shouldBe(interactable).shouldHave(text(valueSelling));
  }

  @Step("Проверка текста карточке 'Электронная подпись'")
  public void checkTextInFaqEds() {
    faqEds.shouldBe(interactable).shouldHave(text(valueEds));
  }

  @Step("Проверка текста карточке 'Банкротство'")
  public void checkTextInFaqBankruptcy() {
    faqBankruptcy.shouldBe(interactable).shouldHave(text(valueBankruptcy));
  }

  @Step("Проверка текста карточке 'Документы'")
  public void checkTextInFaqDocuments() {
    faqDocuments.shouldBe(interactable).shouldHave(text(valueDocuments));
  }

  @Step("Проверка текста карточке 'Автозагрузка объявлений'")
  public void checkTextInFaqFeedsAutoload() {
    feedsAutoload.shouldBe(interactable).shouldHave(text(valueFeedsAutoload));
  }
}
