package net.esve.bsc.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ExchangeService {
	
    private static final Map<String, Double> exchangeRates = new HashMap<String , Double>() {
		private static final long serialVersionUID = 5850880745871856632L;
	{
        put("EUR", 1.27);
        put("CZK", 28.05);
        put("HUF", 350.00);
    }};

	private static Double rate;
	
	public static BigDecimal getRate(Entry<String, BigDecimal> entry) {
		BigDecimal amount = BigDecimal.ZERO;
		rate = exchangeRates.get(entry.getKey());		
		if (rate!=null) {
			amount = entry.getValue().multiply(new BigDecimal(rate)).setScale(2,RoundingMode.HALF_UP);
		}
		return amount;
	};

}
