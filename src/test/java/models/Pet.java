package models;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class Pet {

    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tags[] tags;
    private String status;



    /**
     *  @param id
     * @param name
     */
    public Pet(long id, String name) {
        this.id = id;
        this.name = name;
        this.category = new Category(3,"zombie");
        this.photoUrls = new String [] {"url1", "url2"};
        this.tags = new Tags[] {new Tags("zoo"), new Tags("zoo2")};
        this.status = "available";
    }
//
//    /**
//     *  @param id
//     * @param name
//     * @param status
//     */
//    public Pet(long id, String name, String status) {
//        this.id = id;
//        this.name = name;
//        this.category = new Category(3,"zombie");
//        this.photoUrls = new String [] {"url1", "url2"};
//        this.tags = new Tags[] {new Tags("zoo"), new Tags("zoo2")};
//        this.status = status;
//    }



}
