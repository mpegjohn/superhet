package tracking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOscillator {
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
		this.tracking.calculate();
		
		OscillatorCircuit osc = new OscillatorCircuit(tracking);
		
		osc.calculate();
		

	}
}
