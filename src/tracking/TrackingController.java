package tracking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tracking.Tracking;

/**
 * Servlet implementation class TrackingController
 */
@WebServlet("/TrackingController")
public class TrackingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackingController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() {
    
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


			Tracking tracking = (Tracking)  request.getAttribute("trackingDataBean");
			
			tracking.calculate();
			
			OscillatorCircuit osc = new OscillatorCircuit(tracking);
			osc.calculate();
			
			SignalCircuit sig = new SignalCircuit(tracking);
			sig.calculate();
			
			double signalFo[] = new double[100];
			double oscFo[] = new double[100];
			double trackError[] = new double[100];
			
			for(int i = 0; i < 100; i++)
			{
				double rotation = (double) i/100.0;
				signalFo[i] = sig.calculateFo(rotation);
				oscFo[i] = osc.calculateFo(rotation);
				
				trackError[i] = (oscFo[i] - signalFo[i]) - tracking.getIfFreq(); 
			}
			
			Sweep sweep = new Sweep();
			sweep.setOscFo(oscFo);
			sweep.setSignalFo(signalFo);
			sweep.setTrackError(trackError);
			sweep.setOsc(osc);
			sweep.setSig(sig);
			sweep.setTrack(tracking);
		
			HttpSession session = request.getSession();
			session.setAttribute("sweepData", sweep);
			RequestDispatcher rd = request.getRequestDispatcher("showSweep.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);

	}

}
