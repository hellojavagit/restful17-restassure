package booker_restful.herokuapp.com.bookinginfo;

import booker_restful.herokuapp.com.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetbookingIdsTest extends TestBase {

    @Test
    public void getBookingIds(){

        Response response =  given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
