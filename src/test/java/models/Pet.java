package models;

import java.util.ArrayList;
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

    private long id;
    private Category category;
    private String name;
    private PhotoUrls[] photoUrls;
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

    public PhotoUrls[] getPhotoUrls(String s) {
        return photoUrls;
    }

    public Object[] getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public <url> Pet(long id, String name) {
        this.category = new Category(3,"zombies");
        this.id = id;
        this.name = name;
        List<PhotoUrls> photoUrls = (List<PhotoUrls>) new ArrayList<url>();
        photoUrls.add(new PhotoUrls("data:image/jpeg;base64,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"));
    }
}
