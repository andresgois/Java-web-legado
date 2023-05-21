package andresgois.github.io.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryPJE2G {

	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("WS_BANESTES_PJE2G");

	private EntityManagerFactoryPJE2G() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
