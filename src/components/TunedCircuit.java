package components;

public class TunedCircuit {

	double inductance;
	Capacitor capacitance;

	public TunedCircuit() {
		
	}
	
	public TunedCircuit(double inductance, Capacitor capacitance) {
		this.inductance = inductance;
		this.capacitance = capacitance;
	}
	
	public double getInductance() {
		return inductance;
	}

	public void setInductance(double inductance) {
		this.inductance = inductance;
	}

	public Capacitor getCapacitance() {
		return capacitance;
	}

	public void setCapacitance(Capacitor capacitance) {
		this.capacitance = capacitance;
	}

	public double calculateResonance()
	{
		double resonance = 1/(2*Math.PI* Math.sqrt(inductance * capacitance.getValue()));
		return resonance;
	}
}
