package andresgois.github.io.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "AssuntoTO")
@Table(name = "tb_assunto")
public class AssuntoTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_assunto")
	private Long cdAssunto;
	
	@Column(name = "cd_sistema")
    private Integer cdSistema;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "id_ativo")
	private String idAtivo; // S

	public AssuntoTO() {}
	
	public AssuntoTO(Long cdAssunto, Integer cdSistema, String descricao, String idAtivo) {
		super();
		this.cdAssunto = cdAssunto;
		this.cdSistema = cdSistema;
		this.descricao = descricao;
		this.idAtivo = idAtivo;
	}

	public Long getCdAssunto() {
		return cdAssunto;
	}

	public void setCdAssunto(Long cdAssunto) {
		this.cdAssunto = cdAssunto;
	}

	public Integer getCdSistema() {
		return cdSistema;
	}

	public void setCdSistema(Integer cdSistema) {
		this.cdSistema = cdSistema;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(String idAtivo) {
		this.idAtivo = idAtivo;
	}
	
}
