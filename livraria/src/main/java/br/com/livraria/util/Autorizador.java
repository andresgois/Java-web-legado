package br.com.livraria.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.livraria.modelo.Usuario;

public class Autorizador implements PhaseListener{

    private static final long serialVersionUID = 1L;

    @Override
    public void afterPhase(PhaseEvent ev) {
        FacesContext context = ev.getFacesContext();
        String nomePagina = context.getViewRoot().getViewId();
        System.out.println(nomePagina);
        
        if("/login.xhtml".equals(nomePagina)) return;
        
        Usuario usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
        if(usuarioLogado != null) return;
        
        NavigationHandler handle = context.getApplication().getNavigationHandler();
        handle.handleNavigation(context, null, "/login?faces-redirect=true");
        context.renderResponse();        
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("FASE: "+event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
