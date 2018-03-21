package model;

public class CreditCard {
    private int  balance;
    private String cardNumber;
    private int month;
    private int year;

    public CreditCard(String cardNumber, int month, int year) {
        this.cardNumber=cardNumber;
        this.month=month;
        this.year=year;
    }
}
