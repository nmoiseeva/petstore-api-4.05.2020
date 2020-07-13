package models.StoreModels;
import lombok.Builder;
import lombok.Getter;

import static models.StoreModels.Status.placed;


@Getter
@Builder
public class StoreOrder {

//    { \"id\": 0, " +
//            "\"petId\": 0, " +
//            "\"quantity\": 0, " +
//            "\"shipDate\": \"2020-07-07T12:23:20.360Z\", " +
//            "\"status\": \"placed\", " +
//            "\"complete\": true}

    @Builder.Default
    private int id;
    @Builder.Default
    private long petId;
    @Builder.Default
    private long quantity = 0;
    @Builder.Default
    private Status status = placed;
    @Builder.Default
    private Boolean complete = true;
}
