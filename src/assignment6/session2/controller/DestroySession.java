package assignment6.session2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DestroyServlet
 */
@WebServlet("/DestroySession")
public class DestroySession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestroySession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
	    PrintWriter pw = response.getWriter();
	    pw.println( "<html><body>" );

	    // get current session, and don't create one if it doesn't exist
	    HttpSession currentSession = request.getSession( false );
	    // print out the session id
	    if( currentSession != null ) {
	      pw.println( "<br>Session Id: " + currentSession.getId() );
	      // invalidating a session destroys it
    	  currentSession.invalidate();
    	  pw.println( "<br>Session destroyed..." );
	    }

	    pw.println( "</body></html>" );
	    pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
