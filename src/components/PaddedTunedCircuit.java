package components;

public class PaddedTunedCircuit extends TunedCircuit {

	Capacitor total_tuning_cap;
	double inductance;
	
	public PaddedTunedCircuit(double inductance, Capacitor Tl, Capacitor P, Capacitor Tc, Capacitor G) {

		super();
		
		this.inductance = inductance;
		this.total_tuning_cap = G;
		
		this.total_tuning_cap.addParallel(Tc);
		this.total_tuning_cap.addSerial(P);
		this.total_tuning_cap.addParallel(Tl);
		
		super.setCapacitance(total_tuning_cap);
		super.setInductance(inductance);
	}
	
	
	
	
}
