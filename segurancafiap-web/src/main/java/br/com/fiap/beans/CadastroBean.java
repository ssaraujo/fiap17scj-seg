package br.com.fiap.beans;




import java.util.Date;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;



import br.com.fiap.segurancafiap.dao.FuncionarioDAO;
import br.com.fiap.segurancafiap.entity.Funcionario;
import br.com.fiap.segurancafiap.util.Seguranca;






@ManagedBean(name="cadastroBean")
@ViewScoped
public class CadastroBean {
	Integer modo =0;
	boolean salvo=false;
	public boolean getModo() {
		if(modo==0)return true;
		return false;
	}
	public void setModo(boolean modo) {
		
	}

	Funcionario funcionario= new Funcionario();
	@EJB
	FuncionarioDAO funcionarioDAO;
	
	
		
	public Funcionario getFuncionario(){
		return this.funcionario;
	}
	public void setFuncionario(Funcionario funcionario){
		this.funcionario=funcionario;
	}
	
	
	public String salvar(){	
		
		System.out.println(funcionario.getUsuario());
		Seguranca seg= new Seguranca();
		funcionario.setChavePrivada(seg.getChavePrivada());
		funcionario.setChavePublica(seg.getChavePublica());
		
		funcionario.setSenha(seg.gerarMD5(funcionario.getUsuario()));
		this.funcionarioDAO.salva(funcionario);
		modo=1;
		return "sucesso";
	}

}
