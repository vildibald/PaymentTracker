package net.esve.bsc.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Viliam on 06-May-16.
 */
public class PaymentRecords {

    /**
     * Lock for concurrent writes.
     */
    private final Object lock = new Object();
    /**
     * Field payments.
     */
    private final ConcurrentMap<String, BigDecimal> payments = new ConcurrentHashMap<>();

    private PaymentRecords() {
    }

    /**
     * Method getInstance.
     *
     * @return PaymentRecords
     */
    public static PaymentRecords getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * Method getPayments.
     *
     * @return Map<String,BigDecimal>
     */
    public Map<String, BigDecimal> getPayments() {
        return payments;
    }

    /**
     * Method setPayments.
     *
     * @param payment Payment
     */
    public void setPayments(Payment payment) {
        synchronized (lock) {
            if (!payments.containsKey(payment.getCurrency())) {
                payments.put(payment.getCurrency(), payment.getAmount());
            } else {
                BigDecimal currencySum = payments.get(payment.getCurrency());
                payments.put(payment.getCurrency(), currencySum.add(payment.getAmount()));
            }
        }
    }

    /**
     * Most efficient way for concurrent singleton
     */
    private static class Holder {
        static final PaymentRecords INSTANCE = new PaymentRecords();
    }


}