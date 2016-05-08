package net.esve.bsc.services;

import net.esve.bsc.model.PaymentRecords;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Viliam on 06-May-16.
 * @author Mamak
 * @version $Revision: 1.0 $
 */
public class OutputService implements Runnable {

    /**
     * Method run.
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

        Map<String, BigDecimal> payments = PaymentRecords.getInstance().getPayments();

        if (payments.isEmpty()) {
            System.out.println("There are not any payment records");
        } else {
            System.out.println("Current payment records :");
            for (Map.Entry<String, BigDecimal> entry : payments.entrySet()) {
                if (!entry.getValue().equals(BigDecimal.ZERO)) {
                    BigDecimal rateAmount = Exchange.getRate(entry);
                  if (rateAmount.equals(BigDecimal.ZERO)) { 
                      System.out.println(entry.getKey() + " " + entry.getValue() );
                  } else {
                	  System.out.println(entry.getKey() + " " + entry.getValue() + "("+String.valueOf(rateAmount)+")" );
                  }
                }
            }
        }
    }


}
