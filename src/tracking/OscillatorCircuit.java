package tracking;

import components.Capacitor;
import components.Inductor;
import components.PaddedTunedCircuit;

public class OscillatorCircuit {

	private Tracking trackingData;

	/***
	 * Stray capacitance
	 */
	private final Capacitor Tl = new Capacitor(8 * Tracking.pf);
	
	private double beta;
	private double beta_sq;
	private double R;
	private Capacitor Pmax;
	private Capacitor Tcmax;
	private Capacitor Pmin;
	private Capacitor Tlmax;
	private Capacitor P;
	private Capacitor Tc;
	private Inductor Lo;
	

	public Capacitor getTl() {
		return Tl;
	}
	
	public Capacitor getP() {
		return P;
	}

	public Capacitor getTc() {
		return Tc;
	}

	public Inductor getLo() {
		return Lo;
	}

	public Capacitor getPmin() {
		return Pmin;
	}

	public Capacitor getTlmax() {
		return Tlmax;
	}

	public double getBeta() {
		return this.beta;
	}

	public double getBeta_sq() {
		return this.beta_sq;
	}
	
	public double getR() {
		return R;
	}

	public Capacitor getPmax() {
		return Pmax;
	}

	public Capacitor getTcmax() {
		return Tcmax;
	}

	public OscillatorCircuit(Tracking trackingData) {
		this.trackingData = trackingData;
	}
	
	
	public void calculate() {
		this.beta = (this.trackingData.getUpperFreq() + this.trackingData.getIfFreq())/(this.trackingData.getLowerFreq() + this.trackingData.getIfFreq());
		this.beta_sq = Math.pow(this.beta, 2);
		this.R = calculateR();
		
		this.Pmax = new Capacitor(trackingData.getGmax()/(this.R - 1));
		this.Tcmax = new Capacitor(trackingData.getGmax()/((this.R * this.beta_sq) -1 ));
		
		this.Pmin = new Capacitor(this.Pmax.getValue() - this.Tcmax.getValue());
		
		this.Tlmax = new Capacitor(this.Pmax.getValue() * this.Tcmax.getValue()/this.Pmin.getValue());
		
		this.P = new Capacitor(this.Pmin.getValue() + this.Tl.getValue());
		this.Tc = new Capacitor(this.Tcmax.getValue() - this.Tl.getValue());
		
		this.Lo = calculateLo();
		
	}

	private Inductor calculateLo() {

		/*
		 * Lo = Pmin * Pmax/(Tcmax*p^2 *(w2 + wi)^2)
		 * 
		 */
		
		double w2 =trackingData.getUpperFreq() * 2 *Math.PI;
		double wi = trackingData.getIfFreq()  * 2 *Math.PI;
		double w2wi_sq = Math.pow((w2 + wi), 2);
		Inductor Lo = new Inductor(((this.Pmin.getValue() * this.Pmax.getValue())/this.Tcmax.getValue()) * 1/(Math.pow(this.P.getValue(),2) * w2wi_sq));
		return Lo;
	}

	private double calculateR() {
		
		double bracketsEqn = (1+this.beta) * this.trackingData.getAlpha_sqrt();
		
		double top = 2*this.beta + bracketsEqn;
		double bottom = 2*this.trackingData.getAlpha() + bracketsEqn;
		
		double R = (this.trackingData.getAlpha_sq()/this.beta_sq) *(top/bottom);
		
		return R;
	}
	
	public double calculateFo(double percentRotation) {
	
		Capacitor Tc = new Capacitor(this.Tc.getValue() - this.trackingData.getCapLow());
		
		double actualCap = (percentRotation * (this.trackingData.getCapHigh() - this.trackingData.getCapLow())) + this.trackingData.getCapLow();
		
		Capacitor G = new Capacitor(actualCap);
		
		PaddedTunedCircuit circuit = new PaddedTunedCircuit(this.Lo, Tl, P, Tc, G);
		
		double resFreq = circuit.calculateResonance();
		
		return resFreq;
	}
	
}
