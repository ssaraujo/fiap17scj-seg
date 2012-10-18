package br.com.fiap.segurancafiap.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_funcionario database table.
 * 
 */
@Entity
@Table(name="tb_funcionario")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int chapa;
	private String cargo;
	private String chavePrivada;
	private String chavePublica;
	private Boolean desligamento;
	private Date dataAdmissao;
	private Date dataNascimento;
	private Date dataPromocao;
	private String nome;
	private String senha;
	private String sobrenome;
	private String usuario;
	private List<Arquivo> arquivos;

    public Funcionario() {
    }


	@Id
	@Column(unique=true, nullable=false)
	public int getChapa() {
		return this.chapa;
	}

	public void setChapa(int chapa) {
		this.chapa = chapa;
	}


	@Column(length=40)
	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	@Column(name="chave_privada", length=256)
	public String getChavePrivada() {
		return this.chavePrivada;
	}

	public void setChavePrivada(String chavePrivada) {
		this.chavePrivada = chavePrivada;
	}


	@Column(name="chave_publica", length=256)
	public String getChavePublica() {
		return this.chavePublica;
	}

	public void setChavePublica(String chavePublica) {
		this.chavePublica = chavePublica;
	}


	public Boolean getDesligamento() {
		return this.desligamento;
	}

	public void setDesligamento(Boolean desligamento) {
		this.desligamento = desligamento;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="dt_admissao")
	public Date getDataAdmissao() {
		return this.dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="dt_nascimento")
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="dt_promocao")
	public Date getDataPromocao() {
		return this.dataPromocao;
	}

	public void setDataPromocao(Date dataPromocao) {
		this.dataPromocao = dataPromocao;
	}


	@Column(length=20)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@Column(length=45)
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Column(length=20)
	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	@Column(length=8)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to Arquivo
	@OneToMany(mappedBy="funcionario")
	public List<Arquivo> getArquivos() {
		return this.arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}
	
}