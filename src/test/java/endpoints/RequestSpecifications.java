package endpoints;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import static config.ConfigProperties.BASE_URL;

public class RequestSpecifications {

    static {
        SerenityRest.filters(new RequestLoggingFilter(LogDetail.ALL));
        SerenityRest.filters(new ResponseLoggingFilter(LogDetail.ALL));
    }

    public RequestSpecification given (){
        return SerenityRest
                .given()
                .contentType("application/json")
                .baseUri(BASE_URL);
    }
}
