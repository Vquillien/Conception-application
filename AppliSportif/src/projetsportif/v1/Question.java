package projetsportif.v1;

/**
 *Created by AZIZ Hamza on 12/02/2018.
 */
public class Question {

    private String titre;
    private Boolean valDef;

    /**
     * @param titre un titre
     * @param valDef une valeur par défaut
     */
    public Question(String titre, Boolean valDef) {
        this.setTitre(titre);
        this.setValDef(valDef);
        if(this.titre =="" && this.valDef ==null)
        {
        	System.out.printf("Attention formulaire incomplet \n");	
        }
    }

    /**
     * @return titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre un titre
     */
    public void setTitre(String titre) {
    	char chr;
    	boolean test=true;
    	if(titre=="")
    	{
			System.out.printf("Saisie vide \n");
			test=false;
    	}
    	if(test)
    	{
    		this.titre = titre;
    		//mettre en forme nom 
			this.titre = this.titre.substring(0,1).toUpperCase() + this.titre.substring(1,titre.length()).toLowerCase(); //Premi�re lettre en maj puis minuscule

    	}
    	else
    	{
    		this.titre="";
    	}
    		
    }

    /**
     * @return valdef
     */
    public Boolean getValDef() {
        return valDef;
    }

    /**
     * @param valDef la nouvelle valeur par défaut
     */
    public void setValDef(Boolean valDef) {
    	if(valDef==null)
    	{
    		System.out.printf("Choisissez une reponse !\n");
    		this.valDef = false;
    	}
    	else
    	{
    		this.valDef = valDef;
    	}
    }

}
