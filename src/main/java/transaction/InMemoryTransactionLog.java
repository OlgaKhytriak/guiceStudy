package transaction;

import exception.UnreachableException;
import model.ChargeResult;
import transaction.TransactionLog;

public class InMemoryTransactionLog implements TransactionLog {
    public void logChargeResult(ChargeResult result) {

    }

    public void logConnectException(UnreachableException e) {

    }

    public boolean wasSuccessLogged() {
        return false;
    }
}
