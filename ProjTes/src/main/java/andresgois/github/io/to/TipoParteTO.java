package andresgois.github.io.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "TipoParteTO")
@Table(name = "tb_tipo_partes")
public class TipoParteTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cd_sistema")
	private Integer cdSistema;
	
	@Column(name = "cd_tipo_classe")
	private String cdTipoClasse;
	
	@Column(name = "descricao")
    private String descricao;
	
	@Column(name = "tipo_parte")
    private String tipoParte;

	public TipoParteTO() {}
	
	public TipoParteTO(Integer id, Integer cdSistema, String cdTipoClasse, String descricao, String tipoParte) {
		super();
		this.id = id;
		this.cdSistema = cdSistema;
		this.cdTipoClasse = cdTipoClasse;
		this.descricao = descricao;
		this.tipoParte = tipoParte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCdSistema() {
		return cdSistema;
	}

	public void setCdSistema(Integer cdSistema) {
		this.cdSistema = cdSistema;
	}

	public String getCdTipoClasse() {
		return cdTipoClasse;
	}

	public void setCdTipoClasse(String cdTipoClasse) {
		this.cdTipoClasse = cdTipoClasse;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoParte() {
		return tipoParte;
	}

	public void setTipoParte(String tipoParte) {
		this.tipoParte = tipoParte;
	}
	
}
