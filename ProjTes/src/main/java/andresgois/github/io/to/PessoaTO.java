package andresgois.github.io.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "PessoaTO")
@Table(name = "tb_pessoa")
public class PessoaTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cd_sistema")
	private Integer cdSistema;
	
	@Column(name = "nome")
    private String nome;
	
	@Column(name = "nome_abreviado")
    private String nomeAbreviado;

    public PessoaTO() {}
    
	public PessoaTO(Integer cdSistema, Integer id, String nome, String nomeAbreviado) {
		super();
		this.cdSistema = cdSistema;
		this.id = id;
		this.nome = nome;
		this.nomeAbreviado = nomeAbreviado;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}
    
}
