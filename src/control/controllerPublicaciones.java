package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.Publicacion;
import model.Usuario;

import servicies.UsuarioDao;

/**
 * Servlet implementation class controllerPublicaciones
 */
@WebServlet("/controllerPublicaciones")
public class controllerPublicaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerPublicaciones() {
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
       int id = Integer.parseInt(request.getParameter("pub"));
       UsuarioDao uDao= (UsuarioDao) request.getSession().getAttribute("uDao");
       Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
       
       System.out.println(usuario.getNombre());
       
       Publicacion publicacion = uDao.PublicacionById( id, usuario.getUsuario());
       
		String nombreP = publicacion.getNombre();
		
		System.out.println(nombreP);
		
		request.getSession().setAttribute("usuario", usuario);
		request.getSession().setAttribute("uDao", uDao);
		request.setAttribute("nombreP", nombreP);
		
		RequestDispatcher rd = request.getRequestDispatcher("PUB.jsp");
		rd.forward(request, response);
		
		doGet(request, response);
	}

}
