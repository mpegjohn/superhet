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
		
		this.tracking.setCapHigh(432);
		this.tracking.setCapLow(12);
		this.tracking.setUpperFreq(1620);
		this.tracking.setLowerFreq(530);
		this.tracking.setIfFreq(455);
		this.tracking.calculate();
		
		OscillatorCircuit osc = new OscillatorCircuit(tracking);
		
		osc.calculate();

		assertEquals(2.10, osc.getBeta(), 0.2);
		assertEquals(4.41, osc.getBeta_sq(), 0.2);
		assertEquals(1.758, osc.getR(), 0.1);
		assertEquals(554 * Tracking.pf, osc.getPmax().getValue(), 1*Tracking.pf);
		assertEquals(61.7* Tracking.pf, osc.getTcmax().getValue(), 1*Tracking.pf);
		assertEquals(500.3* Tracking.pf, osc.getP().getValue(), 1*Tracking.pf);
		assertEquals(53.7* Tracking.pf, osc.getTc().getValue(), 1*Tracking.pf);
		assertEquals(103.9* Tracking.uh, osc.getLo().getValue(), 0.1*Tracking.uh);
	}
	
	@Test
	public void testResonance() {
		this.tracking.setCapHigh(432);
		this.tracking.setCapLow(12);
		this.tracking.setUpperFreq(1620);
		this.tracking.setLowerFreq(530);
		this.tracking.setIfFreq(455);
		this.tracking.calculate();
		
		OscillatorCircuit osc = new OscillatorCircuit(tracking);
		
		osc.calculate();
		
		assertEquals(985E+3, osc.calculateFo(1.0), 1E+3);
		
		assertEquals(2.075E+6, osc.calculateFo(0), 5E+3);
	}
}
