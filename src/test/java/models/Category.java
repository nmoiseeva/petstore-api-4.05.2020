package models;

public class Category {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * @param name
     * @param id
     */
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}