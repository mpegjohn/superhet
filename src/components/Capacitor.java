package components;

public class Capacitor extends Component {

	double value;

	public double getValue() {
		return value;
	}

	public Capacitor(double value)
	{
		this.value = value;
	}

	public void addParallel(Capacitor cap)
	{
		this.value += cap.getValue();
	}
	
	public void addSerial(Capacitor cap)
	{
		this.value = (this.value * cap.getValue())/(this.value + cap.getValue());
		
	}
}
