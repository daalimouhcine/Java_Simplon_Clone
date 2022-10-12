package briefs;

import validationMessage.ValidationMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class Briefs {
    public int id;
    public int promoId;
    public String title;
    public String description;
    public String technologies;
    public boolean launch;
    public HashMap<String, ValidationMessage> valide;

    Briefs(int id, int promoId, String title, String description, String technologies) {
        valide = new HashMap<>();
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

    public void validateBrief(String studentId, String briefId, String message, String repoLink) {
        valide.put(studentId, new ValidationMessage(studentId, briefId, message, repoLink));
    }

    public ValidationMessage isStudentValidate(String studentKey) {
        return valide.get(studentKey);
    }


}
