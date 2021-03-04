package fr.afcepf.le7o.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.le7o.data.TraineeIDao;
import fr.afcepf.le7o.entity.Trainee;

@Service
public class TraineeService implements TraineeIService {
	
	@Autowired
	private TraineeIDao proxyTrainee;

	@Override
	public List<Trainee> displayAll() {

		return proxyTrainee.getAllTrainee();
	}

	public TraineeIDao getProxyTrainee() {
		return proxyTrainee;
	}

	public void setProxyTrainee(TraineeIDao proxyTrainee) {
		this.proxyTrainee = proxyTrainee;
	}

}
