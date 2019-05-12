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
 * Servlet implementation class controllerServlet
 */
@WebServlet("/controllerServlet")
public class controllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public controllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String usu = request.getParameter("usuario");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setUsuario(usu);
		usuario.setEmail(email);
		usuario.setPass(pass);

		UsuarioDao uDao = new UsuarioDao();

		
		if (uDao.usuarioUnico(usu)) {

				uDao.insert(usuario);
				request.getSession().setAttribute("usuario", usuario );
				RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
				rd.forward(request, response);
			
		}

		else {
			
			request.setAttribute("mensaje", "ERROR AL INGRESAR");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

		doGet(request, response);
	}

}
