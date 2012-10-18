package br.com.fiap.beans;


import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.segurancaSoa.entity.Funcionario;

 

@ManagedBean(name="cadastroBean")
@RequestScoped
public class CadastroBean {
	boolean cadastro=false;
	Funcionario funcionario= new Funcionario();
	public boolean getCadastrar(){
		funcionario.setDataAdmissao(new Date());
		return cadastro;
	}
	
	public void realizarCadastro(){
		System.out.println("cadastro");
		cadastro=true;
	}
	
	public Funcionario getFuncionario(){
		return this.funcionario;
	}
	
	public void salvar(){
		System.out.println("data:"+funcionario.getDataAdmissao());
	}

}
