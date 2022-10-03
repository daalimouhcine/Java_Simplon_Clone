package students;

import accounts.Accounts;

import constants.Rolls;


public class Students extends Accounts{
    private String promoId;

    Students(String id, String fullName, String phone, String email, String roll) {
        super(id, fullName, phone, email, roll);
    }

    public String getPromoId() {
        return promoId;
    }

    public void setPromoId(String promoId) {
        this.promoId = promoId;
    }

}
