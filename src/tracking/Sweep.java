package tracking;

public class Sweep {

	private double signalFo[] = new double[100];
	private double oscFo[] = new double[100];
	private double trackError[] = new double[100];
	
	private OscillatorCircuit osc;
	private SignalCircuit sig;
	
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
	public double[] getSignalFo() {
		return signalFo;
	}
	public void setSignalFo(double[] signalFo) {
		this.signalFo = signalFo;
	}
	public double[] getOscFo() {
		return oscFo;
	}
	public void setOscFo(double[] oscFo) {
		this.oscFo = oscFo;
	}
	public double[] getTrackError() {
		return trackError;
	}
	public void setTrackError(double[] trackError) {
		this.trackError = trackError;
	}

	
	
}
