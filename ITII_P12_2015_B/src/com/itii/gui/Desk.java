package com.itii.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Desk extends JPanel{

	private GridDisplay joueur;
	private GridDisplay adversaire;
	private GameMenu gameMenu;

	
	public Desk(GridDisplay joueur, GridDisplay adversaire) {
		super();
		setJoueur(joueur);
		setAdversaire(adversaire);
		
		
	}
	public GridDisplay getJoueur() {
		return joueur;
	}
	public void setJoueur(GridDisplay joueur) {
		if(this.joueur==null)
		{
			this.joueur=joueur;
		}
	}
	public GridDisplay getAdversaire() {
		return adversaire; 	
	}
	public void setAdversaire(GridDisplay adversaire) {
		if(this.adversaire==null)
		{
			this.adversaire=adversaire;
		}
	}
	
	
}
