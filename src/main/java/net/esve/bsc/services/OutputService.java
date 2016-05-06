package net.esve.bsc.services;

import net.esve.bsc.model.Payments;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Viliam on 06-May-16.
 */
public class OutputService implements Runnable {

    @Override
    public void run() {

        Map<String, BigDecimal> payments = Payments.getInstance().getPayments();

        if (payments == null) {
            System.out.println("There are not any payment records");
        } else {
            System.out.println("Current payment records");
            for (Map.Entry<String, BigDecimal> entry : payments.entrySet()) {
                System.out.println(entry.getKey() + "  " + entry.getValue());
            }
        }
    }


}
