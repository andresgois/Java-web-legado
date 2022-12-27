package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.servlet.dao.Banco;
import br.com.gerenciador.servlet.model.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /** @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)    */
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Cadastrando nova empresa");
        String nomeEmpresa = request.getParameter("nome");
        String dataAberturaEmpresa = request.getParameter("data");
        Date dataAbertura = null;
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(dataAberturaEmpresa);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);
        
        Banco banco = new Banco();
        banco.adicionar(empresa);
        
        /*PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h3>Cadastrando nova empresa: "+ nomeEmpresa +"</h3>");
        out.println("</body>");
        out.println("</html>");*/
        
        // Chama o JSP
        //RequestDispatcher rd = request.getRequestDispatcher("/NovaEmpresaCriada.jsp");
        // Para utilizar o client side a parte abaixo ficara comentada
        /*RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
        request.setAttribute("nomeEmpresa", empresa.getNome());
        rd.forward(request, response);*/
        request.setAttribute("nomeEmpresa", empresa.getNome());
        response.sendRedirect("listaEmpresas");
        
    }
    
}
