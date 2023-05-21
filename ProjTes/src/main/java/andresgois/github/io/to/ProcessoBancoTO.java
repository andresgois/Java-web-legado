package andresgois.github.io.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "ProcessoTO")
@Table(name = "tb_processo")
public class ProcessoBancoTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_agrup_sit_pro")
    private Integer cdAgrupSitPro;
	
	@Column(name = "cd_orgao")
	private Integer cdOrgao;
	
	@Column(name = "cd_orgao_atual")
	private Integer cdOrgaoAtual;

	@Column(name = "cd_proc")
    private Integer cdProc;

	@Column(name = "class_proc")
    private String classProc;

	@Column(name = "dt_juiz")
    private Date dtAjuiz;

	@Column(name = "dt_distrib")
    private Date dtDistrib;

	@Column(name = "escaninho_atual_proc")
    private String escaninhoAtualProc;
	
	@Column(name = "id_dispensa_legal")
    private String idDispensaLegal;
	
	@Column(name = "id_justica_gratuita")
    private String idJusticaGratuita;
	
	@Column(name = "id_recurso")
    private Integer idRecurso;
	
	@Column(name = "id_segredo_justica")
    private String idSegredoJustica;
	
	
	//@OneToMany(mappedBy = "processo", targetEntity = ParteTO.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OneToMany
	@JoinColumn(name = "cd_processo", referencedColumnName = "cd_proc")
    private List<AssuntoProcessoTO> listaAssuntoProcesso  = new ArrayList<>();

	//@OneToMany(targetEntity = ParteTO.class) //(mappedBy = "processo",fetch = FetchType.LAZY, cascade = CascadeType.ALL)//, targetEntity = AssuntoProcessoTO.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OneToMany
	@JoinColumn(name = "cd_processo", referencedColumnName = "cd_proc")
    private List<ParteTO> listaPartes  = new ArrayList<>();
    
    @Column(name = "motiv_dist")
    private String motivDist;
    
    @Column(name = "natur_proc")
    private String naturProc;

    @Column(name = "nr_proc")
    private String nrProc;

    @Column(name = "nr_proc_antigo")
    private String nrProcAntigo;

    @Column(name = "org_proc")
    private String nrProcOrig;

    @Column(name = "petic_ini")
    private String peticIni;

    @Column(name = "sit_proc")
    private String sitProc;
    
    @Column(name = "tipo_proc")
    private String tipoProc;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sistema", referencedColumnName = "cd_sistema")
    private SistemaTO sistema;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_processo", referencedColumnName = "cd_tipo_processo")
    private TipoProcessoTO tipoProcesso;

    //private TipoProcessoTO tipoProcesso;

    @Column(name = "vl_causa")
    private BigDecimal valorCausa;
    
    public ProcessoBancoTO() { }

	public ProcessoBancoTO(Integer cdAgrupSitPro, Integer cdOrgao, Integer cdOrgaoAtual, Integer cdProc, String classProc,
			Date dtAjuiz, Date dtDistrib, String escaninhoAtualProc, String idDispensaLegal, String idJusticaGratuita,
			Integer idRecurso, String idSegredoJustica, String idSistema, List<AssuntoProcessoTO> listaAssuntoProcesso,
			List<ParteTO> listaPartes, String motivDist, String naturProc, String nrProc, String nrProcAntigo,
			String nrProcOrig, String peticIni, String sitProc, String tipoProc, SistemaTO sistema,
			BigDecimal valorCausa) {
		super();
		this.cdAgrupSitPro = cdAgrupSitPro;
		this.cdOrgao = cdOrgao;
		this.cdOrgaoAtual = cdOrgaoAtual;
		this.cdProc = cdProc;
		this.classProc = classProc;
		this.dtAjuiz = dtAjuiz;
		this.dtDistrib = dtDistrib;
		this.escaninhoAtualProc = escaninhoAtualProc;
		this.idDispensaLegal = idDispensaLegal;
		this.idJusticaGratuita = idJusticaGratuita;
		this.idRecurso = idRecurso;
		this.idSegredoJustica = idSegredoJustica;
		//this.idSistema = idSistema;
		this.listaAssuntoProcesso = listaAssuntoProcesso;
		this.listaPartes = listaPartes;
		this.motivDist = motivDist;
		this.naturProc = naturProc;
		this.nrProc = nrProc;
		this.nrProcAntigo = nrProcAntigo;
		this.nrProcOrig = nrProcOrig;
		this.peticIni = peticIni;
		this.sitProc = sitProc;
		this.tipoProc = tipoProc;
		this.sistema = sistema;
		this.valorCausa = valorCausa;
	}

	public Integer getCdAgrupSitPro() {
		return cdAgrupSitPro;
	}

	public void setCdAgrupSitPro(Integer cdAgrupSitPro) {
		this.cdAgrupSitPro = cdAgrupSitPro;
	}

	public Integer getCdOrgao() {
		return cdOrgao;
	}

	public void setCdOrgao(Integer cdOrgao) {
		this.cdOrgao = cdOrgao;
	}

	public Integer getCdOrgaoAtual() {
		return cdOrgaoAtual;
	}

	public void setCdOrgaoAtual(Integer cdOrgaoAtual) {
		this.cdOrgaoAtual = cdOrgaoAtual;
	}

	public Integer getCdProc() {
		return cdProc;
	}

	public void setCdProc(Integer cdProc) {
		this.cdProc = cdProc;
	}

	public String getClassProc() {
		return classProc;
	}

	public void setClassProc(String classProc) {
		this.classProc = classProc;
	}

	public Date getDtAjuiz() {
		return dtAjuiz;
	}

	public void setDtAjuiz(Date dtAjuiz) {
		this.dtAjuiz = dtAjuiz;
	}

	public Date getDtDistrib() {
		return dtDistrib;
	}

	public void setDtDistrib(Date dtDistrib) {
		this.dtDistrib = dtDistrib;
	}

	public String getEscaninhoAtualProc() {
		return escaninhoAtualProc;
	}

	public void setEscaninhoAtualProc(String escaninhoAtualProc) {
		this.escaninhoAtualProc = escaninhoAtualProc;
	}

	public String getIdDispensaLegal() {
		return idDispensaLegal;
	}

	public void setIdDispensaLegal(String idDispensaLegal) {
		this.idDispensaLegal = idDispensaLegal;
	}

	public String getIdJusticaGratuita() {
		return idJusticaGratuita;
	}

	public void setIdJusticaGratuita(String idJusticaGratuita) {
		this.idJusticaGratuita = idJusticaGratuita;
	}

	public Integer getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(Integer idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getIdSegredoJustica() {
		return idSegredoJustica;
	}

	public void setIdSegredoJustica(String idSegredoJustica) {
		this.idSegredoJustica = idSegredoJustica;
	}

	/*public String getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(String idSistema) {
		this.idSistema = idSistema;
	}*/

	public List<AssuntoProcessoTO> getListaAssuntoProcesso() {
		return listaAssuntoProcesso;
	}

	public void setListaAssuntoProcesso(List<AssuntoProcessoTO> listaAssuntoProcesso) {
		this.listaAssuntoProcesso = listaAssuntoProcesso;
	}

	public List<ParteTO> getListaPartes() {
		return listaPartes;
	}

	public void setListaPartes(List<ParteTO> listaPartes) {
		this.listaPartes = listaPartes;
	}

	public String getMotivDist() {
		return motivDist;
	}

	public void setMotivDist(String motivDist) {
		this.motivDist = motivDist;
	}

	public String getNaturProc() {
		return naturProc;
	}

	public void setNaturProc(String naturProc) {
		this.naturProc = naturProc;
	}

	public String getNrProc() {
		return nrProc;
	}

	public void setNrProc(String nrProc) {
		this.nrProc = nrProc;
	}

	public String getNrProcAntigo() {
		return nrProcAntigo;
	}

	public void setNrProcAntigo(String nrProcAntigo) {
		this.nrProcAntigo = nrProcAntigo;
	}

	public String getNrProcOrig() {
		return nrProcOrig;
	}

	public void setNrProcOrig(String nrProcOrig) {
		this.nrProcOrig = nrProcOrig;
	}

	public String getPeticIni() {
		return peticIni;
	}

	public void setPeticIni(String peticIni) {
		this.peticIni = peticIni;
	}

	public String getSitProc() {
		return sitProc;
	}

	public void setSitProc(String sitProc) {
		this.sitProc = sitProc;
	}

	public String getTipoProc() {
		return tipoProc;
	}

	public void setTipoProc(String tipoProc) {
		this.tipoProc = tipoProc;
	}

	public SistemaTO getSistema() {
		return sistema;
	}

	public void setSistema(SistemaTO sistema) {
		this.sistema = sistema;
	}

	public BigDecimal getValorCausa() {
		return valorCausa;
	}

	public void setValorCausa(BigDecimal valorCausa) {
		this.valorCausa = valorCausa;
	}

    
}
