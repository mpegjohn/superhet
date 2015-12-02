package tracking;

import components.Capacitor;
import components.Inductor;
import components.TunedCircuit;


public class SignalCircuit {

	private Tracking trackingData;
	
	public SignalCircuit(Tracking trackingData) {
		this.trackingData = trackingData;
	}	
	private Capacitor T;
	private Inductor L;
	private double actualCap;

	public double getActualCap() {
		return actualCap;
	}

	public Capacitor getT() {
		return T;
	}

	public Inductor getL() {
		return L;
	}
	
	public void calculate() {
		// Calculation
		// Third tracking frequency 
		
		
		this.T = new Capacitor(trackingData.getGmax() /(this.trackingData.getAlpha_sq() - 1));
	
		this.L = new Inductor(1/(T.getValue() * (Math.pow((2 * Math.PI * trackingData.getUpperFreq()),2))));
	}

	public double calculateFo(double percentRotation) {
		
		this.actualCap = (percentRotation * (this.trackingData.getCapHigh() - this.trackingData.getCapLow())) + this.trackingData.getCapLow();
		
		Capacitor G = new Capacitor(this.actualCap);
		Capacitor T = new Capacitor(this.T.getValue() - this.trackingData.getCapLow());
		
		G.addParallel(T);
		
		TunedCircuit circuit = new TunedCircuit(this.L, G);
		
		double fo = circuit.calculateResonance();
		
		return fo;
	}
	
	
}
