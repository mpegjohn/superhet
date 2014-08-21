package components;

import static org.junit.Assert.*;

import org.junit.Test;

import tracking.Tracking;

public class PaddedTunedCircuitTest {

	@Test
	public void test() {
		
		Capacitor G = new Capacitor(432E-12);
		Capacitor Tc = new Capacitor(53.7E12);
		Capacitor P = new Capacitor(500E-12);
		Capacitor Tl = new Capacitor(8E-12);
		
		
		
		PaddedTunedCircuit circuit = new PaddedTunedCircuit(103.9E-6, Tl, P, Tc, G);
		double fo = circuit.calculateResonance();
		
		assertEquals(985*Tracking.khz, fo, 1.0);
		
	}

}
