package net.esve.bsc.services;

import net.esve.bsc.model.Payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Viliam on 05-May-16.
 */
public class PaymentTrackerService {

    private static final String PAYMENT_PATTERN = "^([A-Z]{3})(\\s*)((\\+|-)?\\d+)$";

    public static Payment processLine(String line) {
        Payment payment = null;
        Matcher matcher = Pattern.compile(PAYMENT_PATTERN).matcher(line.trim());

        if (matcher.find()) {
            String currency = matcher.group(1);
            BigDecimal amount = new BigDecimal(matcher.group(3));
            payment = new Payment(currency, amount);
        } else {
            System.err.println(String.format("Payment '%s' was in incorrect format!", line));
        }

        return payment;
    }

    public static String readConsoleLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
