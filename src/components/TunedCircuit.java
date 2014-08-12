package components;

public class TunedCircuit {

	double inductance;
	double capacitance;
	
	public double getInductance() {
		return inductance;
	}

	public void setInductance(double inductance) {
		this.inductance = inductance;
	}

	public double getCapacitance() {
		return capacitance;
	}

	public void setCapacitance(double capacitance) {
		this.capacitance = capacitance;
	}

	public TunedCircuit(double inductance, double capacitance) {
		this.inductance = inductance;
		this.capacitance = capacitance;
	}
	
	public double calculateResonance()
	{
		double resonance = 1/(2*Math.PI* Math.sqrt(inductance * capacitance));
		return resonance;
	}
	
}
