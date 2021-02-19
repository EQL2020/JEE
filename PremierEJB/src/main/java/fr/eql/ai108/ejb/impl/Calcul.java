package fr.eql.ai108.ejb.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai108.ejb.api.ICalcul;

@Remote (ICalcul.class)
@Stateless
public class Calcul implements ICalcul{

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public double pow(double i, double j) {
		// TODO Auto-generated method stub
		return Math.pow(i, j);
	}

}
