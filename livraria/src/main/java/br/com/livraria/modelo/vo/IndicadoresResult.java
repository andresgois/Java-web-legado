package br.com.livraria.modelo.vo;

public class IndicadoresResult {
   
    private Integer id;
    private String dataExame;
    private Double valor;
    private Integer codigoTUSS;
    private String descricaoTUSS;
    
    public IndicadoresResult() {}
    
    public IndicadoresResult(Integer id, String descricaoTUSS, Integer codigoTUSS, Double valor, String dataExame) {
        this.id = id;
        this.dataExame = dataExame;
        this.valor = valor;
        this.codigoTUSS = codigoTUSS;
        this.descricaoTUSS = descricaoTUSS;
    }

    public String getDataExame() {
        return dataExame;
    }

    public void setDataExame(String dataExame) {
        this.dataExame = dataExame;
    }


    public Integer getCodigoTUSS() {
        return codigoTUSS;
    }

    public void setCodigoTUSS(Integer codigoTUSS) {
        this.codigoTUSS = codigoTUSS;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricaoTUSS() {
        return descricaoTUSS;
    }

    public void setDescricaoTUSS(String descricaoTUSS) {
        this.descricaoTUSS = descricaoTUSS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
