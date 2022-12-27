package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.gerenciador.servlet.dao.Banco;
import br.com.gerenciador.servlet.model.Empresa;

@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// antes era = doGet
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Banco b = new Banco();
	    
	    List<Empresa> lista = b.getEmpresas();
	    RequestDispatcher rd = request.getRequestDispatcher("listaEmpresas.jsp");
	        
	    request.setAttribute("empresas", lista);
	    rd.forward(request, response);
	   /* PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        
	    lista.forEach(
	           x -> out.println("<li> "+ x.getNome() +"</li>")
	            );
	    out.println("</body>");
	    out.println("</html>");*/
	}

}
