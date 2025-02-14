package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PaymentMethod {
    private final SelenideElement byButton = $(byText("Купить"));
    private final SelenideElement byCreditButton = $(byText("Купить в кредит"));

    public PaymentMethod () {
        SelenideElement heading = $(byText("Путешествие дня"));
        heading.shouldBe(visible);
    }

    public BuyGate openBuyCard() {
        byButton.click();
        return new BuyGate();
    }

    public CreditGate openBuyCredit() {
        byCreditButton.click();
        return new CreditGate();
    }
}
