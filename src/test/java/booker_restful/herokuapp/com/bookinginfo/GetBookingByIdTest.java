package booker_restful.herokuapp.com.bookinginfo;

import booker_restful.herokuapp.com.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBookingByIdTest extends TestBase {
    @Test
    public void getBookingIds() {

        Response response = given()
                .pathParam("id", 1287)
                .when()
                .get("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    }
