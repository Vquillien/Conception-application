package projetsportif.v1;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by quillivi on 08/02/2018.
 */

public class QuestionReponse {
    Sportif spotif;
    Questionnaire quest;
    ArrayList<Reponse> listrep;

    public QuestionReponse(Sportif sportif, Questionnaire quest) {
        this.spotif = sportif;
        this.quest = quest;
        this.listrep = new ArrayList<Reponse>();
    }

    public Sportif getSpotif() {
        return spotif;
    }

    public void setSpotif(Sportif spotif) {
        if(spotif!=null){
            this.spotif = spotif;
        }
    }

    public Questionnaire getQuest() {
        return quest;
    }

    public void setQuest(Questionnaire quest) {
        if(quest!=null) {
            this.quest = quest;
        }
    }

    public ArrayList<Reponse> getListrep() {
        return listrep;
    }

    public void ajouterReponse(LocalDate d, ArrayList<Boolean> listR){
        if(d!=null && listR!=null ){
            Reponse rep = new Reponse(d);
            rep.setListR(listR);
        }
    }

}
