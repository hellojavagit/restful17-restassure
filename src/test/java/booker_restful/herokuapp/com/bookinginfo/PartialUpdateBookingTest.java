package booker_restful.herokuapp.com.bookinginfo;

import booker_restful.herokuapp.com.model.BookingPojo;
import booker_restful.herokuapp.com.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PartialUpdateBookingTest extends TestBase {
    @Test
    public void  partialUpdateBooking() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("jimmys");
        bookingPojo.setLastname("browns");
        Response response = (Response) given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Authorisation","YWRtaW46cGFzc3dvcmQxMjM=]")
                .header("Cookie","token=cce7ea74c94f244")
                .pathParam("id",1234)
                .body(bookingPojo)
                .when()
                .patch("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}