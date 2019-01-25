package com.game.classes;

public class Application
{
	public static void main(String[] args)
	{
		Jeu j = new Jeu();
		
		j.creerNouveauPaquet();
		j.paquet.melanger();
		j.distribuerPaquet();
		
		int nb_moves = 0;
		
		while( true )
		{
			System.out.println("Cartes humain : " + j.humain.paquet.getNombreCartes());
			System.out.println("Carte ordi : " + j.ordi.paquet.getNombreCartes());
			
			System.out.println(j.humain.toString());
			System.out.println("Vous avez " + j.humain.paquet.getNombreCartes() + " cartes");
			System.out.println(j.ordi.toString());
			System.out.println("Ordinateur a " + j.ordi.paquet.getNombreCartes() + " cartes");
			
			System.out.print("Choissisez une carte : ");
			Paquet.Carte h = j.humain.choisirCarte();
			Paquet.Carte o = j.ordi.choisirCarte();
			
			System.out.println("Humain : " + h.toString());
			System.out.println("Ordinateur : " + o.toString());
			
			if( h.compare(o) > 0 )
			{
				System.out.println("Vous avez gagne la carte");
				
				j.humain.recupererCarte(h);
				j.humain.recupererCarte(o);
			}
			else
			{
				System.out.println("Ordinateur a gagne la carte");
				
				j.ordi.recupererCarte(h);
				j.ordi.recupererCarte(o);
			}
			
			if( j.humain.aPerdu() )
			{
				System.out.println("Ordinateur gagne en " + nb_moves + " moves");
				System.exit(0);
			}
			if( j.ordi.aPerdu() )
			{
				System.out.println("Humain gagne en " + nb_moves + " moves");
				System.exit(0);
			}
			
			System.err.println("moves = " + nb_moves);
						
			nb_moves++;
		}
	}
}
