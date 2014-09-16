package components;

public class TunedCircuit {

	Inductor inductance;
	Capacitor capacitance;

	public TunedCircuit() {
		
	}
	
	public TunedCircuit(Inductor inductance, Capacitor capacitance) {
		this.inductance = inductance;
		this.capacitance = capacitance;
	}
	
	public Inductor getInductance() {
		return inductance;
	}

	public void setInductance(Inductor inductance) {
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
		double resonance = 1/(2*Math.PI* Math.sqrt(inductance.getValue() * capacitance.getValue()));
		return resonance;
	}
}
