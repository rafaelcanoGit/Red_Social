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
 * Servlet implementation class PerfilController
 */
@WebServlet("/PerfilController")
public class PerfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usu = request.getParameter("usu");
		
		UsuarioDao uDao = new UsuarioDao();
		Usuario usuario = uDao.buscarPorUsuario(usu);
		
		
		request.getSession().setAttribute("usuario", usuario);
		request.getSession().setAttribute("uDao", uDao);
		
		RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
		rd.forward(request, response);
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
