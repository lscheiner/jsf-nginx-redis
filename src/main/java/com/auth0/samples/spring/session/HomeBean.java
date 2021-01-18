package com.auth0.samples.spring.session;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.ReorderEvent;

@Named
@SessionScoped
public class HomeBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Produto> produto = new ArrayList<>();

	@PostConstruct
	public void init() {
		produto.add(new Produto("Produto A", BigDecimal.valueOf(1)));
		produto.add(new Produto("Produto B", BigDecimal.valueOf(2)));
		produto.add(new Produto("Produto C", BigDecimal.valueOf(3)));
		produto.add(new Produto("Produto D", BigDecimal.valueOf(4)));
		produto.add(new Produto("Produto E", BigDecimal.valueOf(5)));
	}

	public void onRowReorder(ReorderEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Linha atualizada",
				"Request aplicacao: " + getApplicationTitle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public String getApplicationTitle() {
		String appTitle = System.getenv().get("APPLICATION_TITLE");
		if (appTitle == null) {
			appTitle = "default title";
		}
		return appTitle;
	}
}
