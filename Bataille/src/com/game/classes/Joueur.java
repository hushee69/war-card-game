package com.game.classes;

import java.util.Random;

public abstract class Joueur
{
	protected String nomJoueur;
	protected Paquet paquet;
	protected Random r;
	
	public Joueur(String nomJoueur)
	{
		this.nomJoueur = nomJoueur;
		this.paquet = new Paquet();
	}
	
	public abstract Paquet.Carte choisirCarte();
	
	public void recupererCarte(Paquet.Carte c)
	{
		this.paquet.ajouterCarte(c);
	}
	
	public final void nouveauJeu()
	{
		this.paquet.melanger();
	}
	
	public final Paquet.Carte jouer()
	{
		return this.paquet.retirerCarte();
	}
	
	public boolean aPerdu()
	{
		return this.paquet.getNombreCartes() == 0;
	}
	
	@Override
	public String toString()
	{
		String s = new String();
		
		s += this.nomJoueur;
		s += this.paquet.toString();
		
		return s;
	}
}
