import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetTests {

    @Test
    public void getPetById(){
        given()
                .log().all()
                .baseUri("https://petstore.swagger.io/v2")
                .get("/pet/1")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void createPet (){
        String bodyJson = "{\n" +
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
                "}";

        RequestSpecification request = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .build();

        given(request).body(bodyJson).contentType(ContentType.JSON).log().all().
                when().post("/pet").
                then().log().body().
                body("id", equalTo(1)).
                statusCode(200);
    }

    @Test
    public void updatePet (){
        String bodyJson = "{\n" +
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
                "}";

        RequestSpecification request = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .build();

        given(request).body(bodyJson).contentType(ContentType.JSON).log().uri().
                when().post("/pet").
                then().log().body().
                assertThat().
                body("id", equalTo(1)).
                body("name", equalTo("Cat")).
                statusCode(200);
    }

    @Test
    public void deletePetById(){
        given()
                .log().all()
                .baseUri("https://petstore.swagger.io/v2")
                .delete("/pet/1")
                .then()
                .log().all()
                .body("message", equalTo("1"))
                .statusCode(200);

    }
}
