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
 * Servlet implementation class Perfil2control
 */
@WebServlet("/Perfil2control")
public class Perfil2control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Perfil2control() {
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
		   String user = request.getParameter("usu2");
	        
			
	        UsuarioDao uDao = new UsuarioDao();
	        Usuario usuario =  uDao.buscarPorUsuario(user);
	        System.out.println(usuario.getNombre());
			//UsuarioDao uDao = (UsuarioDao) request.getSession().getAttribute("uDao");
		 //	Usuario usuario = uDao.buscarPorUsuario(user);
			
			request.setAttribute("user", usuario);
		    request.getSession().setAttribute("usuario",request.getSession().getAttribute("usuario"));
		   //	request.getSession().setAttribute("uDao",new UsuarioDao());
		
			request.getSession().setAttribute("uDao", uDao );
			
			RequestDispatcher rd = request.getRequestDispatcher("perfilOtro.jsp");
			rd.forward(request, response);
		
		
		doGet(request, response);
	}

}
