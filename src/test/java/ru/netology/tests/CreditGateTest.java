package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.pages.PaymentMethod;

import static com.codeborne.selenide.Selenide.open;

public class CreditGateTest {
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
        var buyCredit = startPage.openBuyCredit();
        var approvedCardInformation = DataHelper.getValidCard();
        buyCredit.enterCreditCardData(approvedCardInformation);
        buyCredit.verifySuccessNotificationCreditCard();

        var statusCredit = SqlHelper.getStatusCredit();
        Assertions.assertEquals("APPROVED", statusCredit);
    }

    @Test
    public void shouldNotPayDeclinedCard() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var declinedCard = DataHelper.getDeclinedCard();
        buyCredit.enterCreditCardData(declinedCard);
        buyCredit.verifyErrorWarningCreditCard();

        var statusCredit = SqlHelper.getStatusCredit();
        Assertions.assertEquals("DECLINED", statusCredit);
    }

    @Test
    public void shouldNotPayEmptyFields() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var fieldCardEmpty = DataHelper.getEmptyCard();
        buyCredit.enterCreditCardData(fieldCardEmpty);
        buyCredit.verifyRequiredFieldCreditCard();
    }

    @Test
    public void shouldNotPayEmptyCard() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var fieldCardEmpty = DataHelper.getCardNumberEmpty();
        buyCredit.enterCreditCardData(fieldCardEmpty);
        buyCredit.verifyRequiredFieldCreditCard();
    }

    @Test
    public void shouldNotPayInvalidCardNumber() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var fieldCardEmpty = DataHelper.getInvalidCardNumber();
        buyCredit.enterCreditCardData(fieldCardEmpty);
        buyCredit.verifyRequiredFieldCreditCard();
    }

    @Test
    public void shouldNotPayEmptyMonth() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCard();
        var fieldMonthEmpty = DataHelper.getMonthEmpty();
        buyCredit.enterCardData(fieldMonthEmpty);
        buyCredit.verifyRequiredFieldCard();
    }

    @Test
    public void shouldNotPayWrongMonth() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getInvalidMonth();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyIncorrectDateCreditCard();
    }

    @Test
    public void shouldNotPayEmptyYear() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var fieldYearEmpty = DataHelper.getYearEmpty();
        buyCredit.enterCreditCardData(fieldYearEmpty);
        buyCredit.verifyRequiredFieldCreditCard();
    }

    @Test
    public void shouldNotPayExpiredYear() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getExpiredYear();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.expiredCreditCard();
    }

    @Test
    public void shouldNotPayWrongYear() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getWrongYear();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyIncorrectDateCreditCard();
    }

    @Test
    public void shouldNotPayEmptyHolder() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var fieldHolderEmpty = DataHelper.getHolderEmpty();
        buyCredit.enterCreditCardData(fieldHolderEmpty);
        buyCredit.verifyRequiredFieldCreditCard();
    }

    @Test
    public void shouldNotPayNumericHolder() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getInvalidName();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyErrorWarningFormatDataCreditCard();
    }

    @Test
    public void shouldNotCreditMinNameHolder() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getLessThanTwoSymbolsName();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyFieldDataOwnerCreditCard();
    }

    @Test
    public void shouldNotCreditMaxNameHolder() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getMoreThan24SymbolsName();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyFieldDataOwnerCreditCard();
    }

    @Test
    public void shouldNotPayInvalidCvvLetters() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getInvalidCvvLetters();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyIncorrectFormatCreditCard();
    }

    @Test
    public void shouldNotPayInvalidCvvSymbols() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getInvalidCvvSymbols();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyIncorrectFormatCreditCard();
    }

    @Test
    public void shouldNotPayEmptyCvv() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var fieldCvvEmpty = DataHelper.getCvvEmpty();
        buyCredit.enterCreditCardData(fieldCvvEmpty);
        buyCredit.verifyRequiredFieldCreditCard();
    }

    @Test
    public void shouldNotPayIncorrectFormatCvv() {
        var startPage = new PaymentMethod();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getInvalidFormatCVV();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyIncorrectFormatCreditCard();
    }
}