package components;

import static org.junit.Assert.*;

import org.junit.Test;

import tracking.Tracking;

public class PaddedTunedCircuitTest {

	@Test
	public void test() {
		
		Capacitor G = new Capacitor(432*Tracking.pf);
		Capacitor Tc = new Capacitor(53.7*Tracking.pf);
		Capacitor P = new Capacitor(500*Tracking.pf);
		Capacitor Tl = new Capacitor(8*Tracking.pf);
		
		
		
		PaddedTunedCircuit circuit = new PaddedTunedCircuit(103.9*Tracking.uh, Tl, P, Tc, G);
		double fo = circuit.calculateResonance();
		
		assertEquals(978.9*Tracking.khz, fo, 0.1*Tracking.khz);
		
	}

}
