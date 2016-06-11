package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;


import impl.GameImpl;
public class GameServer {

	public static void main(String[] args){
		//Demarrer l'annuaire
		try {
		LocateRegistry.createRegistry(1099);
		System.out.println("Registre is running");
		GameImpl gi= new GameImpl();
		System.out.println("The Secret Number is: "+gi.getSecretNumber());
		
		Naming.rebind("rmi://localhost:1099/SN", gi);
		//System.out.println("Ref Object Game"+gi);
		//if(gi.getWinner()!=null) System.out.println("The winner is: "+gi.getWinner());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
