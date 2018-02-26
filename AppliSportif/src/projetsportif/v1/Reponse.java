package projetsportif.v1;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by quillivi on 12/02/2018.
 */
public class Reponse {

    ArrayList<Boolean> listR;
    LocalDate dateReponse;

    public Reponse(LocalDate dateReponse) {
        this.listR = new ArrayList<>();
        this.dateReponse = dateReponse;
    }

    public ArrayList<Boolean> getListR() {
        return listR;
    }

    public void setListR(ArrayList<Boolean> listR) {
        this.listR = listR;
    }

    public LocalDate getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(LocalDate dateReponse) {
        this.dateReponse = dateReponse;
    }

}
