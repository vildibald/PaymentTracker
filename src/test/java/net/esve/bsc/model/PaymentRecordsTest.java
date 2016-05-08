/**
 * 
 */
package net.esve.bsc.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;

import org.junit.Test;


/**
 * @author Viliam
 *
 */
public class PaymentRecordsTest {

	private static final List<Payment> payments = new ArrayList<>();
	private static Map<String, BigDecimal> paymentRecords = new HashMap<>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        payments.add(new Payment("EUR", new BigDecimal(100)));
		payments.add(new Payment("CZK", new BigDecimal(200)));
		payments.add(new Payment("USD", new BigDecimal(300)));
		
	}

	/**
	 * Test method for
	 * {@link net.esve.bsc.model.PaymentRecords#setPayments(net.esve.bsc.model.Payment)}
	 * .
	 */
	@Test
	public void testSetPayments() {
		for (Payment payment : payments) {
			paymentRecords.put(payment.getCurrency(), payment.getAmount());
        }
		
		assertThat(paymentRecords.isEmpty(), is(false));
	}
	

	/**
	 * Test method for {@link net.esve.bsc.model.PaymentRecords#getPayments()}.
	 */
	@Test
	public void testGetPayments() {
		assertThat(paymentRecords.isEmpty(), is(false));
	}
	
	/**
	 * Test method for {@link net.esve.bsc.model.PaymentRecords#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		this.setPaymentRecords();
		assertThat(PaymentRecords.getInstance().getPayments(), is(paymentRecords));
	}
	

	public void setPaymentRecords() {
		for (Payment payment : payments) {
			PaymentRecords.getInstance().setPayments(payment);
	     }		
	}
	



}
