package tracking;

import java.util.HashMap;
import java.util.Map;

public class Tracking {

	public static final double pf = 1E-12;
	public static final double nf = 1E-9;
	public static final double uf = 1E-6;
	public static final double khz = 1E+3;
	public static final double mhz = 1E+6;
	public static final double hz = 1;
	public static final double uh = 1E-6;
	public static final double nh = 1E-9;
	
	Map<String, Double> unitsMap;
	
	public Tracking() {
		unitsMap = new HashMap<String, Double>();
		
		unitsMap.put("pF", pf);
		unitsMap.put("nF", nf);
		unitsMap.put("uF", uf);
		unitsMap.put("KHz", khz);
		unitsMap.put("MHz", mhz);
		unitsMap.put("Hz", hz);
		unitsMap.put("uH", uh);
		unitsMap.put("nH", nh);
	}
	
	
	private double upperFreq;
	private double lowerFreq;
	private double ifFreq;
	private double capHigh;
	private double capLow;
	private double capStray; 
	
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
	private String capStrayUnit;
	
	public String getCapStrayUnit() {
		return capStrayUnit;
	}
	public void setCapStrayUnit(String capStrayUnit) {
		this.capStrayUnit = capStrayUnit;
	}
	public double getUpperFreq() {
		return upperFreq;
	}
	public void setUpperFreq(double upperFreq) {
		this.upperFreq = upperFreq * unitsMap.get(this.upperFreqUnit);
	}
	public double getLowerFreq() {
		return lowerFreq;
	}
	public void setLowerFreq(double lowerFreq) {
		this.lowerFreq = lowerFreq * unitsMap.get(this.lowerFreqUnit);
	}
	public double getIfFreq() {
		return ifFreq;
	}
	public void setIfFreq(double ifFreq) {
		this.ifFreq = ifFreq * unitsMap.get(this.ifFreqUnit);
	}
	public double getCapHigh() {
		return capHigh;
	}
	public void setCapHigh(double capHigh) {
		this.capHigh = capHigh * unitsMap.get(this.capHighUnit);;
	}
	public double getCapLow() {
		return capLow;
	}
	public void setCapLow(double capLow) {
		this.capLow = capLow * unitsMap.get(this.capLowUnit);;
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
	
	public double getCapStray() {
		return capStray;
	}
	public void setCapStray(double capStray) {
		this.capStray = capStray * unitsMap.get(this.capStrayUnit);
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
