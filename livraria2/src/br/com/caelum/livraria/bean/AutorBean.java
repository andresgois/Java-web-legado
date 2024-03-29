package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Named
@RequestScoped
public class AutorBean {
	
	private Autor autor = new Autor();
	@Inject	// injeção de dependência
	private AutorDao dao; // = new AutorDao();
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() {
		this.dao.salva(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.dao.todosAutores();
	}
}
