package andresgois.github.io.to;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "AssuntoProcessoTO")
@Table(name = "tb_assunto_processo")
public class AssuntoProcessoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_assunto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAssunto;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_assunto", referencedColumnName = "cd_assunto")
	private AssuntoTO cdAssunto;
	
	/*@ManyToOne
	@JoinColumn(name = "cd_processo", referencedColumnName = "cd_proc")
	private ProcessoTO processo;*/
	
	@Column(name = "cd_recurso")
	private Integer cdRecurso;
	
	@Column(name = "cd_sistema")
	private Integer cdSistema;
	
	@Column(name = "id_ativo")
	private String idAtivo;
	
	@Column(name = "id_sequencia_assunto")
	private Integer idSequenciaAssunto;
	
	public AssuntoProcessoTO() {}

	public AssuntoProcessoTO(Integer idAssunto, AssuntoTO cdAssunto, ProcessoBancoTO processo, Integer cdRecurso,
			Integer cdSistema, String idAtivo, Integer idSequenciaAssunto) {
		super();
		this.idAssunto = idAssunto;
		this.cdAssunto = cdAssunto;
		this.cdRecurso = cdRecurso;
		this.cdSistema = cdSistema;
		this.idAtivo = idAtivo;
		this.idSequenciaAssunto = idSequenciaAssunto;
	}

	public Integer getIdAssunto() {
		return idAssunto;
	}

	public void setIdAssunto(Integer idAssunto) {
		this.idAssunto = idAssunto;
	}

	public AssuntoTO getCdAssunto() {
		return cdAssunto;
	}

	public void setCdAssunto(AssuntoTO cdAssunto) {
		this.cdAssunto = cdAssunto;
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

	public String getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(String idAtivo) {
		this.idAtivo = idAtivo;
	}

	public Integer getIdSequenciaAssunto() {
		return idSequenciaAssunto;
	}

	public void setIdSequenciaAssunto(Integer idSequenciaAssunto) {
		this.idSequenciaAssunto = idSequenciaAssunto;
	}

	

}
