package transaction;

import exception.UnreachableException;
import model.ChargeResult;
import transaction.TransactionLog;

public class DatabaseTransactionLog implements TransactionLog {
    public void logChargeResult(ChargeResult result) {

    }

    public void logConnectException(UnreachableException e) {

    }

    public boolean wasSuccessLogged() {
        return false;
    }
}
