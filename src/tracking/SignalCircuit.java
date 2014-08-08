package tracking;


public class SignalCircuit {

	private Tracking trackingData;
	
	private double f3;
	private double gmax;
	private double alpha;
	private double alpha_sq;
	private double T;
	private double L;
	
	public double getF3() {
		return f3;
	}

	public double getGmax() {
		return gmax;
	}

	public double getAlpha() {
		return alpha;
	}

	public double getAlpha_sq() {
		return alpha_sq;
	}

	public double getT() {
		return T;
	}

	public double getL() {
		return L;
	}

	public SignalCircuit(Tracking trackingData) {
		this.trackingData = trackingData;
	}
	
	public void calculate() {
		// Calculation
		// Third tracking frequency 
		
		this.f3 = Math.sqrt(trackingData.getUpperFreq() * trackingData.getLowerFreq());
		
		this.gmax = trackingData.getCapHigh() - trackingData.getCapLow();
		
		this.alpha =  trackingData.getUpperFreq() / trackingData.getLowerFreq();
		
		this.alpha_sq = Math.pow(alpha, 2);
		
		this.T = gmax /(alpha_sq - 1);
	
		this.L = 1/(T * (Math.pow((2 * Math.PI * trackingData.getUpperFreq()),2)));
	}
	
	
}
