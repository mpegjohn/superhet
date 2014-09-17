package components;

public class Component {

	protected double value;
	
	String unit;
	
	private double multipliedValue;
	private String mult;
	private String formattedNumber;

	public String getMult() {
		return mult;
	}

	public String getFormattedNumber() {
		return formattedNumber;
	}

	public void calcUnitMult() {

		String[] mults = { "m", "u", "n", "p" };

		String mult = "";

		this.multipliedValue = value;
		
		int i = 0;
		while (this.multipliedValue < 1.0) {
			this.multipliedValue *= 1000;
			mult = mults[i];
			i++;
		}

		formattedNumber = String.format("%.2f %s%s", multipliedValue, mult, unit);

		this.mult = mult;
	}
	
	public String toString() {
		return formattedNumber;
	}

}
