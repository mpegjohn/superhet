package tracking;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
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

		Tracking trackingData = new Tracking();

		trackingData.setUpperFreqUnit(request.getParameter("upperFreqUnit"));
		trackingData.setLowerFreqUnit(request.getParameter("lowerFreqUnit"));
		trackingData.setIfFreqUnit(request.getParameter("ifFreqUnit"));
		trackingData.setCapHighUnit(request.getParameter("capHighUnit"));
		trackingData.setCapLowUnit(request.getParameter("capLowUnit"));
		trackingData.setCapStrayUnit(request.getParameter("capStrayUnit"));
		trackingData.setUpperFreq(Double.parseDouble(request
				.getParameter("upperFreq")));
		trackingData.setLowerFreq(Double.parseDouble(request
				.getParameter("lowerFreq")));
		trackingData.setIfFreq(Double.parseDouble(request
				.getParameter("ifFreq")));
		trackingData.setCapHigh(Double.parseDouble(request
				.getParameter("capHigh")));
		trackingData.setCapLow(Double.parseDouble(request
				.getParameter("capLow")));
		trackingData.setCapStray(Double.parseDouble(request
				.getParameter("capStray")));

		trackingData.calculate();

		OscillatorCircuit osc = new OscillatorCircuit(trackingData);
		osc.calculate();

		SignalCircuit sig = new SignalCircuit(trackingData);
		sig.calculate();

		double signalFo[] = new double[100];
		double oscFo[] = new double[100];
		double trackError[] = new double[100];

		for (int i = 0; i < 100; i++) {
			double rotation = (double) i / 100.0;
			signalFo[i] = sig.calculateFo(rotation);
			oscFo[i] = osc.calculateFo(rotation);

			trackError[i] = (oscFo[i] - signalFo[i]) - trackingData.getIfFreq();
		}

		Sweep sweep = new Sweep();
		sweep.setOscFo(oscFo);
		sweep.setSignalFo(signalFo);
		sweep.setTrackError(trackError);
		sweep.setOsc(osc);
		sweep.setSig(sig);
		sweep.setTrack(trackingData);

		// Create a data table,
		DataTable data = new DataTable();
		ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
		cd.add(new ColumnDescription("error", ValueType.NUMBER,
				"Error frequecy"));
		cd.add(new ColumnDescription("RF frequecu", ValueType.NUMBER,
				"RF frequecy"));

		data.addColumns(cd);

		int numPoints = sweep.getOscFo().length;

		for (int i = 0; i < numPoints; i++) {
			try {
				data.addRowFromValues(sweep.getSignalFo()[i],
						sweep.getTrackError()[i]);
			} catch (TypeMismatchException e) {
				System.out.println("Invalid type!");
			}
		}
		
		data.setCustomProperty("osc_ind", osc.getLo().toString());
		data.setCustomProperty("osc_padder", osc.getP().toString());
		data.setCustomProperty("osc_trimmer", osc.getTc().toString());
		data.setCustomProperty("osc_stray", osc.getTl().toString());
		
		data.setCustomProperty("sig_ind", sig.getL().toString());
		data.setCustomProperty("sig_trimmer", sig.getT().toString());
		
		return data;
	}

	@Override
	protected boolean isRestrictedAccessMode() {
		return false;
	}
}
