package models;

public class Tags {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * @param id
     */
    public Tags(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
