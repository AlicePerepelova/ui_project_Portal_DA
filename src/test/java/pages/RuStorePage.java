package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RuStorePage {
  private final SelenideElement
    ruStoreBtn = $("a.app-links__rustore-black");

  public void clickRuStoreBtn() {
    actions().moveToElement(ruStoreBtn).perform();
    ruStoreBtn.shouldBe(interactable).click();
  }

  public void checkRuStoreOpened(String url) {
    switchTo().window(1);
    webdriver().shouldHave(url(url));
    closeWindow();
    switchTo().window(0);
  }
}
