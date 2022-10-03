package briefs;

import teachers.Teachers;

import java.util.ArrayList;
import java.util.HashMap;

public class BriefCollection {
    HashMap<String, Briefs> briefs;

    public BriefCollection() {
        briefs = new HashMap<>();
    }

    public Briefs addBrief(String title,String promoId, String description, ArrayList<String> technologies) {
        String id = "B-" + briefs.size();
        briefs.put(id, new Briefs(id, promoId, title, description, technologies));
        return briefs.get(id);
    }

    public HashMap<String, Briefs> getBriefs() {
        return briefs;
    }

    public Briefs getSpecificBrief(String key) {
        return briefs.get(key);
    }

    public void showBriefList() {
        briefs.forEach((key, value) -> {
            System.out.println(key + ". " + value.title);
        });
    }
}
