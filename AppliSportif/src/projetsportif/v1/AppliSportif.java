package projetsportif.v1;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by vincent on 19/02/18.
 */
public class AppliSportif {

	private ListQuestionReponse listQR;
	private ListQuestionnaire listQ;
	private ListSportif listS;

    public AppliSportif() {
        this.listQR = new ListQuestionReponse();
        this.listQ = new ListQuestionnaire();
        this.listS = new ListSportif();
    }

    public void ajouterSportif(String nom,String prenom,String pseudo,String date,String activite){
    	listS.ajoutersportif(new Sportif(nom, prenom, pseudo, date, activite));    
    }

    public void supprimerSportif(String p){
    	/**todo test verif pseudo existe et supprimer toute ses données liée à son compte*/
    	listS.supprimerSportif(p);
    }

    public void modifierSportif(String pseudo, String nom,String prenom,String newPseudo,String date,String activite){
    	listS.modifierSportif(pseudo, nom, prenom, newPseudo, date, activite);
    }

    public int ajouterQuestionnaire(String titre, String date_debut, String date_fin){
        return listQ.ajouterQuestionnaire(titre, date_debut, date_fin);
    }

    public void ajouterQuestionQuestionnaire(int indexQuest,String titre, boolean valdef ){
    	listQ.getListQuestionnaire().get(indexQuest).ajouterQuestion(titre, valdef);
    }
    
    public void supprimerQuestionQuestionnaire(int indexQuest){
    	listQ.getListQuestionnaire().get(indexQuest).SupprimerQuestion(indexQuest);
    }
    
    public void supprimerQuestionnaire(int indexQuest){
    	listQ.getListQuestionnaire().remove(indexQuest);
    }
    
    public void modifierQuestionnaireTitre(int indexQuest, String t){
    	listQ.modifierQuestionnaireTitre(indexQuest, t);
    }
    
    public void modifierQuestionnaireDateDebut(int indexQuest, String d){
    	listQ.modifierQuestionnaireDatedebut(indexQuest, d);
    }
    
    public void modifierQuestionnaireDateFin(int indexQuest, String d){
    	listQ.modifierQuestionnaireDatefin(indexQuest, d);
    }

    public int ajouterQuestionReponse(int indexS, int indexQ){
    	System.out.println(listS.getSportifs().get(indexS).toString());
        return listQR.ajouterQestionReponse(listS.getSportifs().get(indexS),listQ.getListQuestionnaire().get(indexQ));
    }
    
    public void repondreQuestionReponse(ArrayList<Boolean> listR, int indexQR, String date){
        listQR.repondreQuest(listR, indexQR,date);
    }
    
    public int getIndexQuestionnaire(String titre){
    	int ret = -1;
    	
    	return ret;
    }
    
    public int getIndexSportif(String titre){
    	int ret = -1;
    	
    	return ret;
    }
    
    public int getIndexQuestionReponse(String pseudo, String titreQuestionnaire){
    	int ret = -1;
    	
    	return ret;
    }
     

}
