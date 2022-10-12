package teachers;

import accounts.Accounts;


public class Teachers extends Accounts{
    private int promoId;


    public Teachers(int id, String fullName, String phone, String email) {
        super(id, fullName, phone, email);
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public int getPromoId() {
        return promoId;
    }

}
