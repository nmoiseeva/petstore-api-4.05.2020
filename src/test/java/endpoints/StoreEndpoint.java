package endpoints;

import io.restassured.response.ValidatableResponse;
import models.PetModels.Status;
import models.StoreModels.StoreOrder;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.is;

public class StoreEndpoint extends RequestSpecifications {

    public static final String
            CREATE_ORDER = "/store/order",
            GET_ORDER = "/store/order/{orderId}",
            GET_ALL_PET_FROM_STORE_BY_STATUS = "/store/inventory",
            DELETE_ORDER = "/store/order/{orderId}";


    @Step
    public void getStoreOrderById(int id) {
        given()
                .get(GET_ORDER, id)
                .then()
                .body("id", is(id))
                .statusCode(200);
    }

    @Step
    public void getStatusAllPetFromStore(Status status, int value) {
        given()
                .get(GET_ALL_PET_FROM_STORE_BY_STATUS)
                .then()
                .body(String.valueOf(status), is(value))
                .statusCode(200);
    }


    @Step
    public int createStoreOrder(StoreOrder storeOrder) {
        ValidatableResponse response = given()
                .body(storeOrder)
                .post(CREATE_ORDER).
                        then()
                .body("petId", is(storeOrder.getPetId()))
                .statusCode(200);
        return response.extract().path("id");
    }

    @Step
    public void deleteStoreOrderById(int id) {
        given()
                .delete(DELETE_ORDER, id)
                .then()
                .body("message", is(String.valueOf(id)))
                .statusCode(200);
    }

}
