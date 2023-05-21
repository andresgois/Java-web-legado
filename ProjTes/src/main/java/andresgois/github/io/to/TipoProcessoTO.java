package andresgois.github.io.to;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "TipoProcessoTO")
@Table(name = "tb_tipo_processo")
public class TipoProcessoTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_tipo_processo")
	private Integer cdTipoProcesso;
	
	@Column(name = "cd_instancia")
	private Integer cdInstancia;
	
	@Column(name = "no_ordem")
	private Integer noOrdem;
	
	@Column(name = "tipo_processo")
	private String tipoProcesso;
	
	@Column(name = "id_ativo")
	private String idAtivo;

	public TipoProcessoTO() {}
	
	public TipoProcessoTO(Integer cdTipoProcesso, Integer cdInstancia, Integer noOrdem, String tipoProcesso,
			String idAtivo) {
		super();
		this.cdTipoProcesso = cdTipoProcesso;
		this.cdInstancia = cdInstancia;
		this.noOrdem = noOrdem;
		this.tipoProcesso = tipoProcesso;
		this.idAtivo = idAtivo;
	}

	public Integer getCdTipoProcesso() {
		return cdTipoProcesso;
	}

	public void setCdTipoProcesso(Integer cdTipoProcesso) {
		this.cdTipoProcesso = cdTipoProcesso;
	}

	public Integer getCdInstancia() {
		return cdInstancia;
	}

	public void setCdInstancia(Integer cdInstancia) {
		this.cdInstancia = cdInstancia;
	}

	public Integer getNoOrdem() {
		return noOrdem;
	}

	public void setNoOrdem(Integer noOrdem) {
		this.noOrdem = noOrdem;
	}

	public String getTipoProcesso() {
		return tipoProcesso;
	}

	public void setTipoProcesso(String tipoProcesso) {
		this.tipoProcesso = tipoProcesso;
	}

	public String getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(String idAtivo) {
		this.idAtivo = idAtivo;
	}
	
}
