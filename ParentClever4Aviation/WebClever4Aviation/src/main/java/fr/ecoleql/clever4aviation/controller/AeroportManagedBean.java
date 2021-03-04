package fr.ecoleql.clever4aviation.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.ecoleql.clever4aviation.entity.Aeroport;
import fr.ecoleql.clever4aviation.ibusiness.AeroportIBusiness;

@ManagedBean (name = "mbAeroport")
@RequestScoped
public class AeroportManagedBean {
	
	private List<Aeroport> aeroports;
	
	@EJB
	private AeroportIBusiness proxyAeroportBu;
	
	@PostConstruct
	public void init() {
		aeroports = proxyAeroportBu.displayAllAirport();
	}

	public List<Aeroport> getAeroports() {
		return aeroports;
	}

	public void setAeroports(List<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}
	
	
		
}
