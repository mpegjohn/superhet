package components;

import static org.junit.Assert.*;

import org.junit.Test;

public class CapacitorTest {

	@Test
	public void parallelTest() {
		
		Capacitor capacitor = new Capacitor(100E-12);
		
		Capacitor capacitor2 = new Capacitor(300E-12);
		
		capacitor.addParallel(capacitor2);
		
		assertEquals(400E-12, capacitor.getValue(), 0.01E-12);
	}
	
	@Test
	public void serialTest() {
		
		Capacitor capacitor = new Capacitor(100E-12);
		
		Capacitor capacitor2 = new Capacitor(100E-12);
		
		capacitor.addSerial(capacitor2);
		
		assertEquals(50E-12, capacitor.getValue(), 0.01E-12);
	}
	
	@Test
	public void padderTest() {
		/*
		 * Consists of a 100pF tuning cap
		 * Tc 20pF
		 * P 300pF
		 * Tl 20pF
		 */
		
		Capacitor tuning = new Capacitor(100E-12);
		
		Capacitor tc = new Capacitor(20E-12);
		
		Capacitor p = new Capacitor(300E-12);
		
		Capacitor tl = new Capacitor(20E-12);
		
		
		Capacitor totalCap = new Capacitor(tuning.getValue());
		totalCap.addParallel(tc);
		totalCap.addSerial(p);
		totalCap.addParallel(tl);
		assertEquals(105.7E-12, totalCap.getValue(), 0.1E-12);

	}

}
