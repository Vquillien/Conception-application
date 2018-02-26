package projetsportif.v1;

import java.util.ArrayList;

public class ListSportif {
	
	ArrayList<Sportif> sportifs;
	
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
				System.out.printf("Le pseudo d駛a existant\n");
				return 1;
			}
			else if(sportifs.get(i).getCouple().contentEquals(s.getCouple()))
			{
				System.out.printf("Personne d駛a pr駸ente dans la BDD avec le pseudo : "+ sportifs.get(i).getPseudo() +" \n");
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
					System.out.printf("Le pseudo d駛a existant\n");
					return 1;
				}
				else if(sportifs.get(i).getCouple().contentEquals(s.getCouple()))
				{
					System.out.printf("Personne d駛a pr駸ente dans la BDD avec le pseudo : "+ sportifs.get(i).getPseudo() +" \n");
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
			System.out.printf("Sportif ajout� a la bdd : \n"+ s.toString() + "\n");
		}
		return result;
	}
	
	public void modifierSportif(String nom, String prenom, String pseudo, String date, String activite)
	{
		for(int i=0;i<sportifs.size();i++)
		{
			if(sportifs.get(i).getPseudo().contentEquals(pseudo))
			{
				Sportif newSportif = new Sportif(nom, prenom, pseudo, date, activite);
				int result = testSportif(sportifs.get(i),i);
				if(result==0)
				{
					sportifs.get(i).modifier(nom, prenom, pseudo, date, activite);
					System.out.printf("Sportif modifi� a la bdd : "+ sportifs.get(i).toString() + "\n");
				}
				
			}

		}
		System.out.printf("Pseudo inexistant\n");
	}
	
	public void supprimerSportif(String p) //sera ensuite dans la classe BDD
	{
		for(int i=0;i<sportifs.size();i++)
		{
			if(sportifs.get(i).getPseudo().contentEquals(p))
			{
				sportifs.remove(sportifs.get(i));
			}
		}
		System.out.printf("Pseudo inexistant\n");
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

	public ArrayList<Sportif> getSportifs() {
		return sportifs;
	}

}
