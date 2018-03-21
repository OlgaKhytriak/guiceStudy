package model;

public class Receipt {
    public static Receipt forSuccessfulCharge(int amount) {
    return new Receipt();
    }

    public static Receipt forDeclinedCharge(Object declineMessage) {
        return new Receipt();
    }

    public static Receipt forSystemFailure(String message) {
    return new Receipt();
    }

    public boolean hasSuccessfulCharge() {
    return true;
    }

    public int getAmountOfCharge() {
    return 20;
    }
}
