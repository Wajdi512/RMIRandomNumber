package services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Game extends Remote{

	public int play(int n) throws RemoteException; 
	public String getWinner() throws RemoteException;/*retourne l'@ ip de de gagnant*/
}
