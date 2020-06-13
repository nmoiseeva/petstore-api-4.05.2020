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

}
