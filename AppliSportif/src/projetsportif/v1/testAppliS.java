package projetsportif.v1;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Created by quillivi on 12/02/2018.
 */
public class testAppliS {

	public AppliSportif monAppliS;
    @org.junit.Before
    public void setUp() throws Exception {
    	monAppliS = new AppliSportif();
    }
    
    @Test
    public void Scenario(){
    	monAppliS.ajouterSportif("Federer","Roger","titi","2010-10-10","natation");
    	int indexQ1 = (int) monAppliS.ajouterQuestionnaire("QuestHebdo1", "2010-9-10", "2010-10-10");
    	monAppliS.ajouterQuestionQuestionnaire(indexQ1, "Avez-vous pratiquer cette semaine votre activité", true);
    	monAppliS.ajouterQuestionQuestionnaire(indexQ1, "Avez-vous pratiquer un sport plus de 12 heures cette semaine", false);
    	monAppliS.supprimerQuestionQuestionnaire(indexQ1);
    	monAppliS.modifierQuestionnaireTitre(indexQ1, "QuestHebdo2");
    	monAppliS.modifierQuestionnaireDateDebut(indexQ1, "2010-9-12");
    	int indexS = monAppliS.getIndexSportif("titi");
    	int indexQR = monAppliS.ajouterQuestionReponse(indexS, indexQ1);
    	ArrayList<Boolean> b = new ArrayList<Boolean>();
    	b.add(false);
    	b.add(true);
    	monAppliS.repondreQuestionReponse(b, indexQR,"2010-9-20");
    	monAppliS.supprimerSportif("titi");
    	monAppliS.supprimerQuestionnaire(indexQ1);
    	
    }
 
}