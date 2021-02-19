package fr.eql.ai108.rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.eql.ai108.rmi.api.ICalcul;
import fr.eql.ai108.rmi.entity.Toto;

public class Calcul extends UnicastRemoteObject implements ICalcul{

	public Calcul() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(int i, int j) throws RemoteException {
		System.out.println("C'est moi qui bosse !");
		return i + j;
	}

	@Override
	public double pow(double a, double b) throws RemoteException {
		System.out.println("C'est moi qui bosse !");
		return Math.pow(a, b);
	}

	@Override
	public Toto getToto() throws RemoteException {
		Toto toto = new Toto(1, "Toto", "de Toto");
		return toto;
	}

}
