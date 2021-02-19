package fr.eql.ai108.rmi.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.eql.ai108.rmi.entity.Toto;

public interface ICalcul extends Remote{
	int add(int i, int j) throws RemoteException;
	double pow(double a, double b) throws RemoteException;
	Toto getToto() throws RemoteException;
}
