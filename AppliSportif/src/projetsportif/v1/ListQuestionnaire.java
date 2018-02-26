package projetsportif.v1;

import java.util.ArrayList;


/**
 * Created by AZIZ Hamza on 12/02/2018.
 * */
class ListQuestionnaire {

    /**
     * 
     * */
    private ArrayList<Questionnaire> listQuestionnaire;


    /**
     *
     */
    public ListQuestionnaire() {
        this.listQuestionnaire = new ArrayList<Questionnaire>();
    }

    /**
     * @return listQuestionnaire
     */
    public ArrayList<Questionnaire> getListQuestionnaire() {
        return listQuestionnaire;
    }


    /**
     * @param listQuest une liste de Questionnaire
     */
    public void setListQuestionnaire(final ArrayList<Questionnaire> listQuest) {
        this.listQuestionnaire = listQuest;
    }
    
    /**
     * Ajouter un questionnaire ﾃ� la fin de la liste des questionnaires
     * @param titre le titre
     * @param date debut 
     * @param date fin
     * @return verifExe vrai si question ajouter, faux sinon
     */
    public int ajouterQuestionnaire(String titre, String date_debut, String date_fin){
        int ret = -1;
        for (Questionnaire ques : this.listQuestionnaire) {
            if(ques.getTitre().equals(titre)){
                return ret;
            }
        }
        Questionnaire q = new Questionnaire(titre,date_debut,date_fin);
        listQuestionnaire.add(q);
        return listQuestionnaire.indexOf(q);
    }
    
    /**
     * Modifier le titre d'un questionnaire ﾃ� un index donnﾃｩ
     * @param index l'index de la question
     * @param t le titre de la question
     * @return  verifExe vrai si question modifier, faux si index invalide
     */
    public boolean modifierQuestionnaireTitre(int index, String t){
        Boolean verifExe = false;
        if(index >= 0 && index < this.listQuestionnaire.size()){
            Questionnaire q = this.listQuestionnaire.get(index);
            q.setTitre(t);
            verifExe = true;
        }
        return  verifExe;
    }
    
    /**
     * Modifier la date de debut d'un questionnaire ﾃ� un index donnﾃｩ
     * @param index l'index du questionnaire 
     * @param d la date de debut du questionnaire
     * @return  verifExe vrai si question modifier, faux si index invalide
     */
    public boolean modifierQuestionnaireDatedebut(int index, String d){
        Boolean verifExe = false;
        if(index >= 0 && index < this.listQuestionnaire.size()){
            Questionnaire q = this.listQuestionnaire.get(index);
            q.setDateDebut(d);
            verifExe = true;
        }
        return  verifExe;
    }
    
    /**
     * Modifier la date de fin d'un questionnaire ﾃ� un index donnﾃｩ
     * @param index l'index du questionnaire 
     * @param d la date de fin du questionnaire
     * @return  verifExe vrai si question modifier, faux si index invalide
     */
    public boolean modifierQuestionnaireDatefin(int index, String d){
        Boolean verifExe = false;
        if(index >= 0 && index < this.listQuestionnaire.size()){
            Questionnaire q = this.listQuestionnaire.get(index);
            q.setDateFin(d);
            verifExe = true;
        }
        return  verifExe;
    }
    
    /**
     * Supprimer un questionnaire d'un index donnée
     * @param index l'index de la question
     * @return  verifExe vrai si question modifier, faux si index invalide
     */
    public boolean SupprimerQuestionnaire(int index){
	    Boolean verifExe = false;
	        if(this.listQuestionnaire.get(index) != null){
	            verifExe = true;
	            listQuestionnaire.remove(index);
	            return verifExe;
	        }
	    return verifExe;
    }
}
