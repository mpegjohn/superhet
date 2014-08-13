package tracking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OscillatorTest {
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

		assertEquals(2.10, osc.getBeta(), 0.2);
		assertEquals(4.41, osc.getBeta_sq(), 0.2);
		assertEquals(1.758, osc.getR(), 0.1);
		assertEquals(554 * Tracking.pf, osc.getPmax(), 1*Tracking.pf);
		assertEquals(61.7* Tracking.pf, osc.getTcmax(), 1*Tracking.pf);
		assertEquals(500.3* Tracking.pf, osc.getP(), 1*Tracking.pf);
		assertEquals(53.7* Tracking.pf, osc.getTc(), 1*Tracking.pf);
		assertEquals(103.9* Tracking.uh, osc.getLo(), 0.1*Tracking.uh);

	}
}
