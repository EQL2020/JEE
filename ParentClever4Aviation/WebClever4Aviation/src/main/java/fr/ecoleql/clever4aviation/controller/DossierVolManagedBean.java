package fr.ecoleql.clever4aviation.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import fr.ecoleql.clever4aviation.entity.ConsigneSurete;
import fr.ecoleql.clever4aviation.entity.Defaut;
import fr.ecoleql.clever4aviation.entity.Vol;
import fr.ecoleql.clever4aviation.ibusiness.GestionDossierVolIBusiness;

@ManagedBean(name = "mbDossierVol")
@ViewScoped
public class DossierVolManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Vol> vols;
	private Vol selectedVol;
	private List<Defaut> defauts;
	private List<ConsigneSurete> consigneSuretes;
	
	@EJB
	private GestionDossierVolIBusiness proxyDossierVolBu;
	
	public void onRowSelect() {
		defauts = proxyDossierVolBu.afficherDefautParVol(selectedVol);
		consigneSuretes = proxyDossierVolBu.afficherConsignesParVol(selectedVol);
	}
	
	@PostConstruct
	public void init() {
		vols =proxyDossierVolBu.afficherTousLesVols();
	}
	public List<Vol> getVols() {
		return vols;
	}
	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}
	public Vol getSelectedVol() {
		return selectedVol;
	}
	public void setSelectedVol(Vol selectedVol) {
		this.selectedVol = selectedVol;
	}
	public List<Defaut> getDefauts() {
		return defauts;
	}
	public void setDefauts(List<Defaut> defauts) {
		this.defauts = defauts;
	}
	public List<ConsigneSurete> getConsigneSuretes() {
		return consigneSuretes;
	}
	public void setConsigneSuretes(List<ConsigneSurete> consigneSuretes) {
		this.consigneSuretes = consigneSuretes;
	}
	
	
	
}
