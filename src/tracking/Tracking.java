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
	
	private double f3;
	private double gmax;
	private double alpha;
	private double alpha_sq;
	private double alpha_sqrt;
	
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
	
	public double getF3() {
		return f3;
	}
	public double getGmax() {
		return gmax;
	}
	public double getAlpha() {
		return alpha;
	}
	public double getAlpha_sq() {
		return alpha_sq;
	}
	
	public double getAlpha_sqrt() {
		return alpha_sqrt;
	}
	
	public void calculate() {
		// Calculation
		// Third tracking frequency 
		
		this.f3 = Math.sqrt(upperFreq * lowerFreq);
		
		this.gmax = capHigh - capLow;
		
		this.alpha =  upperFreq / lowerFreq;
		
		this.alpha_sq = Math.pow(alpha, 2);
		
		this.alpha_sqrt = Math.sqrt(alpha);	
	}
	
}
