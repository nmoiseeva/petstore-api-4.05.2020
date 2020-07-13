package endpoints;

import io.restassured.response.ValidatableResponse;
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
    public void getStoreOrderById(int id){
        given()
                .get(GET_ORDER, id)
                .then()
                .body("id", is (id))
                .statusCode(200);
    }

    @Step
    public void getStatusAllPetFromStore(){
        given()
                .get(GET_ALL_PET_FROM_STORE_BY_STATUS)
                .then()
                .body("SUPER", is (1))
                .statusCode(200);
    }


    @Step
    public int createStoreOrder(StoreOrder storeOrder){
        ValidatableResponse response = given()
                .body(storeOrder)
                .post(CREATE_ORDER).
                        then()
                .body("petId", is( storeOrder.getPetId()))
                .statusCode(200);
        return response.extract().path("id");
    }

    @Step
    public void deleteStoreOrderById (int id){
        given()
                .delete(DELETE_ORDER, id)
                .then()
                .body("type", is ("unknown"))
                .statusCode(200);
    }

}
