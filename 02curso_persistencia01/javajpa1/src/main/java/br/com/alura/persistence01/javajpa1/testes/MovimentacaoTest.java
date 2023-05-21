package br.com.alura.persistence01.javajpa1.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.persistence01.javajpa1.enums.TipoMovimentacao;
import br.com.alura.persistence01.javajpa1.model.Conta;
import br.com.alura.persistence01.javajpa1.model.Movimentacao;

public class MovimentacaoTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta c = new Conta();
		c.setAgencia(1485);
		c.setNumero(105969);
		c.setTitular("André Gois");
		c.setSaldo(1000.0);
		
		Movimentacao mov = new Movimentacao();
		mov.setDescricao("Churrascaria");
		mov.setData(LocalDateTime.now());
		mov.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		mov.setValor(new BigDecimal(200.0));
		mov.setConta(c);
		
		em.getTransaction().begin();
		em.persist(c);
		em.persist(mov);
		em.getTransaction().commit();

	}

}
