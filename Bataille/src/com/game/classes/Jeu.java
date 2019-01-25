package com.game.classes;

public class Jeu
{
	Joueur humain = new Humain("hawkster");
	Joueur ordi = new Ordinateur("ordinateur");
	
	Paquet paquet;
	
	public Jeu()
	{
		humain = new Humain("hawkster");
		ordi = new Ordinateur("ordinateur");
		
		this.paquet = new Paquet();
	}
	
	public void creerNouveauPaquet()
	{
		int couleur_index = 0;
		
		for( int i = 0, value_index = 1; i < Paquet.Carte.CAPACITY; ++i, ++value_index )
		{
			this.paquet.ajouterCarte(paquet.new Carte(value_index, Couleur.values[couleur_index]));
			
			if( value_index % 13 == 0 )
			{
				couleur_index++;
				value_index = 0;
			}
		}
	}
	
	public void distribuerPaquet()
	{
		for( int i = 0; i < Paquet.Carte.CAPACITY; ++i )
		{
			if( i % 2 == 0 )
			{
				this.humain.paquet.ajouterCarte(this.paquet.getCarte(i));
			}
			else
			{
				this.ordi.paquet.ajouterCarte(this.paquet.getCarte(i));
			}
		}
	}
	
	public Joueur joueurCoup()
	{
		if( humain.getClass().equals("Humain") )
		{
			System.out.println("called humain function");
			humain.choisirCarte();
			
			return ordi;
		}
		else
		{
			ordi.choisirCarte();
			
			return humain;
		}
	}
}
