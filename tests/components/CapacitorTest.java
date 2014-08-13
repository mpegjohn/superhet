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

}
