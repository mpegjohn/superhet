package tracking;

public class Tracking {
	
	public Tracking() {
		
	}
	
	public static final double pf = 1E-12;
	public static final double khz = 1E+3;
	public static final double mhz = 1E+6;
	public static final double uh = 1E-6;
	
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
	
	public String getUpperFreqUnit() {
		return upperFreqUnit;
	}
	public void setUpperFreqUnit(String upperFreqUnit) {
		this.upperFreqUnit = upperFreqUnit;
	}
	public String getLowerFreqUnit() {
		return lowerFreqUnit;
	}
	public void setLowerFreqUnit(String lowerFreqUnit) {
		this.lowerFreqUnit = lowerFreqUnit;
	}
	public String getIfFreqUnit() {
		return ifFreqUnit;
	}
	public void setIfFreqUnit(String ifFreqUnit) {
		this.ifFreqUnit = ifFreqUnit;
	}
	public String getCapHighUnit() {
		return capHighUnit;
	}
	public void setCapHighUnit(String capHighUnit) {
		this.capHighUnit = capHighUnit;
	}
	public String getCapLowUnit() {
		return capLowUnit;
	}
	public void setCapLowUnit(String capLowUnit) {
		this.capLowUnit = capLowUnit;
	}

	private String upperFreqUnit;
	private String lowerFreqUnit;
	private String ifFreqUnit;
	private String capHighUnit;
	private String capLowUnit;
	
	public double getUpperFreq() {
		return upperFreq;
	}
	public void setUpperFreq(double upperFreq) {
		this.upperFreq = upperFreq * khz;
	}
	public double getLowerFreq() {
		return lowerFreq;
	}
	public void setLowerFreq(double lowerFreq) {
		this.lowerFreq = lowerFreq * khz;
	}
	public double getIfFreq() {
		return ifFreq;
	}
	public void setIfFreq(double ifFreq) {
		this.ifFreq = ifFreq * khz;
	}
	public double getCapHigh() {
		return capHigh;
	}
	public void setCapHigh(double capHigh) {
		this.capHigh = capHigh * pf;
	}
	public double getCapLow() {
		return capLow;
	}
	public void setCapLow(double capLow) {
		this.capLow = capLow * pf;
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
