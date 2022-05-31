package booker_restful.herokuapp.com.bookinginfo;

import booker_restful.herokuapp.com.model.BookingPojo;
import booker_restful.herokuapp.com.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateAuthTest extends TestBase {
    @Test
    public void createAuthentication() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setUsername("admin");
        bookingPojo.setPassword("password123");

        Response response = (Response) given()
                .header("Content-Type", "application/json")
                .body(bookingPojo)
                .when()
                .post("/auth");
        response.then().statusCode(200);
        response.prettyPrint();



    }
}
// "token": "7e8dde07f81e406"