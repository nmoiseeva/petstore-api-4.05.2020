package models.StoreModels;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

import static models.StoreModels.Status.placed;


@Getter
@Builder
public class StoreOrder {

    @Builder.Default
    private int id;
    @Builder.Default
    private long petId;
    @Builder.Default
    private long quantity = 0;
    @Builder.Default
    private String shipDate = Instant.now().toString();
    @Builder.Default
    private Status status = placed;
    @Builder.Default
    private Boolean complete = true;
}
