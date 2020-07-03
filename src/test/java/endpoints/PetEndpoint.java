package endpoints;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.Pet;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;


public class PetEndpoint {

    public static final String CREATE_PET = "/pet";
    public static final String UPDATE_PET = "/pet";
    public static final String DELETE_PET = "/pet/{petId}";
    public static final String GET_PET = "/pet/{petId}";
    public static final String GET_PET_BY_STATUS = "/pet/findByStatus";
    public static final String POST_PET_IMAGE = "/pet/{petId}/uploadImage";

    static {
        SerenityRest.filters(new RequestLoggingFilter(LogDetail.ALL));
        SerenityRest.filters(new ResponseLoggingFilter(LogDetail.ALL));
    }

    public RequestSpecification given (){
        return SerenityRest
                .given()
                .contentType("application/json")
                .baseUri("https://petstore.swagger.io/v2")
                .contentType("application/json");
    }

    @Step
    public void getPetById(Long petId){
        given()
                .get(GET_PET, petId)
                .then()
                .body("id", is (petId))
                .statusCode(200);
    }

    @Step
    public void getPetByStatus(String status){
        given()
                .param("status", status)
                .get(GET_PET_BY_STATUS)
                .then()
                .body("[0].status", is (status)) //ToDo verify each status in array
                .statusCode(200);
    }

    @Step
    public Long createPet(Pet pet){
       ValidatableResponse response = given()
                .body(pet)
                .post(CREATE_PET).
                then()
                .body("name", is( pet.getName()))
                .statusCode(200);
       return response.extract().path("id");
    }


    @Step
    public void updatePet (Pet pet){
       given()
                .body(pet)
                .put(UPDATE_PET).
                then()
                .body("name", is( pet.getName()))
                .statusCode(200);
    }

    @Step
    public void uploadPetImage (Pet pet, String meta, File file){
        given()
                .multiPart(meta, file)
                .body(pet)
                .post(POST_PET_IMAGE)
                .then()
                .statusCode(200);
    }

    @Step
    public void deletePetById (Long petId){
        given()
                .delete(DELETE_PET, petId)
                .then()               
                .body("type", is ("unknown"))
                .statusCode(200);
    }


}
