package co.simplon.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   // public Login() {
    //    super();
        // TODO Auto-generated constructor stub
        @Override
    
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          // System.out.println( "In the service method" );
            super.service(req, resp);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //System.out.println( "In the doGet" );
             
            String login = request.getParameter( "txtLogin" );
            String password = request.getParameter( "txtPassword" );
            if ( login == null ) login = "";
            if ( password == null ) password = "";
            //recuperer
            HttpSession session = request.getSession( true );
            session.setAttribute( "login", login );
            session.setAttribute( "password", password );
            
          //  request.getRequestDispatcher( "/vue.jsp" ).forward( request, response );

            response.setContentType( "text/html" );
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String login = request.getParameter( "txtLogin" );
            String password = request.getParameter( "txtPassword" );
             
           //System.out.println( "in the doPost" );

            if ( login.equals( "mohamoud" ) && password.equals( "623377" ) ) {
                response.setContentType( "text/html" );
                try ( PrintWriter out = response.getWriter() ) {
                	 //ServletRequest session = null;
					//session.setAttribute( "isConnected", true );
                    //request.getRequestDispatcher( "/Connected.jsp" ).forward( request, response );}
                    out.println( "OK" );
                }
            } else {
                doGet( request, response );
            }        }

    }