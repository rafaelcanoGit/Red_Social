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
import servicies.PublicacionDao;
import servicies.UsuarioDao;

/**
 * Servlet implementation class subidaController
 */
@WebServlet("/subidaController")
public class subidaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public subidaController() {
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
		
		String name = request.getParameter("image");
		Usuario usu = (Usuario) request.getSession().getAttribute("usuario");
	
		
		System.out.println("hola 1 "+ usu.getNombre());
		System.out.println("hola 2 "+ name );
		
		Publicacion pub= new Publicacion();
		pub.setNombre(name);
		pub.setUsuarioBean(usu);
		pub.setAcceso(1);
		
		
		PublicacionDao pubDao = new PublicacionDao();
		pubDao.insert(pub);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
		rd.forward(request, response);
		
		doGet(request, response);
	}

}
