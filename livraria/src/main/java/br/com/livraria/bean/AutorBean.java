package br.com.livraria.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.livraria.dao.DAO;
import br.com.livraria.modelo.Autor;

@ManagedBean
@ViewScoped
public class AutorBean {
    
    private Autor autor = new Autor();
    private Integer autorId;
    
    public void carregarAutorPelaId() {
       this.autor = new DAO<Autor>(Autor.class).buscaPorId(autorId); 
    }
    
    public Autor getAutor() {
        return autor;
    }
    
    public List<Autor> getAutores(){
        return new DAO<Autor>(Autor.class).listaTodos();
    }
    
    public String gravar() {
        System.out.println("Gravando: " + this.autor.getNome());
        System.out.println(autor);
        
        if( this.autor.getId() == null) {
            new DAO<Autor>(Autor.class).adiciona(this.autor);
        } else {
            new DAO<Autor>(Autor.class).atualiza(this.autor);
        }
        
        this.autor = new Autor();
        return ""; //"livro?faces-redirect=true";
    }
    
    public void alterar(Autor aut) {
        System.out.println(aut);
        this.autor = aut;
    }
    
    public void remover(Autor aut) {
        new DAO<Autor>(Autor.class).remove(aut);
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    
}