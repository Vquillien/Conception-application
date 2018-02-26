package projetsportif.v1;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


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
		this.setNom(n);
		this.setPrenom(p);
		this.setPseudo(ps);
		this.setActivite(a);
		this.setDate(d);
		if((this.nom!="")&&(this.prenom!="")&&(this.pseudo!="")&&(this.activite!="")&&(this.dateNaissance!=null))
		{
			this.complet = true;
		}
		else
		{
			System.out.printf("Attention formulaire incomplet \n");
			this.complet = false;
		}
	}
	
	//modifier
	public void modifier(String nom, String prenom , String pseudo , String date , String activite)
	{
		if(nom!="")
		{
			this.setNom(nom);
		}
		if(prenom!="")
		{
			this.setPrenom(prenom);
		}
		if(pseudo!="")
		{
			this.setPseudo(pseudo);
		}
		if(activite!="")
		{
			this.setActivite(activite);
		}
		if(date!="")
		{
			this.setDate(date);	
		}
		if((this.nom!="")&&(this.prenom!="")&&(this.pseudo!="")&&(this.activite!="")&&(this.dateNaissance!=null))
		{
			this.complet = true;
		}
		else
		{
			System.out.printf("Incomplet");
			this.complet = false;
		}
	}
	

	//toString
	
	public String toString()
	{
		return " Nom : " + this.nom + "\n Pr駭om : " + this.prenom + "\n Pseudo : " + this.pseudo + "\n Date de naissance : " + this.dateNaissance + "\n Activit� sportive : " + this.activite +"\n Formulaire complet :" + this.complet + "\n" ;
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
	
	public LocalDate getDate()
	{
		return this.dateNaissance;
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
	//setter
	
	public void setPseudo(String p)
	{
		char chr;
		int c = 0;
		boolean test = true;
		if (p!="") //test si chaine vide / null
		{
			for(int i =0;i<p.length();i++)
			{
				chr = p.charAt(i); //recup鑽e le caract鑽e
		        if ( Character.isLetter(chr)) //test si caract鑽e 
				{
					c++;
				}
			}
			if(c==0) // si pas de lettre saisie invalide
			{
				System.out.printf("Le pseudo doit contenir au moins une lettre, veuillez saisir le pseudo du sportif \n");
				test = false;
			}
		}
		else
		{
			System.out.printf("Saisie vide \n");
			test = false;
		}
		
		if(test)
		{
			this.pseudo=p;
			this.pseudo = this.pseudo.toLowerCase();
		}
		else
		{
			this.pseudo="";
		}
	}
	
	public void setNom(String n)
	{
		char chr;
		boolean test = true;
		if (n!="") 
		{
			for(int i =0;i<n.length();i++)
			{
				chr = n.charAt(i); //recup鑽e le caract鑽e
		        if ( !Character.isLetter(chr)) //test si caract鑽e valide
				{
					System.out.printf("Caract鑽e invalide \n");
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
			this.nom = this.nom.substring(0,1).toUpperCase() + this.nom.substring(1,nom.length()).toLowerCase(); //Premi鑽e lettre en maj puis minuscule

		}
		else
		{
			this.nom="";
		}
		
	}
	
	public void setPrenom(String p)
	{
		char chr;
		boolean test = true;
		if (p!="") 
		{
			for(int i =0;i<this.nom.length();i++)
			{
				chr = p.charAt(i); //recup鑽e le caract鑽e
		        if ( !Character.isLetter(chr)) //test si caract鑽e valide
				{
					System.out.printf("Caract鑽e invalide \n");
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
			this.prenom = this.prenom.substring(0,1).toUpperCase() + this.prenom.substring(1,prenom.length()).toLowerCase(); //Premi鑽e lettre en maj puis minuscule

		}
		else {
			this.prenom="";
		}
	}
	
	public void setDate(String d)
	{
		//DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		boolean continu = isDateValid(d);
		if(continu)
		{
			this.dateNaissance = LocalDate.parse(d);
		}
		else
		{
			System.out.printf("format date incorrect");
			this.dateNaissance=null;
		}
	}
	
	public void setActivite(String a)
	{
		a = a.substring(0,1).toUpperCase() + a.substring(1,a.length()).toLowerCase();
		boolean parcours = false;
		for(Activites activite : Activites.values()){
			if(activite.toString() == a)
			{
				this.activite=a;
				parcours = true;
			}	    	
	    }
		if(!parcours)
		{
			this.activite="";
			System.out.printf("Activit� : "+ a + " pas présent dans la liste");
		}
	}

}


