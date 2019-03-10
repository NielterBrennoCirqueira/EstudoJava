package br.com.nielter.controller;

import java.io.IOException;

import javax.management.relation.RelationSupportMBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.nielter.entidades.Usuario;
import br.com.nielter.jdbc.UsuarioDAO;

/**
 * Servlet implementation class Autenticador
 */
@WebServlet(name = "AutenticadorController", urlPatterns = { "/autcontroller.do" })
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenticador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(false);
		
		if(sessao != null){
			sessao.invalidate(); 
		}
		response.sendRedirect("login.html");
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Capturar dados da tela
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		//Controe objeto usu�rio para consulta
		Usuario usuario = new Usuario();
		usuario.setUsuario(login);
		usuario.setSenha(senha);
		
		//Busca no banco de dados
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuRetorno= usuarioDAO.Autenticar(usuario);
		
		if(usuRetorno != null){
			
			//Criando Sess�o
			HttpSession sessao = request.getSession();
			sessao.setMaxInactiveInterval(3000);
			sessao.setAttribute("usuLogado", usuRetorno);
			
			//Encaminhando ao index
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			
		} else {
			
			response.sendRedirect("login.html");
		}
		
		
	}

}
