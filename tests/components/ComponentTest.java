package components;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComponentTest {

	@Test
	public void picoTest() {
		Component component = new Component();
		component.value = 20E-12;
		component.unit = "F";
		
		component.calcUnitMult();
		
		assertEquals("20.00 pF", component.getFormattedNumber());	
	}
	
	@Test
	public void milliTest() {
		Component component = new Component();
		component.value = 221.3144E-3;
		component.unit = "A";		
		component.calcUnitMult();
		
		assertEquals("221.31 mA", component.getFormattedNumber());	
	}
	
	@Test
	public void microTest() {
		Component component = new Component();
		component.value = 225.677E-6;
		component.unit = "F";		
		component.calcUnitMult();
		
		assertEquals("225.68 uF", component.getFormattedNumber());	
	}
}
