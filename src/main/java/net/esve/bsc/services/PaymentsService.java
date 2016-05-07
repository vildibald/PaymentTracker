package net.esve.bsc.services;

import net.esve.bsc.model.Payment;
import net.esve.bsc.model.PaymentRecords;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Viliam on 05-May-16.
 */
public class PaymentsService {

    /**
     * Field PAYMENT_PATTERN.
     * (value is ""^([A-Z]{3})(\\s+)((\\+|-)?\\d+)$"")
     */
    private static final String PAYMENT_PATTERN = "^([A-Z]{3})(\\s+)((\\+|-)?\\d+)$";

    /**
     * Method createRecord.
     * @param str String
     */
    public static void createRecord(String str) {

        Matcher matcher = Pattern.compile(PAYMENT_PATTERN).matcher(str);

        if (matcher.find()) {
            String currency = parseCurrency(matcher.group());
            BigDecimal amount = parseAmount(matcher.group());
            Payment payment = new Payment();
            payment.setCurrency(currency);
            payment.setAmount(amount);
            PaymentRecords.getInstance().setPayments(payment);
            System.out.println("Payment has been created");
        } else {
            System.err.println(String.format("Payment '%s' was in incorrect format!", str));
        }
    }

    /**
     * Parses currency value
     *
     * @param str parse str
    
     * @return value */
    private static String parseCurrency(String str) {
        return str.substring(0, 3);
    }

    /**
     * Parses amount value
     *
     * @param str parse str
    
     * @return value */
    private static BigDecimal parseAmount(String str) {
        return new BigDecimal(str.substring(4));
    }


}
