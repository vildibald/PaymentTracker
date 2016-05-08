/**
 * 
 */
package net.esve.bsc.services;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.esve.bsc.model.Payment;

/**
 * @author Viliam
 *
 */
public class PaymentsServiceTest {
	
	private static final List<String> lines =  Arrays.asList("USD 100", "CZK 1000", "EUR 10000", "HUF 0");
	/**
	 * Test method for {@link net.esve.bsc.services.PaymentsService#createRecord(java.lang.String)}.
	 */
	@Test
	public void testCreateRecord() {
		for (String line : lines) {
			PaymentsService.createRecord(line);;
        }
		
	}

}
