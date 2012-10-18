package br.com.fiap.segurancafiap.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_grupo database table.
 * 
 */
@Entity
@Table(name="tb_grupo")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String grupo;

    public Grupo() {
    }


	@Id
	@Column(unique=true, nullable=false, length=8)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	@Column(length=45)
	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

}