package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import servicies.UsuarioDao;

/**
 * Servlet implementation class controllerServlet2
 */
@WebServlet("/controllerServlet2")
public class controllerServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UsuarioDao uDao = new UsuarioDao();
		String email= request.getParameter("email");
		String pass= request.getParameter("password");
		
		
    
         if(uDao.validarIngreso(email, pass)) {
		  				
            Usuario usu = uDao.buscarPorEmail(email); 
		    request.getSession().setAttribute("usuario", usu );
		    request.getSession().setAttribute("uDao", uDao);
			RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
			rd.forward(request, response);
				
			} else {
				
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			}
		
				
		doGet(request, response);
	}

}
