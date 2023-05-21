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
        
        EntityManager em2 = emf.createEntityManager();
        Conta c = new Conta();
        c.setTitular("Priscila2");
        c.setNumero(456781);
        c.setAgencia(123);
        
        em2.getTransaction().begin();
        //em2.merge(c);
        em2.persist(c);
        System.out.println("ID: "+c.getId());
        em2.remove(c);
        em2.getTransaction().commit();
    }
}
