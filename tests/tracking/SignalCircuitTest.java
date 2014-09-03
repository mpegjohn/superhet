package tracking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SignalCircuitTest {

	Tracking tracking;
	
	@Before
	public void setup() {
		this.tracking = new Tracking();
	}
	
	@Test
	public void testCalculate() {
		
		this.tracking.setCapHigh(432);
		this.tracking.setCapLow(12);
		this.tracking.setUpperFreq(1620);
		this.tracking.setLowerFreq(530);
		this.tracking.setIfFreq(455);
		this.tracking.calculate();
		
		SignalCircuit signal = new SignalCircuit(tracking);
		
		signal.calculate();
		
		assertEquals(50.24 * Tracking.pf, signal.getT(), 0.2 * Tracking.pf);
		assertEquals(192.2 * Tracking.uh, signal.getL(), 0.5 * Tracking.uh);
	}

	@Test
	public void testResonance() {
		
		this.tracking.setCapHigh(432);
		this.tracking.setCapLow(12);
		this.tracking.setUpperFreq(1620);
		this.tracking.setLowerFreq(530);
		this.tracking.setIfFreq(455);
		this.tracking.calculate();
		
		SignalCircuit signal = new SignalCircuit(tracking);
		
		signal.calculate();
		
		assertEquals(530E+3, signal.calculateFo(1.0), 1E+3);
		assertEquals(1.62E+6, signal.calculateFo(0), 1E+3);
	}
	
}
