package andresgois.github.io.dao.deprecated;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import andresgois.github.io.todeprecated.UsuarioTO;

public class UsuarioMysqlDAO {
    
    private static UsuarioMysqlDAO instance;
    
    //@PersistenceContext(unitName="PostgresDS")
    private EntityManager em;
    
    public UsuarioMysqlDAO() {
        super();
    }
    
    public static UsuarioMysqlDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioMysqlDAO();
        }
        return instance;
    }
    
    @SuppressWarnings("unchecked")
    public List<UsuarioTO> listAllUsers(){
        List<UsuarioTO> listUsers = new ArrayList<>();
        StringBuilder hql = new StringBuilder();
        hql.append("select obj from UsuarioTO obj");

        em = EntityManagerFactoryMysqlSingleton.get().createEntityManager();
        Query query = em.createQuery(hql.toString());
        listUsers = query.getResultList();
        em.close();
        
        return listUsers;
    }
    
    public UsuarioTO userPorMatricula(String matricula) throws Exception{
        StringBuilder hql = new StringBuilder();
        hql.append("select obj from UsuarioTO obj where obj.matricula = :matricula");
        
        em = EntityManagerFactoryMysqlSingleton.get().createEntityManager();
        Query query = em.createQuery(hql.toString());
        query.setParameter("matricula", matricula);
        
        UsuarioTO user;
		try {
			user = (UsuarioTO) query.getSingleResult();
		} catch (Exception e) {
			return null;
			//throw new Exception(e.getMessage());
		} finally {			
			em.close();
		}
        
        return user;
    }

}
