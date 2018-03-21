package transaction;

import exception.UnreachableException;
import model.ChargeResult;

public interface TransactionLog {
    void logChargeResult(ChargeResult result);

    void logConnectException(UnreachableException e);

    boolean wasSuccessLogged();
}
