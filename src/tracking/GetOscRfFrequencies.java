package tracking;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.visualization.datasource.DataSourceServlet;
import com.google.visualization.datasource.base.TypeMismatchException;
import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.google.visualization.datasource.query.Query;

@WebServlet("/GetFrequencyData")
public class GetOscRfFrequencies extends DataSourceServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public DataTable generateDataTable(Query query, HttpServletRequest request) {


		HttpSession session = request.getSession();
		
		Design design = (Design) session.getAttribute("design");
		
		
		double signalFo[] = new double[100];
		double oscFo[] = new double[100];
		double degressRotation[] = new double[100];

		for (int i = 0; i < 100; i++) {
			double rotation = (double) i / 100.0;
			signalFo[i] = design.getSig().calculateFo(rotation);
			oscFo[i] = design.getOsc().calculateFo(rotation);
			degressRotation[i] = 180.0 * rotation;
		}


		// Create a data table,
		DataTable data = new DataTable();
		ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
		cd.add(new ColumnDescription("Rotation", ValueType.NUMBER,
				"Rotation"));

		cd.add(new ColumnDescription("RF frequency", ValueType.NUMBER,
				"RF frequecy"));
		cd.add(new ColumnDescription("error", ValueType.NUMBER,
				"Oscillator frequecy"));

		data.addColumns(cd);

		int numPoints = oscFo.length;

		for (int i = 0; i < numPoints; i++) {
			try {
				data.addRowFromValues( 
						degressRotation[i],
						signalFo[i],
						oscFo[i]);
			} catch (TypeMismatchException e) {
				System.out.println("Invalid type!");
			}
		}
		
		
		return data;
	}

	@Override
	protected boolean isRestrictedAccessMode() {
		return false;
	}
}
