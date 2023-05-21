package andresgois.github.io.dao.deprecated;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import andresgois.github.io.todeprecated.UsuarioTO;

public class UsuarioPostgresqlDAO {
    
    private static UsuarioPostgresqlDAO instance;
    
    private EntityManager em;
    
    public UsuarioPostgresqlDAO() {
        super();
    }
    
    public static UsuarioPostgresqlDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioPostgresqlDAO();
        }
        return instance;
    }
    
    @SuppressWarnings("unchecked")
    public List<UsuarioTO> listAllUsers(){
        List<UsuarioTO> listUsers = new ArrayList<>();
        StringBuilder hql = new StringBuilder();
        hql.append("select obj from UsuarioTO obj");
        
        
        em = EntityManagerFactoryPostgresqlSingleton.get().createEntityManager();
        Query query = em.createQuery(hql.toString());
        listUsers = query.getResultList();
        em.close();
        
        return listUsers;
    }
    
    public UsuarioTO userPorMatricula(String matricula) throws Exception{
        StringBuilder hql = new StringBuilder();
        hql.append("select obj from UsuarioTO obj where obj.matricula = :matricula");
        
        em = EntityManagerFactoryPostgresqlSingleton.get().createEntityManager();
        Query query = em.createQuery(hql.toString());
        query.setParameter("matricula", matricula);
        
        UsuarioTO user;
		try {
			user = (UsuarioTO) query.getSingleResult();
		} catch (Exception e) {
			return null;
		} finally {			
			em.close();
		}
        
        return user;
    }

}
