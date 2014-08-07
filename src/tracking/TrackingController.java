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
		
		Tracking trackingBean = (Tracking)request.getSession().getAttribute("trackingBean");
		
		if(trackingBean == null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("KeyData.jsp");
			rd.forward(request, response);
		}
		else
		{

			// Calculation
			// Third tracking frequency 
			double f1 = trackingBean.getLowerFreq();
			double f2 = trackingBean.getUpperFreq();
			
			double f3 = Math.sqrt(f2 * f1);
			
			double gmax = trackingBean.getCapHigh() - trackingBean.getCapLow();
			
			double alpha = f2 / f1;
			
			double alpha_sq = Math.pow(alpha, 2);
			
			double t = gmax /(alpha_sq - 1);
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);

	}

}
