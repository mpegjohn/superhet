package tracking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTracking {

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
		
		assertEquals(420 * Tracking.pf, tracking.getGmax(), 0.1 * Tracking.pf);
		assertEquals(926.6 * Tracking.khz, tracking.getF3(), 0.1 * Tracking.khz);
		assertEquals(3.056, tracking.getAlpha(), 0.1);
		assertEquals(9.342, tracking.getAlpha_sq(), 0.1);
		assertEquals(1.748, tracking.getAlpha_sqrt(), 0.1);

	}

}
