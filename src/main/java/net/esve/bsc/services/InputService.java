package net.esve.bsc.services;

import net.esve.bsc.model.Payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static net.esve.bsc.services.PaymentTrackerService.processLine;
import static net.esve.bsc.services.PaymentTrackerService.readConsoleLine;

/**
 * Created by Viliam on 06-May-16.
 */
public class InputService extends Thread {

    private FileReadWriteService fileOperation;
    private Payment payment;
    private String line;

    public void run() {
        System.out.println("Payment Tracker is running");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                line = br.readLine();
                if (line != null && line.equalsIgnoreCase("quit")) {
                    System.out.println("Payment Tracker is exiting");
                    break;
                }
                String line = readConsoleLine();
                if (line != null) {
                    Payment payment = processLine(line);
                }

            } catch (IOException ex) {
                System.out.println("Payment Tracker error " + ex.getMessage());
            }
        }
    }

}
