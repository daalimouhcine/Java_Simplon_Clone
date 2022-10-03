package promos;

import java.util.HashMap;

public class PromoCollection {
    HashMap<String, Promos> promos;

    public PromoCollection() {
        promos = new HashMap<>();
    }

    public void addPromo(String name) {
        String id = "P-" + (promos.size() + 1);
        promos.put(id, new Promos(id, name));
    }

    public HashMap<String, Promos> getPromos() {
        return promos;
    }

    public Promos getSpecificPromo(String key) {
        return promos.get(key);
    }

    public void showPromoList() {
        promos.forEach((key, value) -> {
            System.out.println(key + ". " + value.getName());
        });
    }

    public void showUnassignedPromos() {
        promos.forEach((key, value) -> {
            if(value.getTeacherId() == null) {
                System.out.println(key + ". " + value.getName());
            }
        });
    }

}
