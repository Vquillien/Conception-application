package projetsportif.v1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by quillivi on 13/02/2018.
 */
public class ListQuestionReponse {

    ArrayList<QuestionReponse> listQestRep;

    public ListQuestionReponse() {
        this.listQestRep = new ArrayList<>();
    }

    public int ajouterQestionReponse(Sportif sportif, Questionnaire quest){
        QuestionReponse questRep = null;
        if(sportif!=null && quest!=null){
            questRep = new QuestionReponse(sportif, quest );
            listQestRep.add(questRep);
        }
        return listQestRep.indexOf(questRep);
    }

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
     
    public void repondreQuest(ArrayList<Boolean> listR, int index, String date){
    	boolean continu = isDateValid(date);
		if(continu)
		{
			listQestRep.get(index).ajouterReponse(LocalDate.parse(date),listR);;
		}
		else
		{
			System.out.printf("format date incorrect");
		}
        
    }

}
