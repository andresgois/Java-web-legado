package br.com.alura.persistence01.javajpa1.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.persistence01.javajpa1.model.Cliente;
import br.com.alura.persistence01.javajpa1.model.Conta;

public class RelacaoClienteContaTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta c = new Conta();
		c.setId(2L);
		
		Cliente cli = new Cliente();
		cli.setNome("Lucas Mendes");
		cli.setProfissao("Gerente de Projeto");
		cli.setEndereco("Avenida João Pessoa");
		cli.setConta(c);
		
		em.getTransaction().begin();
		em.persist(cli);
		em.getTransaction().commit();
	}

}
