package br.com.alura.persistence01.javajpa1.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.persistence01.javajpa1.model.Conta;
import br.com.alura.persistence01.javajpa1.model.Movimentacao;

public class ConsultaJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(3L);
		
		String JPQL = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
		//Query query = em.createQuery(JPQL); // apararece um warning no getResultList
		TypedQuery<Movimentacao> query = em.createQuery(JPQL, Movimentacao.class);
		query.setParameter("pConta", conta);
		
		List<Movimentacao> lista = query.getResultList();
		
		for (Movimentacao movimentacao : lista) {
			System.out.println(movimentacao.getDescricao()+ " - "+movimentacao.getTipoMovimentacao());
			
		}
	}
}
