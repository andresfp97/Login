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
import co.empresa.login.modelo.LoginVo;




/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDao loginDao;
       
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
		
		this.loginDao = new LoginDao();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch(action) {
			default:
				login(request, response);
				break;
		}
			
		} catch (SQLException e) {
			 throw new ServletException(e);
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usuario = request.getParameter("usuario");
		String contra = request.getParameter("pas");
		
		LoginVo loginVo = new LoginVo(usuario, contra);
		
		
		if (loginDao.login(loginVo)) {
			
			response.sendRedirect("Movimientos.jsp");	
			
		}
		
		else response.sendRedirect("formulario.jsp");
		System.out.println(contra);
	}

	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		LoginDao loginDao = new LoginDao();
		
		String usuario = request.getParameter("usuario");
		String contra = request.getParameter("pas");
		
		LoginVo loginVo = new LoginVo(usuario, contra);
		
		
		if (loginDao.login(loginVo)) {
			response.sendRedirect("Movimientos.jsp");		
		}
		
	}
	
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {	
		RequestDispatcher dispatcher = request.getRequestDispatcher("formulario.jsp");
		dispatcher.forward(request, response);
		
		
	}
	

}
