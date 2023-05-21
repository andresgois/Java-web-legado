package andresgois.github.io.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import andresgois.github.io.to.AssuntoTO;

public class AssuntoDAO {

	private static AssuntoDAO INSTANCE;
	private EntityManager em;
	
	private AssuntoDAO() {
		super();
	}
	
	public static AssuntoDAO getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new AssuntoDAO();
        }
        return INSTANCE;
    }
	
	@SuppressWarnings("unchecked")
    public List<AssuntoTO> listAssuntos(String conexao){
        List<AssuntoTO> listAssuntos = new ArrayList<>();
        StringBuilder hql = new StringBuilder();
        hql.append("select obj from AssuntoTO obj");
        
        em = EntityManagerFactoryGeneric.get(conexao).createEntityManager();
        Query query = em.createQuery(hql.toString());
        listAssuntos = query.getResultList();
        em.close();
        
        return listAssuntos;
    }
}
