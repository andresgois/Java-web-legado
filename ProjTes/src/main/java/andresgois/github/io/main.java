package andresgois.github.io;

import java.util.List;

import andresgois.github.io.dao.AssuntoDAO;
import andresgois.github.io.to.AssuntoTO;

public class main {

	public static void main(String[] args) {
		
		List<AssuntoTO> PJE2G = AssuntoDAO.getInstance().listAssuntos("PJE2G");
		
		System.out.println("PJE1G");
		for(AssuntoTO pj: PJE2G) {
			System.out.println(pj.getCdAssunto()+ " - "+pj.getDescricao());
		}
	}

}
