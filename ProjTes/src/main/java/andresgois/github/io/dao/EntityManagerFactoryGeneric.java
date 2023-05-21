package andresgois.github.io.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryGeneric {

	//private static final EntityManagerFactory emfInstance1 = Persistence.createEntityManagerFactory("PostgresDS");
	private static final EntityManagerFactory emfInstance1 = Persistence.createEntityManagerFactory("WS_BANESTES_PJE1G");
	private static final EntityManagerFactory emfInstance2 = Persistence.createEntityManagerFactory("WS_BANESTES_PJE2G");

	private EntityManagerFactoryGeneric() {
	}

	public static EntityManagerFactory get(String emf) {
		if( emf.equals("PJE1G")) {
			return emfInstance1;
		} else {
			return emfInstance2;
		}
	}
}
