package impl;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import services.Game;

public class GameImpl extends UnicastRemoteObject implements Game{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6117081019289755300L;
/********************************ATTRIBUTS*********************************/	
	private String winner=null;/*pour stocker l@ ip de gagnant*/
	private int secretNumber;
	private boolean end;
/**************************************************************************/
	
/*******************************CONSTRUCTEUR*******************************/	
	public GameImpl()throws RemoteException{                          
		this.secretNumber = (int)(Math.random()*100);
		this.end=false;
	}
/**************************************************************************/	

/****************************METHODES**OFFERTES**PAR*LE*SERVEUR************/

/******************************PLAY****************************************/
	@Override
	public int play(int n) throws RemoteException {
		if(this.end==false){
			if(n==this.secretNumber) {
				this.end=true;
				try {
					
					winner = getClientHost();
					System.out.println(winner);
				} catch (ServerNotActiveException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 1;
			}
			else if(n>this.secretNumber) 
				return 2;
			else 
				return -1;
		}
		else{
			return 0;
		}
		}
/******************************************************************************/
/***************************GETWINNER******************************************/
	
	public String getWinner() {
		return winner;
	}
/******************************************************************************/	
/******************************************************************************/	
	

/********************************getters & setters*****************************/
	public int getSecretNumber() {
		return secretNumber;
	}
	public void setSecretNumber(int secretNumber) {
		this.secretNumber = secretNumber;
	}
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}

/**********************************************************************************/
	
/**************************************FIN*****************************************/
	
	
}
