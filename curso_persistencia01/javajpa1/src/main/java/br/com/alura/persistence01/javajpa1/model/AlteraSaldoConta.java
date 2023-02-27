package br.com.alura.persistence01.javajpa1.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraSaldoConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();
        
        Conta contaSemSaldo = em.find(Conta.class, 1L);
        
        em.getTransaction().begin();
        contaSemSaldo.setSaldo(20.0);
        em.getTransaction().commit();
    }
}
