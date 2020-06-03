import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PetTests{
    PetEndpoint petEndpoint = new PetEndpoint();

    @Test
    public void get(){
        String body = "{\n" +
                "\"id\":0,\n" +
                "\"category\":{\n" +
                "\"id\":1,\n" +
                "\"name\":\"Cat\"\n" +
                "},\n" +
                "\"name\":\"Cat\",\n" +
                "\"photoUrls\":[\n" +
                "\"string\"\n" +
                "],\n" +
                "\"tags\":[\n" +
                "{\n" +
                "\"id\":1,\n" +
                "\"name\":\"Cat\"\n" +
                "}\n" +
                "],\n" +
                "\"status\":\"available\"\n" +
                "}";

        Long petId = petEndpoint.createPet(body);
        petEndpoint.getPetById(petId);
        petEndpoint.deletePetById(petId);
    }


    @Test
    public void test2_GetPetById(){
        int petId = 1;
        given()
                .get(PetEndpoint.GET_PET, petId)
                .then()
                .log().all()
                .body("id", is (petId))
                .statusCode(200);
    }

    @Test
    public void test3_UpdatePet (){
        int petId = 1;
        given()
                .body("{\n" +
                        "\"id\":1,\n" +
                        "\"category\":{\n" +
                        "\"id\":1,\n" +
                        "\"name\":\"Cat\"\n" +
                        "},\n" +
                        "\"name\":\"Cat\",\n" +
                        "\"photoUrls\":[\n" +
                        "\"string\"\n" +
                        "],\n" +
                        "\"tags\":[\n" +
                        "{\n" +
                        "\"id\":1,\n" +
                        "\"name\":\"Cat\"\n" +
                        "}\n" +
                        "],\n" +
                        "\"status\":\"available\"\n" +
                        "}")
                .post(PetEndpoint.UPDATE_PET).
                then().log().body().
                assertThat().
                body("id", is (petId)).
                body("name", is ("Cat")).
                statusCode(200);
        test5_DeletePetById();
    }


    @Test
    public void test4_GetPetById2(){
        int petId = 666;
       given()
                .get(PetEndpoint.GET_PET, petId)
                .then()
                .log().all()
                .body("id", anyOf (is (1), is (petId)))
                .statusCode(200);
    }

    @Test ()
    public void test5_DeletePetById (){
        int petId = 1;
        given()
                .delete(PetEndpoint.DELETE_PET, petId)
                .then()
                .log().all()
                .body("message", equalTo("1"))
                .statusCode(200);
    }


}
