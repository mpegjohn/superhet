package components;

public class Capacitor extends Component {

	//double value;

	public Capacitor() {
		unit = "F";
	}
	
	public double getValue() {
		return value;
	}

	public Capacitor(double value)
	{
		this.value = value;
		unit = "F";
		super.calcUnitMult();
	}

	public void addParallel(Capacitor cap)
	{
		this.value += cap.getValue();
		super.calcUnitMult();
	}
	
	public void addSerial(Capacitor cap)
	{
		this.value = (this.value * cap.getValue())/(this.value + cap.getValue());
		super.calcUnitMult();
	}
}
