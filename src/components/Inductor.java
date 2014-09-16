package components;

public class Inductor extends Component {

	public double getValue() {
		return value;
	}
	
	public Inductor() {
		unit = "H";
	}
	
	public Inductor(double value) {
		this.value = value;
		unit = "H";
		super.calcUnitMult();
	}
}
