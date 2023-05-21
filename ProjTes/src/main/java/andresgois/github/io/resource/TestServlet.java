package andresgois.github.io.resource;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import andresgois.github.io.dao.AssuntoDAO;
import andresgois.github.io.dao.ProcessoDAO;
import andresgois.github.io.dao.deprecated.UsuarioMysqlDAO;
import andresgois.github.io.dao.deprecated.UsuarioPostgresqlDAO;
import andresgois.github.io.to.AssuntoTO;
import andresgois.github.io.to.ProcessoBancoTO;
import andresgois.github.io.todeprecated.UsuarioTO;




@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserTransaction ut;
	
	//@PersistenceContext(unitName = "PostgresDS")
	private EntityManager em;

    public TestServlet() {
        super();
    }

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<UsuarioTO> lista = UsuarioMysqlDAO.getInstance().listAllUsers();
		PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table>");
        	out.println("<tr>");
        		out.println("<th>Id</th>");
        		out.println("<th>Nome</th>");
        		out.println("<th>Matrícula</th>");
        	out.println("</tr>");
	    lista.forEach(
	           x -> out.println(
	        		   "<tr><td> "+ x.getId() +"</td>"+
	        		   "<td> "+ x.getNome() +"</td>"+
	        		   "<td> "+ x.getMatricula() +"</td></tr>"
	        		   )
	            );
	    out.println("</table>");
	    out.println("</body>");
	    out.println("</html>");
		/*UsuarioTO u = new UsuarioTO();
		u.setNome("Beatriz");
		u.setMatricula("12589");
		try {
			ut.begin();
			em.persist(u);
			ut.commit();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Usuario criado com id: "+u.getId()).close();
	}*/

    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//List<UsuarioTO> lista = UsuarioMysqlDAO.getInstance().listAllUsers();
    	//http://localhost:8080/ProjTes/TestServlet?matricula=123456
		String paramMatricula = request.getParameter("matricula");
		UsuarioTO x;
		try {
			x = UsuarioMysqlDAO.getInstance().userPorMatricula(paramMatricula);
			
			if(x == null) {
				x = UsuarioPostgresqlDAO.getInstance().userPorMatricula(paramMatricula);
			}
			
			PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<body>");
	        out.println("<table>");
	        	out.println("<tr>");
	        		out.println("<th>Id</th>");
	        		out.println("<th>Nome</th>");
	        		out.println("<th>Matrícula</th>");
	        	out.println("</tr>");

	        	out.println("<tr><td> "+ x.getId() +"</td>"+
		        		   "<td> "+ x.getNome() +"</td>"+
		        		   "<td> "+ x.getMatricula() +"</td></tr>");

		    out.println("</table>");
		    out.println("</body>");
		    out.println("</html>");
		} catch (Exception e) {
			response.getWriter().append("Usuario não encontrado!").close();
		}
		
	}*/
    
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	//http://localhost:8080/ProjTes/TestServlet?matricula=123456
		try {
			List<AssuntoTO> PJE2G = AssuntoDAO.getInstance().listAssuntos("PJE2G");
			
			System.out.println("PJE1G");
			StringBuilder sb = new StringBuilder();
			for(AssuntoTO pj: PJE2G) {
				sb.append(pj.getCdAssunto()+ " - "+pj.getDescricao()+"\n");
				System.out.println(pj.getCdAssunto()+ " - "+pj.getDescricao());
			}
			
			PrintWriter out = response.getWriter();
	        out.println("Assunto : "+sb.toString());
		} catch (Exception e) {
			response.getWriter().append("Usuario não encontrado!").close();
		}
		
	}*/
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	//http://localhost:8080/ProjTes/TestServlet?cdproc=2023
		try {
			// PJE1G = 2023
			// PJE2G = 1234
			List<ProcessoBancoTO> PJE = new ArrayList<>();
			
			Integer cdproc = Integer.valueOf(request.getParameter("cdproc"));
			if(PJE == null || PJE.isEmpty()) {
				PJE = ProcessoDAO.getInstance().buscaProcesso("PJE1G", cdproc);
			}
			if(PJE == null || PJE.isEmpty()){				
				System.out.println("Estava no PJE2G");
				PJE = ProcessoDAO.getInstance().buscaProcesso("PJE2G", cdproc);
			}
			
			System.out.println("PJE1G");
			StringBuilder sb = new StringBuilder();
			for(ProcessoBancoTO proc: PJE) {
				sb.append(proc.getCdAgrupSitPro()+proc.getSistema().getDescricao()+"\n");
				System.out.println(proc.getCdAgrupSitPro()+proc.getSistema().getDescricao());
			}
			
			PrintWriter out = response.getWriter();
	        out.println("Assunto : "+sb.toString());
		} catch (Exception e) {
			response.getWriter().append("Usuario não encontrado!").close();
		}
		
	}

}
