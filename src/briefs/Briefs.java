package briefs;

import validationMessage.ValidationMessage;

import java.util.ArrayList;

public class Briefs {
    public String id;
    public String promoId;
    public String title;
    public String description;
    public ArrayList<String> technologies;
    public boolean launch;
    public ArrayList<ValidationMessage> valide;

    Briefs(String id, String promoId, String title, String description, ArrayList<String> technologies) {
        this.id = id;
        this.promoId = promoId;
        this.title = title;
        this.description = description;
        this.technologies = technologies;
        this.launch = false;
    }

    public void launchTheBrief() {
        this.launch = true;
    }




}
