package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;


@Stateless
public class AutorDao {

	@Inject
	private Banco banco; // EJB instânciará = new Banco();
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("Autor foi criado");
	}

	public void salva(Autor autor) {
		System.out.println("Salvando Autor "+autor.getNome());
		
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		
		banco.save(autor);
		System.out.println("Autor salvo com sucesso!!"+autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
