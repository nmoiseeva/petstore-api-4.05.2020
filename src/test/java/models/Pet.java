package models;

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

    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Object[] tags;
    private String status;

    public long getId() {
        return id;
    }

    public Object getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls(String s) {
        return photoUrls;
    }

    public Object[] getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public Pet(long id, String name, String[] photoUrl) {
        this.category = new Category(3,"zombies");
        this.id = id;
        this.name = name;
        this.photoUrls = photoUrl;
    }
}
