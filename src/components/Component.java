package components;


public class Component {

	private String unit;
	private double value;
	private String mult;
	private String formattedNumber;

 public String getUnit() {
		return unit;
	}

	public double getValue() {
		return value;
	}

	public String getMult() {
		return mult;
	}

	public String getFormattedNumber() {
		return formattedNumber;
	}

public  void calcUnitMult(double value, String unit) {

        String[] mults = {"m", "u", "n", "p"};

        String mult = "";

        int i = 0;
        while(value < 1.0) {
                value *= 1000;
                mult = mults[i];
                i++;
        };

        formattedNumber =  String.format("%.2f $s%s",value, mult, unit);

        this.value = value;
        this.unit = unit;
        this.mult = mult;
}

}
