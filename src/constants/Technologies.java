package constants;

public enum Technologies {
    Java(1, "Java"),
    JavaScript(2, "JavaScript"),
    Php(3, "Php"),
    Sql(4, "Sql"),
    Html(5, "Html"),
    Css(6, "Css"),
    React(7, "React"),
    Vue(8, "Vue"),
    Angular(9, "Angular"),
    Bootstrap(10, "Bootstrap"),
    Tailwind(11, "Tailwind");

    private int id;
    private String name;

    Technologies(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public static String getById(int id) {
        for(Technologies tech: Technologies.values()) {
            if(tech.id == id) {
                return tech.getName();
            }
        }
            throw new IllegalArgumentException();
    }
}
