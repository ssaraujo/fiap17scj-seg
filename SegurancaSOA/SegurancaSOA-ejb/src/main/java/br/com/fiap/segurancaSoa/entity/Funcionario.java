package br.com.fiap.segurancaSoa.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Funcionario
 *
 */
@Entity

public class Funcionario implements Serializable {

	
	private int codFuncionario;
	private String nome;
	private String sobreNome;
	private String cargo;
	private boolean desligado;
	private Date dataNascimento;
	private Date dataAdmissao;
	private Date dataUltimaPromocao;
	private String usuario;
	private String senha;
	private String chavePublica;
	private static final long serialVersionUID = 1L;

	public Funcionario() {
		super();
	}   
	@Id    
	public int getCodFuncionario() {
		return this.codFuncionario;
	}

	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getSobreNome() {
		return this.sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}   
	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}   
	public boolean getDesligado() {
		return this.desligado;
	}

	public void setDesligado(boolean desligado) {
		this.desligado = desligado;
	}   
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}   
	public Date getDataAdmissao() {
		return this.dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}   
	public Date getDataUltimaPromocao() {
		return this.dataUltimaPromocao;
	}

	public void setDataUltimaPromocao(Date dataUltimaPromocao) {
		this.dataUltimaPromocao = dataUltimaPromocao;
	}   
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}   
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}   
	public String getChavePublica() {
		return this.chavePublica;
	}

	public void setChavePublica(String chavePublica) {
		this.chavePublica = chavePublica;
	}
   
}
