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

@WebServlet("/chartData2")
public class googleChartPlot extends DataSourceServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public DataTable generateDataTable(Query query, HttpServletRequest request) {

		HttpSession session = request.getSession();

		Sweep sweepData = (Sweep) session.getAttribute("sweepData");

		// Create a data table,
		DataTable data = new DataTable();
		ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
		cd.add(new ColumnDescription("error", ValueType.NUMBER,
				"Error frequecy"));
		cd.add(new ColumnDescription("RF frequecu", ValueType.NUMBER,
				"RF frequecy"));

		data.addColumns(cd);

		int numPoints = sweepData.getOscFo().length;

		for (int i = 0; i < numPoints; i++) {
			try {
				data.addRowFromValues(sweepData.getSignalFo()[i],
						sweepData.getTrackError()[i]
						);
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
