import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.CoreMatchers.is;

public class PetEndpoint {

    public static final String CREATE_PET = "/pet";
    public static final String UPDATE_PET = "/pet";
    public static final String DELETE_PET = "/pet/{petId}";
    public static final String GET_PET = "/pet/{petId}";


    public RequestSpecification given (){
        return RestAssured.
                given()
                .contentType("application/json")
                .log().all()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType("application/json");
    }

    public void getPetById(Long petId){
        given()
                .get(GET_PET, petId)
                .then()
                .log().all()
                .body("id", is (petId))
                .statusCode(200);
    }

    public Long createPet(String body){
       ValidatableResponse response = given()
                .body(body)
                .post(CREATE_PET).
                then().log().all()
                //.body("name", is( "cat")) //ToDo fix assert
                .statusCode(200);
       return response.extract().path("id");
    }

    public void updatePet (String body){
        given()
                .body(body)
                .put(UPDATE_PET).
                then().log().all()
                //.body("name", is( "cat")) //ToDo fix assert
                .statusCode(200);
    }

    public void deletePetById (Long petId){
        given()
                .delete(DELETE_PET, petId)
                .then()
                .log().all()
                .statusCode(200);
    }


}
