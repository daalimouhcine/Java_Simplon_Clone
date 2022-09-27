package promos;

import briefs.Briefs;
import students.Students;

import java.util.HashMap;

public class Promos {
    public int id;
    public String name;
    public HashMap<Integer, Students> students = new HashMap<>();
    public HashMap<Integer, Briefs> briefs = new HashMap<>();
    private HashMap<Integer, Promos> promos = new HashMap<>();

    public Promos( ) {

    }

}
