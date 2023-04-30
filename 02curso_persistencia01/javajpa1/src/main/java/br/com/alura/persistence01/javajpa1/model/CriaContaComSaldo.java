package br.com.alura.persistence01.javajpa1.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaContaComSaldo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        
        Conta c = new Conta();
        c.setTitular("Leonardo");
        c.setNumero(123455);
        c.setAgencia(4321);
        c.setSaldo(500.0);
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
}
