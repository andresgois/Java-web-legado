package andresgois.github.io.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryMysqlSingleton {

	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("ProjTes");

	private EntityManagerFactoryMysqlSingleton() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
