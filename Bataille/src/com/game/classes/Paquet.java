package com.game.classes;

import java.util.ArrayList;
import java.util.Random;

public class Paquet
{
	public class Carte
	{
		public static final int CAPACITY = 52, EMPTY = 0;
		public static final String JQK = "JQK";
		
		private int valeur;
		private Couleur couleur;
		
		public Carte(int valeur, Couleur couleur)
		{
			this.valeur = valeur;
			this.couleur = couleur;
		}
		
		public int getValeur()
		{
			return this.valeur;
		}
		
		public Couleur getCouleur()
		{
			return this.couleur;
		}
		
		public int compare(Carte avec)
		{
			int ret = 0;
			
			if( this.valeur < avec.valeur )
			{
				ret = -1;
			}
			else if( this.valeur > avec.valeur )
			{
				ret = 1;
			}
			else
			{
				if( this.couleur.ordinal() < avec.couleur.ordinal() )
				{
					ret = -1;
				}
				else
				{
					ret = 1;
				}
			}
			
			return ret;
		}
		
		@Override
		public String toString()
		{
			switch( this.valeur )
			{
				case 1:
					return "A " + this.couleur;
				case 11:
					return "J " + this.couleur;
				case 12:
					return "Q " + this.couleur;
				case 13:
					return "K " + this.couleur;
				default:
					return this.valeur + " " + this.couleur;
			}
		}
	}
	
	private ArrayList<Carte> cartes;
	
	public Paquet()
	{
		this.cartes = new ArrayList<>();
	}
	
	public boolean ajouterCarte(Carte c)
	{
		return this.cartes.add(c);
	}
	
	public Carte retirerCarte()
	{
		return this.cartes.remove(this.getNombreCartes() - 1);
	}
	
	public Carte getCarte(int index)
	{
		return this.cartes.get(index);
	}
	
	public int getNombreCartes()
	{
		return this.cartes.size();
	}
	
	public void melanger()
	{
		Random r = new Random();
		int index_1;
		int index_2;
		Carte temp;
		
		for( int i = 0; i < this.getNombreCartes() * 2; ++i )
		{
			index_1 = r.nextInt(this.getNombreCartes());
			index_2 = r.nextInt(this.getNombreCartes());
			
			if( index_1 != index_2 )
			{
				temp = this.getCarte(index_1);
				this.cartes.set(index_1, this.getCarte(index_2));
				this.cartes.set(index_2, temp);
			}
		}
	}

	public Carte retirerCarte(int indice)
	{
		return this.cartes.remove(indice);
	}
	
	public int retirerCarte(String input)
	{
		for( int i = 0; i < this.getNombreCartes(); ++i )
		{
			if( this.getCarte(i).toString().equals(input) )
			{				
				return i;
			}
		}
		
		return -1;
	}
	
	@Override
	public String toString()
	{
		String s = new String();
		
		s += "[";
		for( int i = 0; i < this.getNombreCartes(); ++i )
		{
			if( this.getCarte(i) != null )
			{
				if( i == this.getNombreCartes() - 1 )
				{
					s += this.getCarte(i).toString();
				}
				else
				{
					s += this.getCarte(i).toString();
					s += ", ";
				}
			}
		}
		s += "]";
		
		return s;
	}
}
