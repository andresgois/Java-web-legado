package br.com.livraria.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.livraria.dao.UsuarioDAO;
import br.com.livraria.modelo.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean {
    
    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }
    
    public String efetuarLogin() {
        System.out.println("fazendo login do usuário: "+this.usuario.getEmail());
        FacesContext context = FacesContext.getCurrentInstance();
        
        boolean existe = new UsuarioDAO().existe(this.usuario);
        if(existe ) {
            context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
            return "livro?faces-redirect=true";
        }
        //context.addMessage("login:email", new FacesMessage("Usuário não encontrado"));
        // messagem existiram por 2 requisições
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null , new FacesMessage("Usuário não encontrado"));
        return "login?faces-redirect=true";
    }
    
    public String deslogar() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuarioLogado");
        return "login?faces-redirect=true"; 
    }
    
}