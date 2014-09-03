package tracking;

public class Sweep {

	private double signalFo[] = new double[100];
	private double oscFo[] = new double[100];
	private double trackError[] = new double[100];
	
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
