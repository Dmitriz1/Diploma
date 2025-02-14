package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.pages.PaymentMethod;

import static com.codeborne.selenide.Selenide.open;

public class BuyGateTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterEach
    public void cleanBase() {
        SqlHelper.cleanDatabase();
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @Test
    public void shouldConfirmPaymentApprovedCard() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var approvedCardInformation = DataHelper.getValidCard();
        payCard.enterCardData(approvedCardInformation);
        payCard.verifySuccessNotificationCard();

        var statusPayment = SqlHelper.getStatusPayment();
        Assertions.assertEquals("APPROVED", statusPayment);
    }

    @Test
    public void shouldNotPayDeclinedCard() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var declinedCard = DataHelper.getDeclinedCard();
        payCard.enterCardData(declinedCard);
        payCard.verifyErrorWarningCard();

        var statusPayment = SqlHelper.getStatusPayment();
        Assertions.assertEquals("DECLINED", statusPayment);
    }

    @Test
    public void shouldNotPayEmptyFields() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var fieldCardEmpty = DataHelper.getEmptyCard();
        payCard.enterCardData(fieldCardEmpty);
        payCard.verifyRequiredFieldCard();
    }

    @Test
    public void shouldNotPayEmptyCard() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var fieldCardEmpty = DataHelper.getCardNumberEmpty();
        payCard.enterCardData(fieldCardEmpty);
        payCard.verifyRequiredFieldCard();
    }

    @Test
    public void shouldNotPayInvalidCardNumber() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var fieldCardEmpty = DataHelper.getInvalidCardNumber();
        payCard.enterCardData(fieldCardEmpty);
        payCard.verifyRequiredFieldCard();
    }

    @Test
    public void shouldNotPayEmptyMonth() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var fieldMonthEmpty = DataHelper.getMonthEmpty();
        payCard.enterCardData(fieldMonthEmpty);
        payCard.verifyRequiredFieldCard();
    }

    @Test
    public void shouldNotPayWrongMonth() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var invalidCard = DataHelper.getInvalidMonth();
        payCard.enterCardData(invalidCard);
        payCard.verifyIncorrectDateCard();
    }

    @Test
    public void shouldNotPayEmptyYear() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var fieldYearEmpty = DataHelper.getYearEmpty();
        payCard.enterCardData(fieldYearEmpty);
        payCard.verifyRequiredFieldCard();
    }

    @Test
    public void shouldNotPayExpiredYear() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var invalidCard = DataHelper.getExpiredYear();
        payCard.enterCardData(invalidCard);
        payCard.expiredCard();
    }

    @Test
    public void shouldNotPayWrongYear() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var invalidCard = DataHelper.getWrongYear();
        payCard.enterCardData(invalidCard);
        payCard.verifyIncorrectDateCard();
    }

    @Test
    public void shouldNotPayEmptyHolder() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var fieldHolderEmpty = DataHelper.getHolderEmpty();
        payCard.enterCardData(fieldHolderEmpty);
        payCard.verifyRequiredFieldCard();
    }

    @Test
    public void shouldNotPayNumericHolder() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var invalidCard = DataHelper.getInvalidName();
        payCard.enterCardData(invalidCard);
        payCard.verifyErrorWarningFormatDataCard();
    }

    @Test
    public void shouldNotCreditMinNameHolder() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var invalidCard = DataHelper.getLessThanTwoSymbolsName();
        payCard.enterCardData(invalidCard);
        payCard.verifyFieldDataOwnerCard();
    }

    @Test
    public void shouldNotCreditMaxNameHolder() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var invalidCard = DataHelper.getMoreThan24SymbolsName();
        payCard.enterCardData(invalidCard);
        payCard.verifyFieldDataOwnerCard();
    }

    @Test
    public void shouldNotPayInvalidCvvLetters() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var invalidCard = DataHelper.getInvalidCvvLetters();
        payCard.enterCardData(invalidCard);
        payCard.verifyIncorrectFormatCard();
    }

    @Test
    public void shouldNotPayInvalidCvvSymbols() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var invalidCard = DataHelper.getInvalidCvvSymbols();
        payCard.enterCardData(invalidCard);
        payCard.verifyIncorrectFormatCard();
    }

    @Test
    public void shouldNotPayEmptyCvv() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var fieldCvvEmpty = DataHelper.getCvvEmpty();
        payCard.enterCardData(fieldCvvEmpty);
        payCard.verifyRequiredFieldCard();
    }

    @Test
    public void shouldNotPayIncorrectFormatCvv() {
        var startPage = new PaymentMethod();
        var payCard = startPage.openBuyCard();
        var invalidCard = DataHelper.getInvalidFormatCVV();
        payCard.enterCardData(invalidCard);
        payCard.verifyIncorrectFormatCard();
    }
}