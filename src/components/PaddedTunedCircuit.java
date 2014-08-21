package components;

public class PaddedTunedCircuit extends TunedCircuit {
	
	public PaddedTunedCircuit(double inductance, Capacitor Tl, Capacitor P, Capacitor Tc, Capacitor G) {

		super.inductance = inductance;
		super.capacitance = new Capacitor(G.value);
		
		super.capacitance.addParallel(Tc);
		super.capacitance.addSerial(P);
		super.capacitance.addParallel(Tl);

	}
	
	
	
	
}
