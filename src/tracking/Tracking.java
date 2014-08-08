package tracking;

public class Tracking {
	
	public Tracking() {
		
	}
	
	public static final double pf = Math.pow(10, -12);
	public static final double khz = Math.pow(10, 3);
	public static final double uh = Math.pow(10, -6);
	
	private double upperFreq;
	private double lowerFreq;
	private double ifFreq;
	private double capHigh;
	private double capLow;
	public double getUpperFreq() {
		return upperFreq;
	}
	public void setUpperFreq(double upperFreq) {
		this.upperFreq = upperFreq;
	}
	public double getLowerFreq() {
		return lowerFreq;
	}
	public void setLowerFreq(double lowerFreq) {
		this.lowerFreq = lowerFreq;
	}
	public double getIfFreq() {
		return ifFreq;
	}
	public void setIfFreq(double ifFreq) {
		this.ifFreq = ifFreq;
	}
	public double getCapHigh() {
		return capHigh;
	}
	public void setCapHigh(double capHigh) {
		this.capHigh = capHigh;
	}
	public double getCapLow() {
		return capLow;
	}
	public void setCapLow(double capLow) {
		this.capLow = capLow;
	}
	
	
	
}
