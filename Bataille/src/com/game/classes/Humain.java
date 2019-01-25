package com.game.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Humain extends Joueur
{
	public Humain(String nom)
	{
		super(nom);
	}
	
	@Override
	public Paquet.Carte choisirCarte()
	{
		// commenter ci-dessous pour ordinateur vs ordinateur
		String input = null;
		BufferedReader br = null;
		
		try
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			
			input = br.readLine();
			int indice = this.paquet.retirerCarte(input);
			
			if( indice != -1 )
			{
				return this.paquet.retirerCarte(indice);
			}
		}
		catch( Exception e )
		{
			System.err.println("Error : " + e.getMessage());
		}
		
		this.r = new Random();
		
		int rand_val = r.nextInt(this.paquet.getNombreCartes());
		
		return this.paquet.retirerCarte(rand_val);
	}
}
