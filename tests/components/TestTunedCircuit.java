package components;

import static org.junit.Assert.*;

import org.junit.Test;

import tracking.Tracking;

public class TestTunedCircuit {

	@Test
	public void test() {
		double cap = 150 * Tracking.pf;
		double ind = 100 * Tracking.uh;
		
		TunedCircuit tank = new TunedCircuit(ind, cap);
		
		assertEquals(1.299494*Tracking.mhz, tank.calculateResonance(), 1.0);
		
	}

}
