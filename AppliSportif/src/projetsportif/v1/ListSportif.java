package projetsportif.v1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListSportif {
	
	private ArrayList<Sportif> sportifs;
	
	public ListSportif()
	{
		sportifs = new ArrayList<Sportif>();
	}
	
	public int testSportif(Sportif s)
	{
		for(int i=0;i<sportifs.size();i++)
		{
			if(sportifs.get(i).getPseudo().contentEquals(s.getPseudo()))
			{
				System.out.printf("Le pseudo déja existant\n");
				return 1;
			}
			else if(sportifs.get(i).getCouple().contentEquals(s.getCouple()))
			{
				System.out.printf("Personne déja présente dans la BDD avec le pseudo : "+ sportifs.get(i).getPseudo() +" \n");
				return 2;
			}
		}
		if(!s.getComplet())
		{
			System.out.printf("sportif incomplet \n");
			return 3;
		}
		return 0;
	}
	
	public int testSportif(Sportif s, int c)
	{
		for(int i=0;i<sportifs.size();i++)
		{
			if(i!=c)
			{
				if(sportifs.get(i).getPseudo().contentEquals(s.getPseudo()))
				{
					System.out.printf("Le pseudo déja existant\n");
					return 1;
				}
				else if(sportifs.get(i).getCouple().contentEquals(s.getCouple()))
				{
					System.out.printf("Personne déja présente dans la BDD avec le pseudo : "+ sportifs.get(i).getPseudo() +" \n");
					return 2;
				}
			}
		}
		if(!s.getComplet())
		{
			System.out.printf("sportif incomplet \n");
			return 3;
		}
		return 0;
	}
	
	public int ajoutersportif(Sportif s)
	{
		// recherche si pseudo  ou  si couple (nom,prénom,date) déja existant
		int result = testSportif(s);
		if(result==0)
		{
			sportifs.add(s);	
			System.out.printf("Sportif ajouté a la bdd : \n"+ s.toString() + "\n");
		}
		return result;
	}
	
	public boolean modifierSportif(String pseudo, String nom, String prenom, String newPseudo, String activite, String date)
	{
		for(int i=0;i<sportifs.size();i++)
		{
			if(sportifs.get(i).getPseudo().contentEquals(pseudo))
			{
				Sportif newSportif = new Sportif(sportifs.get(i).getNom(),sportifs.get(i).getPrenom(),pseudo,sportifs.get(i).getActivite(),sportifs.get(i).getDate());
				newSportif.modifier(nom, prenom, newPseudo, date, activite);
				int result = testSportif(newSportif,i);
				if(result==0)
				{
					sportifs.get(i).modifier(nom, prenom, newPseudo, date, activite);
					System.out.printf("Sportif modifié a la bdd : "+ sportifs.get(i).toString() + "\n");
					return true;
				}
				else
				{
					return false;
				}
				
			}

		}
		System.out.printf("Pseudo inexistant\n");
		return false;
	}
	
	public boolean supprimerSportif(String p) //sera ensuite dans la classe BDD
	{
		for(int i=0;i<sportifs.size();i++)
		{
			if(sportifs.get(i).getPseudo().contentEquals(p))
			{
				sportifs.remove(sportifs.get(i));
				return true;
			}
		}
		System.out.printf("Pseudo inexistant\n");
		return false;
	}
	
	public void afficherSportifs()
	{
		System.out.printf("liste des sportifs : \n");
		for(int i=0;i<sportifs.size();i++)
		{
			System.out.printf(" \n ------------------------- \n");
			System.out.printf(sportifs.get(i).toString());
		}
	}
	
	public ArrayList<Sportif> getSportifs()
	{
		return this.sportifs;
	}

}