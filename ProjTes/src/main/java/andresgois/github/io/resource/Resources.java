package andresgois.github.io.resource;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

public class Resources {

	@Produces
    @PersistenceContext(unitName = "ProjTes")
    private EntityManager emPrimary;

    @Produces
    @PersistenceContext(unitName = "PostgresDS")
    private EntityManager emSecondary;

    @Produces
    @Resource(lookup = "java:jboss/datasources/MysqlDS")
    private DataSource dsPrimary;

    @Produces
    @Resource(lookup = "jdbc:postgresql://localhost:5432/banco_postgresql")
    private DataSource dsSecodnary;
}
