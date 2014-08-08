package tracking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

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
		
			double f1 = tracking.getLowerFreq();
			double f2 = tracking.getUpperFreq();
			double capLow = tracking.getCapLow();
			double capHigh = tracking.getCapHigh();
			double ifFreq = tracking.getIfFreq();
			
			// Calculation
			// Third tracking frequency 
			
			double f3 = Math.sqrt(f2 * f1);
			
			double gmax = capHigh - capLow;
			
			double alpha = f2 / f1;
			
			double alpha_sq = Math.pow(alpha, 2);
			
			double T = gmax /(alpha_sq - 1);
		
			double L = 1/(T * (Math.pow((2 * Math.PI * f2),2)));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);

	}

}
