package clients;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import services.Game;

public class Client {
	public static void main (String[] args){
		
		try {
			Game stub = (Game)Naming.lookup("rmi://localhost:1099/SN");
		
			
			System.out.println("Choose a number betwen 0 and 100 :");
			
			int res=0;
			do{
				Scanner clavier = new Scanner(System.in);
				int nb  = clavier.nextInt();
				res =stub.play(nb);
				switch (res) {
				case 1:
					System.out.println("Bien Joué!! Vous avez Gagné");
					break;
				case 2:
					System.out.println("vous devez choisir un nombre <<");
					break;
				case -1:
					System.out.println("vous devez choisir un nombre >>");
					break;
				case 0:
					System.out.println("Partie Terminée !");
				/*si la partie on affiche l@ip de gagnant*/
				/******************************************************************/	
				/**/System.out.println("@ IP de gagnant est: "+stub.getWinner());/**/
				/*******************************************************************/	
					break;
				default:
					break;
				}
				
			}while(res !=0 && res!=1);
		
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			//probléme d'accé
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			
			//Nom d'un objet qui n'existe pas
			e.printStackTrace();
		}
	}
}
