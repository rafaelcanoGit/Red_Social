package control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Amistad;
import model.Usuario;
import servicies.AmistadDao;
import servicies.UsuarioDao;

/**
 * Servlet implementation class amistadControl
 */
@WebServlet("/amistadControl")
public class amistadControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public amistadControl() {
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
		UsuarioDao uDao= (UsuarioDao) request.getSession().getAttribute("uDao");
		
		Usuario usuario1 = (Usuario) request.getSession().getAttribute("usuario");
		Usuario usuario2 = uDao.buscarPorUsuario(request.getParameter("user"));
		
		System.out.println("usuario1 "+usuario1.getNombre());
		System.out.println("usuario2 "+ usuario2.getNombre());
		
		
		Amistad amistad = new Amistad();
		amistad.setEstado(1);
		amistad.setUsuario1(usuario1);
		amistad.setUsuario2(usuario2);
		Date fecha = new Date();
		amistad.setFechasolicitud(fecha);
		
		
		
		AmistadDao aDao= new AmistadDao() ;
		aDao.insert(amistad);
		
		request.getSession().setAttribute("usuario", usuario1);
		request.getSession().setAttribute("uDao", uDao);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
		rd.forward(request, response);
		
		
		doGet(request, response);
	}

}
