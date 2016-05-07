package net.esve.bsc.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Viliam on 06-May-16.
 * @author Mamak
 * @version $Revision: 1.0 $
 */
public class InputService implements Runnable {

    /**
     * Method readConsoleLine.
     * @return String
     */
    private static String readConsoleLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method run.
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while (true) {
                String line = readConsoleLine();
            if (line != null) {
                if (line.equalsIgnoreCase("quit")) {
                    System.out.println("Payment Tracker is exiting");
                    Runtime.getRuntime().halt(0);
                    return;
                } else if (!line.equals("")) {
                    PaymentsService.createRecord(line);
                }
                }
        }
    }


}
