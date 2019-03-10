package br.com.nielter.controller;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroAutentica
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/*" })
public class FiltroAutentica implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAutentica() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//Casting do httpServelt Request
		HttpServletRequest httpServeletRequest =(HttpServletRequest) request;
		
		String url  = httpServeletRequest.getRequestURI();
		//Capturando Sess�o
		HttpSession sessao = httpServeletRequest.getSession();
		
		//Est� Logado?
		if (sessao.getAttribute("usuLogado") != null || url.lastIndexOf("login.html") > -1 || url.lastIndexOf("autcontroller.do") > -1){
			chain.doFilter(request, response); //Permite o fluxo da requisi��o
		} else {
			//Redireciona para login
			((HttpServletResponse) response).sendRedirect("login.html");
		}
		
		
		}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
