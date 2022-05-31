package booker_restful.herokuapp.com.bookinginfo;

import booker_restful.herokuapp.com.model.BookingPojo;
import booker_restful.herokuapp.com.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UpDateBookingTest extends TestBase {
    @Test
    public void updateBooking(){
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("jimmy");
        bookingPojo.setLastname("brown");
        bookingPojo.setTotalprice(999);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setAdditionalneeds("Breakfast");
        HashMap<Object,Object> bookingDates = new HashMap<>();
        bookingDates.put("check in ","2018-01-01");
        bookingDates.put("checkout","2019-01-01");
        bookingPojo.setBookingdates(bookingDates);


        Response response = (Response) given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Authorisation","YWRtaW46cGFzc3dvcmQxMjM=]")
                .header("Cookie","token=cce7ea74c94f244")

                .pathParam("id",3692)
                .body(bookingPojo)
                .when()
                .put("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
