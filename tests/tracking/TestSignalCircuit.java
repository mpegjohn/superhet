package tracking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSignalCircuit {

	Tracking tracking;
	
	@Before
	public void setup() {
		this.tracking = new Tracking();
	}
	
	@Test
	public void testCalculate() {
		
		this.tracking.setCapHigh(432 * Tracking.pf);
		this.tracking.setCapLow(12 * Tracking.pf);
		this.tracking.setUpperFreq(1620 * Tracking.khz);
		this.tracking.setLowerFreq(530 * Tracking.khz);
		this.tracking.setIfFreq(455 * Tracking.khz);
		
		SignalCircuit signal = new SignalCircuit(tracking);
		
		signal.calculate();
		
		assertEquals(420 * Tracking.pf, signal.getGmax(), 0.01 * Tracking.pf);
		assertEquals(9.342, signal.getAlpha_sq(), 0.01);
		assertEquals(50.24 * Tracking.pf, signal.getT(), 0.2 * Tracking.pf);
		assertEquals(192.2 * Tracking.uh, signal.getL(), 0.5 * Tracking.uh);
	}

}
