package tracking;

public class Design {
	
	private OscillatorCircuit osc;
	private SignalCircuit sig;
	private Tracking track;
	
	public Tracking getTrack() {
		return track;
	}
	public void setTrack(Tracking track) {
		this.track = track;
	}
	public OscillatorCircuit getOsc() {
		return osc;
	}
	public void setOsc(OscillatorCircuit osc) {
		this.osc = osc;
	}
	public SignalCircuit getSig() {
		return sig;
	}
	public void setSig(SignalCircuit sig) {
		this.sig = sig;
	}

}
