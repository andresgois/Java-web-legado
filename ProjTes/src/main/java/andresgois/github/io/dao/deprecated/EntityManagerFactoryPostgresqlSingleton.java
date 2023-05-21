package andresgois.github.io.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryPostgresqlSingleton {

	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("PostgresDS");

	private EntityManagerFactoryPostgresqlSingleton() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
