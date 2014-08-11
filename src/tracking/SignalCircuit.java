package tracking;


public class SignalCircuit {

	private Tracking trackingData;
	
	public SignalCircuit(Tracking trackingData) {
		this.trackingData = trackingData;
	}	
	private double T;
	private double L;
	

	public double getT() {
		return T;
	}

	public double getL() {
		return L;
	}
	
	public void calculate() {
		// Calculation
		// Third tracking frequency 
		
		
		this.T = this.trackingData.getGmax() /(this.trackingData.getAlpha_sq() - 1);
	
		this.L = 1/(T * (Math.pow((2 * Math.PI * trackingData.getUpperFreq()),2)));
	}
	
	
}
