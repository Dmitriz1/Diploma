package ru.netology.data;

import lombok.Value;
import static ru.netology.data.DataGenerator.faker;


public class DataHelper {
    static Card card = new Card();
    static DataGenerator dataGenerator = new DataGenerator();

    public static CardInformation getValidCard() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                dataGenerator.shiftOwner(),
                dataGenerator.shiftCvv());
    }

    public static CardInformation getEmptyCard() {
        return new CardInformation(
                " ", " ", " ", " ", " ");
    }

    public static CardInformation getDeclinedCard() {
        return new CardInformation(
                card.getDeclinedCardNumber(),
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                dataGenerator.shiftOwner(),
                dataGenerator.shiftCvv());
    }

    public static CardInformation getCardNumberEmpty() {
        return new CardInformation(
                " ",
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                dataGenerator.shiftOwner(),
                dataGenerator.shiftCvv());
    }

    public static CardInformation getInvalidCardNumber() {
        return new CardInformation(
                "ABCDАБВГ1234!@#$",
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                dataGenerator.shiftOwner(),
                dataGenerator.shiftCvv());
    }

    public static CardInformation getYearEmpty() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                " ",
                dataGenerator.shiftMonth(1),
                dataGenerator.shiftOwner(),
                dataGenerator.shiftCvv());
    }

    public static CardInformation getMonthEmpty() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(1),
                " ",
                dataGenerator.shiftOwner(),
                dataGenerator.shiftCvv());
    }

    public static CardInformation getHolderEmpty() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                " ",
                dataGenerator.shiftCvv());
    }

    public static CardInformation getCvvEmpty() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                dataGenerator.shiftOwner(),
                "");
    }

    public static CardInformation getInvalidCvvLetters() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                dataGenerator.shiftOwner(),
                "ABC");
    }

    public static CardInformation getInvalidCvvSymbols() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                dataGenerator.shiftOwner(),
                "!@#");
    }

    public static CardInformation getExpiredYear() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(-1),
                dataGenerator.shiftMonth(1),
                dataGenerator.shiftOwner(),
                dataGenerator.shiftCvv());
    }

    public static CardInformation getWrongYear() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(11),
                dataGenerator.shiftMonth(1),
                dataGenerator.shiftOwner(),
                dataGenerator.shiftCvv());
    }

    public static CardInformation getInvalidMonth() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(1),
                Integer.toString(faker.random().nextInt(13, 20)),
                dataGenerator.shiftOwner(),
                dataGenerator.shiftCvv());
    }

    public static CardInformation getInvalidName() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                "Петро123(*?(?(?",
                dataGenerator.shiftCvv());
    }

    public static CardInformation getInvalidFormatCVV() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                dataGenerator.shiftOwner(),
                "77");
    }

    public static CardInformation getLessThanTwoSymbolsName() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                "G",
                dataGenerator.shiftCvv());
    }

    public static CardInformation getMoreThan24SymbolsName() {
        return new CardInformation(
                card.getApprovedCardNumber(),
                dataGenerator.shiftYear(1),
                dataGenerator.shiftMonth(1),
                "ASDADSADASASDASDASDASDASDASD",
                dataGenerator.shiftCvv());
    }

    @Value
    public static class CardInformation {
        String cardNumber;
        String year;
        String month;
        String owner;
        String CVV;
    }
}