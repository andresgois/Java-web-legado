package br.com.alura.persistence01.javajpa1.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.persistence01.javajpa1.enums.TipoMovimentacao;
import br.com.alura.persistence01.javajpa1.model.Categoria;
import br.com.alura.persistence01.javajpa1.model.Conta;
import br.com.alura.persistence01.javajpa1.model.Movimentacao;

public class MovimentacaoCategoriaTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Categoria c1 = new Categoria("Viagem");
		Categoria c2 = new Categoria("Alimentação");
		
		Conta c = em.find(Conta.class, 1L);
		
		Movimentacao mov = new Movimentacao();
		mov.setDescricao("Vaigem ao Rio de Janeiro");
		mov.setData(LocalDateTime.now());
		mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov.setValor(new BigDecimal(525.0));
		mov.setCategorias(Arrays.asList(c1, c2));
		mov.setConta(c);
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c);
		em.persist(mov);
		em.getTransaction().commit();
	}

}
