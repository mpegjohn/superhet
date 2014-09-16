package components;

import static org.junit.Assert.*;

import org.junit.Test;

import tracking.Tracking;

public class TunedCircuitTest {

	@Test
	public void test() {
		double cap = 150 * Tracking.pf;
		double ind = 100 * Tracking.uh;
		
		Capacitor capacitor = new Capacitor(cap);
		Inductor inductor = new Inductor(ind);
		
		TunedCircuit tank = new TunedCircuit(inductor, capacitor);
		
		assertEquals(1.299494*Tracking.mhz, tank.calculateResonance(), 1.0);
	}

}
