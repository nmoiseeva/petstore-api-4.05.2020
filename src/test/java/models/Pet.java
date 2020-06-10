package models;

import java.util.List;

public class Pet {

//"{\n" +
//        "  \"id\": 0,\n" +
//        "  \"category\": {\n" +
//        "    \"id\": 0,\n" +
//        "    \"name\": \"string\"\n" +
//        "  },\n" +
//        "  \"name\": \"doggie\",\n" +
//        "  \"photoUrls\": [\n" +
//        "    \"string\"\n" +
//        "  ],\n" +
//        "  \"tags\": [\n" +
//        "    {\n" +
//        "      \"id\": 0,\n" +
//        "      \"name\": \"string\"\n" +
//        "    }\n" +
//        "  ],\n" +
//        "  \"status\": \"available\"\n" +
//        "}"


    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tags> tag;
    private String status;

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<Tags> getTag() {
        return tag;
    }

    public String getStatus() {
        return status;
    }

    /**
     *
     * @param photoUrls
     * @param name
     * @param id
     * @param tag
     * @param status
     */
    public Pet(int id, String name, List<String> photoUrls, List<Tags> tag, String status) {
        this.id = id;
        this.name = name;
        this.category = new Category(3,"zombie");
        this.photoUrls = photoUrls;
        this.tag = tag;
        this.status = status;
    }



}
