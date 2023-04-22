package br.com.livraria.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.json.JsonObject;

import org.jboss.logging.Logger;
import org.primefaces.context.RequestContext;

import br.com.livraria.business.IndicadoresBusiness;
import br.com.livraria.modelo.vo.Indicador;
import br.com.livraria.modelo.vo.IndicadoresResult;
import br.com.livraria.util.enums.TussEnum;

@ManagedBean
@SessionScoped
public class AtendimentoBean {
    
    private ArrayList<Indicador> listaIndicadores;
    private ArrayList<Indicador> listIndicadores;
    private JsonObject IndicadoresList;
    private ArrayList<IndicadoresResult> indi;
    
    private String dtInicial;
    private String dtFinal;
    private final Logger LOGGER = Logger.getLogger(getClass().getName());
    
    /*@Inject
    IndicadoresBusiness atendimentoBusiness;*/
    
    @PostConstruct
    public void inicializar() throws Exception {
        this.listaIndicadores = new ArrayList<Indicador>();
    }
    
    public ArrayList<Indicador>  carregaListaIndicadores() {
        ArrayList<Indicador> indicador = new ArrayList<Indicador>();        
        List<TussEnum> list = Arrays.asList(TussEnum.values());
        
        for(int i=0; i<list.size(); i++) {
            indicador.add(new Indicador(i+1,list.get(i).toString(), list.get(i).getDescricaoTuss()));
        }
        setListIndicadores(indicador);
        return indicador;
    }
    
    //
    public void atualizaIndicadores() throws Exception {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        ArrayList<String> codes = new ArrayList<>();  
        String dtInicio = params.get("formFiltro:dtInicial");
        String dtFim = params.get("formFiltro:dtFinal");
        if(params.get("indicadoresSelecionados") != null) {
            String[] tuss = params.get("indicadoresSelecionados").split(",");
            try {
                this.getDadosIndicadores(tuss, dtInicio, dtFim);
                RequestContext.getCurrentInstance().update(":grafico");
                System.out.println("Atualizou");
            } catch (Exception e) {
                throw new Exception("NAO_FOI_POSSIVEL_ATUALIZAR_OS_INDICADORES_SELECIONADOS_DO_PACIENTE");
            }
        }
    }
    
    public void limpar() {
        this.indi.clear();
    }
    
    // Tamanho da lista
    public int getListaSize(List<IndicadoresResult> lista) {
        if (lista == null) {
            return 0;
        } else {
            return lista.size();
        }
    }
    
    // DADOS INDICADORES
    public void getDadosIndicadores(String[] tuss, String dtInicio, String dtFim) {
        Date dateI = null, dateF = null;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        List<TussEnum> tussenum = new ArrayList<TussEnum>();
        for (String t : tuss) {
            TussEnum tc = TussEnum.valueOf (t);
            System.out.println (tc);
            tussenum.add(tc);
        }
        
        try {
            dateI = (Date) formatter.parse(dtInicio);
            dateF = (Date) formatter.parse(dtFim);
            IndicadoresBusiness ib = new IndicadoresBusiness();
            IndicadoresList = ib.getDadosIndicadores(dateI, dateF,tussenum);
            setListaIndicadores(listaIndicadores);
            indi = new ArrayList<>();
            int t = IndicadoresList.getJsonObject("Retorno").getJsonArray("Resultados").size();
            for (int i=0; i<t;i++) {
                Integer id = i+1;
                String descricao = IndicadoresList.getJsonObject("Retorno").getJsonArray("Resultados").getJsonObject(i).getString("DescricaoTUSS");
                Integer codigoTuss = IndicadoresList.getJsonObject("Retorno").getJsonArray("Resultados").getJsonObject(i).getInt("CodigoTUSS");
                String valor = IndicadoresList.getJsonObject("Retorno").getJsonArray("Resultados").getJsonObject(i).getString("Valor");
                String data = IndicadoresList.getJsonObject("Retorno").getJsonArray("Resultados").getJsonObject(i).getString("DataExame");
                Double v = Double.valueOf(valor.replaceAll(",", "."));
                indi.add(new IndicadoresResult(id, descricao, codigoTuss, v, data));
            }            
        } catch (Exception e) {
            LOGGER.error("========================");
            System.out.println(e);
            LOGGER.error("========================");
            if (e.getMessage().equals("DATA INVALIDA")) {
                this.addMessageInFacesContext(FacesMessage.SEVERITY_ERROR,"DATA_INVALIDA", "");
            } else {
                LOGGER.error("NAO_FOI_POSSIVEL_CARREGAR_OS_DADOS_INDICADORES_DO_PACIENTE " + e.getMessage());
                this.addMessageInFacesContext(FacesMessage.SEVERITY_ERROR,"NAO_FOI_POSSIVEL_CARREGAR_OS_DADOS_INDICADORES_DO_PACIENTE", "");
            }
        }
    }
    
    // MENSAGEM DE ERRO
    @SuppressWarnings("unused")
    private void addMessageInFacesContext(Severity severity, String mensagem, String mensagemDetalhada) {
        FacesContext.getCurrentInstance().addMessage("Message!",
                new FacesMessage(severity, mensagem, mensagemDetalhada));
    }

    
    // GETTER AND SETTER
    public ArrayList<Indicador> getListaIndicadores() {
        return listaIndicadores;
    }

    public void setListaIndicadores(ArrayList<Indicador> listaIndicadores) {
        this.listaIndicadores = listaIndicadores;
    }

    public ArrayList<Indicador> getListIndicadores() {
        return listIndicadores;
    }

    public void setListIndicadores(ArrayList<Indicador> listIndicadores) {
        this.listIndicadores = listIndicadores;
    }

    public JsonObject getIndicadoresList() {
        return IndicadoresList;
    }

    public void setIndicadoresList(JsonObject indicadoresList) {
        IndicadoresList = indicadoresList;
    }

    public String getDtInicial() {
        return dtInicial;
    }

    public void setDtInicial(String dtInicial) {
        this.dtInicial = dtInicial;
    }

    public String getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(String dtFinal) {
        this.dtFinal = dtFinal;
    }

    public ArrayList<IndicadoresResult> getIndi() {
        return indi;
        
    }

    public void setIndi(ArrayList<IndicadoresResult> indi) {
        this.indi = indi;
        
    }
    
    
}
