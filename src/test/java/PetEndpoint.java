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

    public Long createPet(String body, String PetName){
       ValidatableResponse response = given()
                .body(body)
                .post(CREATE_PET).
                then().log().all()
                .body("name", is( PetName))
                .statusCode(200);
       return response.extract().path("id");
    }

    public void updatePet (String body, String PetName){
        ValidatableResponse response = given()
                .body(body)
                .put(UPDATE_PET).
                then().log().all()
                .body("name", is( PetName))
                .statusCode(200);
    }

    public void deletePetById (Long petId){
        given()
                .delete(DELETE_PET, petId)
                .then()
                .log().all()
                .body("type", is ("unknown"))
                .statusCode(200);
    }


}
