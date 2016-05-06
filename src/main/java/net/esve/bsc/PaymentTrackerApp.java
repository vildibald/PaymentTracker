package net.esve.bsc;

import net.esve.bsc.model.Payment;
import net.esve.bsc.model.Payments;
import net.esve.bsc.services.FileReadWriteService;
import net.esve.bsc.services.OutputService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;
import static net.esve.bsc.services.PaymentTrackerService.processLine;


/**
 * Created by Viliam on 05-May-16.
 */
public class PaymentTrackerApp {

    /**
     * @param args application args
     */
    public static void main(String[] args) {

        List<String> fileLines = null;
        List<Payment> payments = Collections.emptyList();

        List<String> arrArgs = Arrays.asList(args);
        if (arrArgs.size() == 1) {
            String fileName = args[0];
            FileReadWriteService fileOperation = new FileReadWriteService(args[0]);
            fileLines = fileOperation.readFileLines();
        }

        if (fileLines != null && !fileLines.isEmpty()) {
            for (String line : fileLines) {
                Payment payment = processLine(line);
                Payments.getInstance().processPayment(payment);
            }
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final ScheduledFuture<?> printer = scheduler.scheduleAtFixedRate(
                new OutputService(), 1, 60, SECONDS);

    }

    //call others

}
