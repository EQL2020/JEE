package fr.eql.ai108.jsf2.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "mbJS")
@SessionScoped
public class TestJSManagesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String result;
	
	private String valJS;
	



	public String action() {
		System.out.println(result);
		System.out.println(valJS);
		return "displayJS.xhtml?faces-redirect=true";
	}
	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getValJS() {
		return valJS;
	}


	public void setValJS(String valJS) {
		this.valJS = valJS;
	}

}
