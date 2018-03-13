package projetsportif.v1;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Sportif {
	private String nom;
	private String prenom;
	private String pseudo;
	private String activite;
	private LocalDate dateNaissance;
	private boolean complet = false;
	
	public static boolean isDateValid(String date) 
	{
	        try {
	            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	            df.setLenient(false);
	            df.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}
	
	public Sportif(String n, String p, String ps, String a, String d)
	{
		boolean result;
		this.nom="";
		this.prenom="";
		this.pseudo="";
		this.activite="";
		this.dateNaissance=null;
		result = this.setNom(n);
		result = this.setPrenom(p);
		result = this.setPseudo(ps);
		result = this.setActivite(a);
		result = this.setDate(d);
		verification();
	}
	
	
	public void verification()
	{
		this.complet = (this.nom!="")&&(this.prenom!="")&&(this.pseudo!="")&&(this.activite!="")&&(this.dateNaissance!=null);
	}
	
	//modifier
	public void modifier(String nom, String prenom , String pseudo , String date , String activite)
	{
		boolean result;
		result = this.setNom(nom);
		result = this.setPrenom(prenom);
		result = this.setPseudo(pseudo);
		result = this.setActivite(activite);
		result = this.setDate(date);
		this.verification();
	}
	

	//toString
	
	public String toString()
	{
		return " Nom : " + this.nom + "\n Prénom : " + this.prenom + "\n Pseudo : " + this.pseudo + "\n Date de naissance : " + this.dateNaissance + "\n Activité sportive : " + this.activite +"\n Formulaire complet :" + this.complet + "\n" ;
	}
	
	//getter
	
	public String getPseudo()
	{
		return this.pseudo;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public String getPrenom()
	{
		return this.prenom;
	}
	
	public String getDate()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		return this.dateNaissance.format(formatter);
		
	}
	
	public String getActivite()
	{
		return this.activite;
	}
	
	public String getCouple()
	{
		return this.nom+" "+ this.prenom+" " + this.dateNaissance;
	}
	
	public boolean getComplet()
	{
		return this.complet;
	}
	
	public Sportif getSportif()
	{
		return this;
	}
	//setter
	
	public boolean setPseudo(String p)
	{
		char chr;
		if (p!="") //test si chaine vide / null
		{
			for(int i =0;i<p.length();i++)
			{
				chr = p.charAt(i); //recupère le caractère
		        if ( Character.isLetter(chr)) //test si caractère 
				{
					this.pseudo=p;
					return true;
				}
			}
		}
		return false;
		
	}
	
	public boolean setNom(String n)
	{
		char chr;
		boolean test = true;
		if (n!="") 
		{
			for(int i =0;i<n.length();i++)
			{
				chr = n.charAt(i); //recupère le caractère
		        if ( !Character.isLetter(chr)) //test si caractère valide
				{
					System.out.printf("Caractère invalide \n");
					test=false;
				}
			}
		}
		else
		{
			System.out.printf("Saisie vide  \n");
			test = false;
		}
		
		if(test)
		{
			this.nom=n;
			//mettre en forme nom 
			this.nom = this.nom.substring(0,1).toUpperCase() + this.nom.substring(1,nom.length()).toLowerCase(); //Première lettre en maj puis minuscule
			return true;

		}
		else
		{
			return false;
		}
		
	}
	
	public boolean setPrenom(String p)
	{
		char chr;
		boolean test = true;
		if (p!="") 
		{
			for(int i =0;i<p.length();i++)
			{
				chr = p.charAt(i); //recupère le caractère
		        if ( !Character.isLetter(chr)) //test si caractère valide
				{
					System.out.printf("Caractère invalide \n");
					test=false;
				}
			}
		}
		else
		{
			System.out.printf("Saisie vide  \n");
			test = false;
		}
		
		if(test)
		{
			this.prenom=p;
			//mettre en forme nom 
			this.prenom = this.prenom.substring(0,1).toUpperCase() + this.prenom.substring(1,prenom.length()).toLowerCase(); //Première lettre en maj puis minuscule
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean setDate(String d)
	{
		//DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		boolean continu = isDateValid(d);
		if(continu)
		{
			this.dateNaissance = LocalDate.parse(d);
			return true;
		}
		else
		{
			System.out.printf("format date incorrect");
			return false;
		}
	}
	
	public boolean setActivite(String a)
	{
		a = a.substring(0,1).toUpperCase() + a.substring(1,a.length()).toLowerCase();
		for(Activites activite : Activites.values()){
			System.out.println(activite.toString());
			if(activite.toString().compareTo(a)==0)
			{
				this.activite=a;
				return true;
			}	    	
	    }
		return false;
	}

}


