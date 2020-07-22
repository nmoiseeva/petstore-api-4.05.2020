package endpoints;

import io.restassured.response.ValidatableResponse;
import models.PetModels.Pet;
import models.PetModels.Status;
import net.thucydides.core.annotations.Step;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;


public class PetEndpoint extends RequestSpecifications{


    public static final String CREATE_PET = "/pet";
    public static final String UPDATE_PET = "/pet";
    public static final String DELETE_PET = "/pet/{petId}";
    public static final String GET_PET = "/pet/{petId}";
    public static final String GET_PET_BY_STATUS = "/pet/findByStatus";
    public static final String UPLOAD_PET_IMAGE = "/pet/{petId}/uploadImage";


    @Step
    public void getPetById(Long petId){
        given()
                .get(GET_PET, petId)
                .then()
                .body("id", is (petId))
                .statusCode(200);
    }

    @Step
    public void getPetByStatus(Status status){
        given()
                .param("status", status)
                .get(GET_PET_BY_STATUS)
                .then()
               // .body("[0].status", is (status.toString())) //ToDo verify each status in array
                .body("status", everyItem( is (status.toString())))
               // .body("findAll {it -> it.status == '%s'}", status.toString())
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
                .put(UPDATE_PET)
                .then()
                .body("name", is( pet.getName()))
                .statusCode(200);
    }

    @Step
    public void uploadPetImage (Long petId, String relativeFilePass){
        File filePic = new File(getClass().getResource(relativeFilePass).getFile());
        given()
                .contentType("multipart/form-data")
                .multiPart(filePic)
                .post(UPLOAD_PET_IMAGE, petId)
                .then()
                .body("message", containsString(filePic.getName()))
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
