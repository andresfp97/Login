package co.empresa.login.control;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.login.dao.LoginDao;
import co.empresa.login.modelo.Login;



/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDao  usuarioDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
	
		this.usuarioDao = new LoginDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("Login.jsp");
		
		Login usuario =  new  LoginDao().select(1);
			
		String autorizacion = request.getHeader("Authorization");
			
		if (autorizacion == null)
		{			
			response.setStatus(response.SC_UNAUTHORIZED);
			response.setHeader("WWW-Authenticate", 
			   "BASIC realm=\"privileged-few\"");
		}
		else
		{
			
			
			String user = new String ( usuario.getUsuario());
		    String password = new String ( usuario.getPas());

			
			String usuario = 
			   usuarioPassword.substring(0, indice);

			String password = 
			   usuarioPassword.substring(indice + 1);

			String passwordReal = 
			   datos.getProperty(usuario);
			
			if (passwordReal != null && 
			    passwordReal.equals(password))
			{
				// Mensaje de bienvenida
					
				PrintWriter out = response.getWriter();
				out.println ("<HTML><BODY>");
				out.println ("OK");
				out.println ("</BODY></HTML>");	
			} else {
					
				// Pedir autentificacion

				response.setStatus 
				   (response.SC_UNAUTHORIZED);
				response.setHeader
				   ("WWW-Authenticate", 
				   "BASIC realm=\"privileged-few\"");
			}
		}
		
		
		

		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	
	
	
	
	
	
	

}
