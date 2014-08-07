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
		
			double f1 = Double.parseDouble(request.getParameter("lowerFreq"));
			double f2 = Double.parseDouble(request.getParameter("upperFreq"));
			double capLow = Double.parseDouble(request.getParameter("capLow"));
			double capHigh = Double.parseDouble(request.getParameter("capHigh"));
			
			// Calculation
			// Third tracking frequency 
			
			double f3 = Math.sqrt(f2 * f1);
			
			double gmax = capHigh - capLow;
			
			double alpha = f2 / f1;
			
			double alpha_sq = Math.pow(alpha, 2);
			
			double t = gmax /(alpha_sq - 1);
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);

	}

}
