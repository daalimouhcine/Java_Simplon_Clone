package teachers;

import accounts.Accounts;

import briefs.Briefs;

import java.util.ArrayList;

public class Teachers extends Accounts{
    private String promoId;
    private final ArrayList<String> createdBriefs;

    public Teachers(String id, String fullName, String phone, String email, String roll) {
        super(id, fullName, phone, email, roll);
        createdBriefs = new ArrayList<>();
    }

    public void setPromoId(String promoId) {
        this.promoId = promoId;
    }

    public String getPromoId() {
        return promoId;
    }

    public ArrayList<String> getCreatedBriefs() {
        return createdBriefs;
    }

    public void addCreateBrief(String briefId) {
        createdBriefs.add(briefId);
    }

    public void showListOfCreatedBriefs() {
        createdBriefs.forEach(System.out::println);
    }
}
