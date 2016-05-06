package net.esve.bsc.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Viliam on 06-May-16.
 */
public class Payments {

    private final ConcurrentMap<String, BigDecimal> payments = new ConcurrentHashMap<>();

    public static Payments getInstance() {
        return PaymentsInst.INSTANCE;
    }

    public Map<String, BigDecimal> getPayments() {
        return payments;
    }

    public synchronized void setPayments(Payment payment) {
        if (!payments.containsKey(payment.getCurrency())) {
            payments.put(payment.getCurrency(), payment.getAmount());
        } else {
            BigDecimal currencySum = payments.get(payment.getCurrency());
            payments.put(payment.getCurrency(), currencySum.add(payment.getAmount()));
        }
    }

    private static class PaymentsInst {
        private static final Payments INSTANCE = new Payments();
    }

}
