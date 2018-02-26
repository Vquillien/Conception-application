package projetsportif.v1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by AZIZ Hamza on 12/02/2018.
 */
public class Questionnaire {
    private String titre;
    private ArrayList<Question> listQues;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    /**
     * @param date une date a verefier
     */
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
	
    /**
     * @param titre un titre de questionnaire
     */
    public Questionnaire(String titre, String dateDebut, String dateFin) {
       
    	this.setTitre(titre);
        this.setDateDebut(dateDebut);
        this.setDateFin(dateFin);
        this.listQues = new ArrayList<>();
        if((this.titre=="")&&(this.dateDebut==null)&&(this.dateFin==null))
        {
        	System.out.printf("Attenion le formlaire incoplet \n");
        }
    }

    /**
     * @return le titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre un nouveau titre
     */
    public void setTitre(String titre) {
    	
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
			this.titre = this.titre.substring(0,1).toUpperCase() + this.titre.substring(1,titre.length()).toLowerCase(); //Premi鑽e lettre en maj puis minuscule

    	}
    	else
    	{
    		this.titre="";
    	}
    		
    }

    /**
     *
     */
    public ArrayList<Question> getQues() {
        return listQues;
    }

    /**
     * @param ques une liste de questions
     */
    public void setQues(ArrayList<Question> ques) {
        this.listQues = ques;
    }

    /**
     * Ajouter une question ﾃ� la fin de la liste des questions
     * @param titre le titre
     * @return verifExe vrai si question ajouter, faux sinon
     */
    public boolean ajouterQuestion(String titre, boolean valdef){
        Boolean verifExe = true;
        for (Question ques : this.listQues) {
            if(ques.getTitre().equals(titre)){
                verifExe = false;
                return verifExe;
            }
        }
        Question q = new Question(titre, valdef);
        listQues.add(q);
        return verifExe;
    }

    /**
     * Modifier le titre d'une question ﾃ� un index donnﾃｩ
     * @param index l'index de la question
     * @param t le titre de la question
     * @return  verifExe vrai si question modifier, faux si index invalide
     */
    public boolean modifierQuestionTitre(int index, String t){
        Boolean verifExe = false;
        if(index >= 0 && index < this.listQues.size()){
            Question q = this.listQues.get(index);
            q.setTitre(t);
            
            verifExe = true;
        }
        return  verifExe;
    }
    
    public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut2) {
		boolean continu =isDateValid(dateDebut2);
		if(continu)
		{
		this.dateDebut = LocalDate.parse(dateDebut2);
		}
		else
		{
			System.out.printf("format date inccorect");
			this.dateDebut=null;
		}
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin2) {
		boolean continu =isDateValid(dateFin2);
		if(continu)
		{
		this.dateFin = LocalDate.parse(dateFin2);
		}
		else
		{
			System.out.printf("format date inccorect");
			this.dateFin=null;
		}
	}

	/**
     * Modifier la valeur par defaut d'une question ﾃ� un index donnﾃｩ
     * @param index l'index de la question
     * @param b la valeur par dﾃｩfaut
     * @return  verifExe vrai si question modifier, faux si index invalide
     */
    public boolean modifierQuestionValdef(int index,boolean b){
        Boolean verifExe = false;
        if(index >= 0 && index < this.listQues.size()){
            Question q = this.listQues.get(index);
            q.setValDef(b);
            verifExe = true;
        }
        return  verifExe;
    }

    /**
     * Supprimer un question ﾃ� un index donnﾃｩ
     * @param index l'index de la question
     * @return  verifExe vrai si question modifier, faux si index invalide
     */
    public boolean SupprimerQuestion(int index){
	    Boolean verifExe = false;
	        if(this.listQues.get(index) != null){
	            verifExe = true;
	            listQues.remove(index);
	            return verifExe;
	        }
	    return verifExe;
    }
    
    /**
     * remonter une question ﾃ� un index donnﾃｩ
     * @param index l'index de la question
     * @return  verifExe vrai si question modifier, faux si index invalide
     */
    public boolean QuestionUp(int index){
	    Boolean verifExe = false;
	        if(this.listQues.get(index) != null){
	            verifExe = true;	           
	            Collections.swap(listQues, index, index++);
	            Collections.swap(listQues, index++, index);
	            return verifExe;
	        }
	    return verifExe;
    }
    
    /**
     * descender une question ﾃ� un index donnﾃｩ
     * @param index l'index de la question
     * @return  verifExe vrai si question modifier, faux si index invalide
     */
    public boolean QuestionDown(int index){
	    Boolean verifExe = false;
	        if(this.listQues.get(index) != null){
	            verifExe = true;	           
	            Collections.swap(listQues, index, index--);
	            Collections.swap(listQues, index--, index);
	            return verifExe;
	        }
	    return verifExe;
    }
    
}
