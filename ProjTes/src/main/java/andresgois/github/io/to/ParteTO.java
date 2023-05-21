package andresgois.github.io.to;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "ParteTO")
@Table(name = "tb_partes")
public class ParteTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cd_classe_tipo_parte")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cdClasseTipoParte;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_tipo_parte", referencedColumnName = "id")
	private TipoParteTO cdTipoParte;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_pessoa", referencedColumnName = "id")
	private PessoaTO cdPessoa;
	
	//@JoinColumn(name = "cd_processo", referencedColumnName = "cd_proc")
	//private ProcessoTO processo;
	
	@Column(name = "cd_recurso")
	private Integer cdRecurso;
	
	@Column(name = "cd_sistema")
	private Integer cdSistema;
	
	@Column(name = "ds_pessoa")
	private String dsPessoa;
	
	@Column(name = "ds_tp_parte")
	private String dsTpParte;

    public ParteTO() {}

	public ParteTO(String cdClasseTipoParte, TipoParteTO cdTipoParte, PessoaTO cdPessoa, ProcessoBancoTO processo,
			Integer cdRecurso, Integer cdSistema, String dsPessoa, String dsTpParte) {
		super();
		this.cdClasseTipoParte = cdClasseTipoParte;
		this.cdTipoParte = cdTipoParte;
		this.cdPessoa = cdPessoa;
		this.cdRecurso = cdRecurso;
		this.cdSistema = cdSistema;
		this.dsPessoa = dsPessoa;
		this.dsTpParte = dsTpParte;
	}

	public String getCdClasseTipoParte() {
		return cdClasseTipoParte;
	}

	public void setCdClasseTipoParte(String cdClasseTipoParte) {
		this.cdClasseTipoParte = cdClasseTipoParte;
	}

	public TipoParteTO getCdTipoParte() {
		return cdTipoParte;
	}

	public void setCdTipoParte(TipoParteTO cdTipoParte) {
		this.cdTipoParte = cdTipoParte;
	}

	public PessoaTO getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(PessoaTO cdPessoa) {
		this.cdPessoa = cdPessoa;
	}

	public Integer getCdRecurso() {
		return cdRecurso;
	}

	public void setCdRecurso(Integer cdRecurso) {
		this.cdRecurso = cdRecurso;
	}

	public Integer getCdSistema() {
		return cdSistema;
	}

	public void setCdSistema(Integer cdSistema) {
		this.cdSistema = cdSistema;
	}

	public String getDsPessoa() {
		return dsPessoa;
	}

	public void setDsPessoa(String dsPessoa) {
		this.dsPessoa = dsPessoa;
	}

	public String getDsTpParte() {
		return dsTpParte;
	}

	public void setDsTpParte(String dsTpParte) {
		this.dsTpParte = dsTpParte;
	}

	

}
