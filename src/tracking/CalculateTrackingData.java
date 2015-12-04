package tracking;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class CalculateTrackingData
 */
@WebServlet("/CalculateTrackingData")
public class CalculateTrackingData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateTrackingData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

		Design design = new Design();
		
		design .setTrack(trackingData);
		design.setOsc(osc);
		design.setSig(sig);
		
		HttpSession session = request.getSession();
		session.setAttribute("design", design);

		Map<String, String> options = new LinkedHashMap<String, String>();
		
		options.put("osc_ind", osc.getLo().toString());
		options.put("osc_padder", osc.getP().toString());
		options.put("osc_trimmer", osc.getTc().toString());
		options.put("osc_stray", osc.getTl().toString());
		
		options.put("sig_ind", sig.getL().toString());
		options.put("sig_trimmer", sig.getT().toString());

		String json = new Gson().toJson(options);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
