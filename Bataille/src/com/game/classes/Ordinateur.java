package com.game.classes;

import java.util.Random;

public class Ordinateur extends Joueur
{
	public Ordinateur(String nom)
	{
		super(nom);
	}
	
	@Override
	public Paquet.Carte choisirCarte()
	{
		this.r = new Random();
		
		int rand_val = r.nextInt(this.paquet.getNombreCartes());
		
		return this.paquet.retirerCarte(rand_val);
	}
}
