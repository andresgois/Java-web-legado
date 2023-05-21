package andresgois.github.io.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import andresgois.github.io.to.ProcessoBancoTO;

public class ProcessoDAO {

	private static ProcessoDAO INSTANCE;
	private EntityManager em;
	
	private ProcessoDAO() {
		super();
	}
	
	public static ProcessoDAO getInstance() {
        if (INSTANCE == null) {
        	INSTANCE = new ProcessoDAO();
        }
        return INSTANCE;
    }
	
	@SuppressWarnings("unchecked")
    public List<ProcessoBancoTO> listProcesso(String conexao){
        List<ProcessoBancoTO> listProcesso = new ArrayList<>();
        StringBuilder hql = new StringBuilder();
        hql.append("select obj from ProcessoTO obj");
        
        em = EntityManagerFactoryGeneric.get(conexao).createEntityManager();
        Query query = em.createQuery(hql.toString());
        listProcesso = query.getResultList();
        em.close();
        
        return listProcesso;
    }
	
	@SuppressWarnings("unchecked")
    public List<ProcessoBancoTO> buscaProcesso(String conexao, Integer cdProc){
        List<ProcessoBancoTO> listProcesso = new ArrayList<>();
        StringBuilder hql = new StringBuilder();
        hql.append("select obj from ProcessoTO obj where obj.cdProc = :cdProc");
        
        em = EntityManagerFactoryGeneric.get(conexao).createEntityManager();
        System.out.println("=============== "+conexao);
        Query query = em.createQuery(hql.toString());
        query.setParameter("cdProc", cdProc);
        
        em.close();
        try {
        	listProcesso = query.getResultList();
        	//List<andresgois.github.io.bnj.ProcessoTO> processoTOBNJ = andresgois.github.io.bnj.ProcessoTO.create(listProcesso);
		} catch (Exception e) {
			return null;
		}        
        return listProcesso;
    }
	
	@SuppressWarnings("unchecked")
    public List<ProcessoBancoTO> buscaProcessoPJE1G(Integer cdProc){
        List<ProcessoBancoTO> listProcesso = new ArrayList<>();
        StringBuilder hql = new StringBuilder();
        hql.append("select obj from ProcessoTO obj where obj.cdProc = :cdProc");
        
        em = EntityManagerFactoryPJE1G.get().createEntityManager();
        Query query = em.createQuery(hql.toString());
        query.setParameter("cdProc", cdProc);
        
        em.close();
        try {
        	listProcesso = query.getResultList();
        	//List<andresgois.github.io.bnj.ProcessoTO> processoTOBNJ = andresgois.github.io.bnj.ProcessoTO.create(listProcesso);
		} catch (Exception e) {
			return null;
		}        
        return listProcesso;
    }
	
	@SuppressWarnings("unchecked")
    public List<ProcessoBancoTO> buscaProcessoPJE2G(Integer cdProc){
        List<ProcessoBancoTO> listProcesso = new ArrayList<>();
        StringBuilder hql = new StringBuilder();
        hql.append("select obj from ProcessoTO obj where obj.cdProc = :cdProc");
        
        em = EntityManagerFactoryPJE2G.get().createEntityManager();
        Query query = em.createQuery(hql.toString());
        query.setParameter("cdProc", cdProc);
        
        em.close();
        try {
        	listProcesso = query.getResultList();
        	//List<andresgois.github.io.bnj.ProcessoTO> processoTOBNJ = andresgois.github.io.bnj.ProcessoTO.create(listProcesso);
		} catch (Exception e) {
			return null;
		}        
        return listProcesso;
    }

}
