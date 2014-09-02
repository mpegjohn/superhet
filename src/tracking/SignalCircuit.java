package tracking;

import components.Capacitor;
import components.TunedCircuit;


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

	public double calculateFo(double percentRotation) {
		
		double actualCap = (percentRotation * (this.trackingData.getCapHigh() - this.trackingData.getCapLow())) + this.trackingData.getCapLow();
		
		Capacitor G = new Capacitor(actualCap);
		Capacitor T = new Capacitor(this.T);
		
		G.addParallel(T);
		
		TunedCircuit circuit = new TunedCircuit(this.L, G);
		
		double fo = circuit.calculateResonance();
		
		return fo;
	}
	
	
}
