package fr.afcepf.le7o.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.afcepf.le7o.entity.Trainee;
import fr.afcepf.le7o.service.TraineeIService;

@ManagedBean(name="mbTrainee")
@ViewScoped
public class TraineeManagedBean {
	
	@ManagedProperty(value="#{traineeService}")
	private TraineeIService proxyService;
	
	private List<Trainee> trainees;
	
	@PostConstruct
	public void init(){
		trainees = proxyService.displayAll();

	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

	public TraineeIService getProxyService() {
		return proxyService;
	}

	public void setProxyService(TraineeIService proxyService) {
		this.proxyService = proxyService;
	}
	

}
