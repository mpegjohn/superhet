package components;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComponentTest {

	@Test
	public void picoTest() {
		Component component = new Component();
		
		component.calcUnitMult(20E-12, "F");
		
		assertEquals("20.00 pF", component.getFormattedNumber());	
	}
	
	@Test
	public void milliTest() {
		Component component = new Component();
		
		component.calcUnitMult(221.3144E-3, "A");
		
		assertEquals("221.31 mA", component.getFormattedNumber());	
	}
	
	@Test
	public void microTest() {
		Component component = new Component();
		
		component.calcUnitMult(225.677E-6, "F");
		
		assertEquals("225.68 uF", component.getFormattedNumber());	
	}
}
