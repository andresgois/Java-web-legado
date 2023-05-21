package andresgois.github.io.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryPJE1G {

	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("WS_BANESTES_PJE1G");

	private EntityManagerFactoryPJE1G() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
