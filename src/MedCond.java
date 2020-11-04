import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MedCond implements Serializable {
    //declare all attributes
    public String mdContact, mdPhone, algType, illType;
    //constructor
    public MedCond(String contact, String phone, String alg, String ill){
        this.mdContact = contact;
        this.mdPhone = phone;
        this.algType = alg;
        this.illType = ill;
    }
    //all functions are simple updates or attribute retrievals
    public String getMdContact(){return mdContact;}
    public String getMdPhone(){return mdPhone;}
    public String getAlgType(){return algType;}
    public String getIllType(){return illType;}
    public void updateMdContact(String newContact){mdContact = newContact;}
    public void updateMdPhone(String newPhone){mdPhone = newPhone;}
    public void updateAlgType(String newAlg){algType = newAlg;}
    public void updateIllType(String newIll){illType = newIll;}
}
