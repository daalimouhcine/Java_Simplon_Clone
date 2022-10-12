package students;

import accounts.Accounts;

import constants.Rolls;


public class Students extends Accounts{
    private int promoId;

    Students(int id, String fullName, String phone, String email) {
        super(id, fullName, phone, email);
    }

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

}
