import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
        public RequestSpecification given (){
            return RestAssured.
                    given()
                    .contentType("application/json")
                    .log().all()
                    .baseUri("https://petstore.swagger.io/v2")
                    .contentType("application/json");
    }


    @AfterMethod
    public void afterMethod() {

    }


}
