package br.com.fiap.segurancafiap.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_arquivo database table.
 * 
 */
@Entity
@Table(name="tb_arquivo")
public class Arquivo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codArquivo;
	private String conteudo;
	private Date dataUpload;
	private byte veracidade;
	private Funcionario funcionario;

    public Arquivo() {
    }


	@Id
	@Column(name="cod_arquivo", unique=true, nullable=false)
	public int getCodArquivo() {
		return this.codArquivo;
	}

	public void setCodArquivo(int codArquivo) {
		this.codArquivo = codArquivo;
	}


    @Lob()
	public String getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="dt_upload")
	public Date getDataUpload() {
		return this.dataUpload;
	}

	public void setDataUpload(Date dtUpload) {
		this.dataUpload = dtUpload;
	}


	public byte getVeracidade() {
		return this.veracidade;
	}

	public void setVeracidade(byte veracidade) {
		this.veracidade = veracidade;
	}


	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="chapa", nullable=false)
	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}