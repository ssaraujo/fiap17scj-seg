package br.com.fiap.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.segurancafiap.util.Seguranca;

@ManagedBean(name="recebeArquivoBean")
//@ViewScoped
@RequestScoped
public class RecebeArquivoBean {
    Seguranca s= new Seguranca();
    String chavePrivada;
	public RecebeArquivoBean() {
		this.chavePrivada =s.getChavePrivada();
	}

	public String getChavePrivada(){
		//FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		return chavePrivada;
	}
	/*
	public void arquivar(ValueChangeEvent event){
		// if (event.getComponent().!=null){
		//System.out.println(event.getNewValue().toString());
		System.out.println("gsdgfsd");
		System.out.println(s);
		//}
	}*/
	
	public String getValor(){
		System.out.println("getValor");
		return "";
	}
	public void setValor(String valor){
		System.out.println("setValor");
		System.out.println(valor);
		
	}
	

}
