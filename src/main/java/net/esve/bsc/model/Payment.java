package net.esve.bsc.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Viliam on 05-May-16.
 */
public class Payment {

    /**
     * Field currency.
     */
    private String currency;
    /**
     * Field amount.
     */
    private BigDecimal amount;

    /**
     * Method getCurrency.
     * @return String
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Method setCurrency.
     * @param currency String
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Method getAmount.
     * @return BigDecimal
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Method setAmount.
     * @param amount BigDecimal
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Method toString.
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s %s", this.currency, this.amount.toString());
    }

    /**
     * Method equals.
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        Payment payment = (Payment) obj;
        return Objects.equals(amount, payment.amount)
                && (Objects.equals(currency, payment.currency)
                || (currency != null && currency.equals(payment.getCurrency())));
    }

    /**
     * Method hashCode.
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((currency == null) ? 0 : currency.hashCode());
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        return result;
    }
}
