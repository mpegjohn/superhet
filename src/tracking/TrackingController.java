package tracking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Tracking trackingBean = new Tracking();
		trackingBean.setCapHigh(100.6);
		request.setAttribute("trackingBean", trackingBean);
		RequestDispatcher rd = request.getRequestDispatcher("KeyData.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tracking trackingBean = (Tracking) request.getAttribute("trackingBean");
		
		
		
		// TODO Auto-generated method stub
	}

}
