package br.com.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.livraria.dao.DAO;
import br.com.livraria.modelo.Autor;
import br.com.livraria.modelo.Livro;

@ManagedBean
@ViewScoped
public class LivroBean {
    
    private Livro livro = new Livro();
    private Integer autorId;
    
    public Livro getLivro() {
        return livro;
    }
    
    public List<Autor> getAutores(){
        List<Autor> autores = new DAO<Autor>(Autor.class).listaTodos();
        return autores;
    }
    
    public void gravarAutor() {
        System.out.println("AutorId = "+this.autorId);
        Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
        this.livro.adicionaAutor(autor);
        System.out.println("============== "+autor.getNome());
    }

    public void gravar() {
        System.out.println("Gravando: "+this.livro.getTitulo());
        
        if(livro.getAutores().isEmpty()) {
            throw new RuntimeException("Livro deve ter pelo menos um autor.");
        }
        
        new DAO<Livro>(Livro.class).adiciona(this.livro);
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }
    
}
