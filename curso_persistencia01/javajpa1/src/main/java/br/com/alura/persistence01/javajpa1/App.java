package br.com.alura.persistence01.javajpa1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager createEntityManager = emf.createEntityManager();
        emf.close();
    }
}
