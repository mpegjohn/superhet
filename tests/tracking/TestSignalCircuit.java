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
		
		this.tracking.setCapHigh(100.3);
		
		
		
		fail("Not yet implemented");
	}

}
