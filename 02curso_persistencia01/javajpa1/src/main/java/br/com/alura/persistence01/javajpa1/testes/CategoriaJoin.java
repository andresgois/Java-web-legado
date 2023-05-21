package br.com.alura.persistence01.javajpa1.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.persistence01.javajpa1.model.Categoria;
import br.com.alura.persistence01.javajpa1.model.Movimentacao;

public class CategoriaJoin {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Categoria categoria = new Categoria();
		categoria.setId(1L);
		
		String JPQL = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		//Query query = em.createQuery(JPQL); // apararece um warning no getResultList
		TypedQuery<Movimentacao> query = em.createQuery(JPQL, Movimentacao.class);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> lista = query.getResultList();
		
		for (Movimentacao movimentacao : lista) {
			System.out.println(movimentacao.getDescricao()+ 
					" - "+movimentacao.getTipoMovimentacao()+
					" - "+movimentacao.getCategorias());
			
		}
	}
}
