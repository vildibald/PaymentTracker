package net.esve.bsc.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Viliam on 06-May-16.
 */
public class PaymentRecords implements Payments {

    /**
     * Field payments.
     */
    private final ConcurrentMap<String, BigDecimal> payments = new ConcurrentHashMap<>();

    /**
     * Method getInstance.
     * @return PaymentRecords
     */
    public static PaymentRecords getInstance() {
        return INSTANCE;
    }

    /**
     * Method getPayments.
     * @return Map<String,BigDecimal>
     */
    public Map<String, BigDecimal> getPayments() {
        return payments;
    }

    /**
     * Method setPayments.
     * @param payment Payment
     */
    public synchronized void setPayments(Payment payment) {
        if (!payments.containsKey(payment.getCurrency())) {
            payments.put(payment.getCurrency(), payment.getAmount());
        } else {
            BigDecimal currencySum = payments.get(payment.getCurrency());
            payments.put(payment.getCurrency(), currencySum.add(payment.getAmount()));
        }
    }
}
