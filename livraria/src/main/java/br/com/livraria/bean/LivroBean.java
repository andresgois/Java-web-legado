package br.com.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.facelets.FaceletContext;
import javax.validation.ValidationException;

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
    
    public List<Livro> getLivros(){
        List<Livro> livros = new DAO<Livro>(Livro.class).listaTodos();
        return livros;
    }
    
    public List<Autor> getAutoresDoLivro(){
        return this.livro.getAutores();
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
            //throw new RuntimeException("Livro deve ter pelo menos um autor.");
            FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um autor."));
        }
        
        new DAO<Livro>(Livro.class).adiciona(this.livro);
        // aqui criamos um novo livro vazio pra limpar os campos e o id
        this.livro = new Livro(); 
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }
    
    public void comecaComDigitoUm(FacesContext fc, UIComponent comp,  Object v) throws ValidatorException {
        String valor = v.toString();
        if(!valor.startsWith("1")){
            throw new ValidatorException(new FacesMessage("Deveria começar com um"));
        }
    }
    
}
