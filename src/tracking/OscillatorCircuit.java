package tracking;

import components.Capacitor;
import components.PaddedTunedCircuit;

public class OscillatorCircuit {

	private Tracking trackingData;

	/***
	 * Stray capacitance
	 */
	private final double Tl = 8 * Tracking.pf;
	
	private double beta;
	private double beta_sq;
	private double R;
	private double Pmax;
	private double Tcmax;
	private double Pmin;
	private double Tlmax;
	private double P;
	private double Tc;
	private double Lo;
	

	public double getTl() {
		return Tl;
	}
	
	public double getP() {
		return P;
	}

	public double getTc() {
		return Tc;
	}

	public double getLo() {
		return Lo;
	}

	public double getPmin() {
		return Pmin;
	}

	public double getTlmax() {
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

	public double getPmax() {
		return Pmax;
	}

	public double getTcmax() {
		return Tcmax;
	}

	public OscillatorCircuit(Tracking trackingData) {
		this.trackingData = trackingData;
	}
	
	
	public void calculate() {
		this.beta = (this.trackingData.getUpperFreq() + this.trackingData.getIfFreq())/(this.trackingData.getLowerFreq() + this.trackingData.getIfFreq());
		this.beta_sq = Math.pow(this.beta, 2);
		this.R = calculateR();
		
		this.Pmax = this.trackingData.getGmax()/(this.R - 1);
		this.Tcmax = this.trackingData.getGmax()/((this.R * this.beta_sq) -1 );
		
		this.Pmin = this.Pmax - this.Tcmax;
		
		this.Tlmax = this.Pmax * this.Tcmax/this.Pmin;
		
		this.P = this.Pmin + this.Tl;
		this.Tc = this.Tcmax- this.Tl;
		
		this.Lo = calculateLo();
		
	}

	private double calculateLo() {

		/*
		 * Lo = Pmin * Pmax/(Tcmax*p^2 *(w2 + wi)^2)
		 * 
		 */
		
		double w2 =trackingData.getUpperFreq() * 2 *Math.PI;
		double wi = trackingData.getIfFreq()  * 2 *Math.PI;
		double w2wi_sq = Math.pow((w2 + wi), 2);
		double Lo =  ((this.Pmin * this.Pmax)/this.Tcmax) * 1/(Math.pow(this.P,2) * w2wi_sq);
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
	
		Capacitor Tl = new Capacitor(this.Tl);
		Capacitor P = new Capacitor(this.P);
		Capacitor Tc = new Capacitor(this.Tc - this.trackingData.getCapLow());
		
		double actualCap = (percentRotation * (this.trackingData.getCapHigh() - this.trackingData.getCapLow())) + this.trackingData.getCapLow();
		
		Capacitor G = new Capacitor(actualCap);
		
		PaddedTunedCircuit circuit = new PaddedTunedCircuit(this.Lo, Tl, P, Tc, G);
		
		double resFreq = circuit.calculateResonance();
		
		return resFreq;
	}
	
}
