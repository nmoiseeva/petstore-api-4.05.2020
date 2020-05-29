import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;


public class PetTests {

    private RequestSpecification given (){
     return RestAssured.
                given()
                .contentType("application/json")
                .log().all()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType("application/json");

    }

    @Test
    public void getPetById(){
     given()
                .get(PetEndpoint.GET_PET)
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void createPet (){
       given()
               .body("{\n" +
                       "\"id\":1,\n" +
                       "\"category\":{\n" +
                       "\"id\":1,\n" +
                       "\"name\":\"CatName\"\n" +
                       "},\n" +
                       "\"name\":\"CatName\",\n" +
                       "\"photoUrls\":[\n" +
                       "\"string\"\n" +
                       "],\n" +
                       "\"tags\":[\n" +
                       "{\n" +
                       "\"id\":1,\n" +
                       "\"name\":\"CatName\"\n" +
                       "}\n" +
                       "],\n" +
                       "\"status\":\"available\"\n" +
                       "}")
                .post(PetEndpoint.CREATE_PET, 1).
                then().log().body().
                body("id", equalTo(1)).
                statusCode(200);
    }

    @Test
    public void updatePet (){
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
                .post("/pet").
                then().log().body().
                assertThat().
                body("id", equalTo(1)).
                body("name", equalTo("Cat")).
                statusCode(200);
    }

    @Test
    public void deletePetById(){
        given()
                .delete("/pet/1")
                .then()
                .log().all()
                .body("message", equalTo("1"))
                .statusCode(200);

    }

    @Test
    public void getPetById2(){
        int petId = 666;
       given()
                .get(PetEndpoint.GET_PET, petId)
                .then()
                .log().all()
                .body("id", anyOf (is (1), is (petId)))
                .statusCode(200);
    }


}
