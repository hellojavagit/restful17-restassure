package booker_restful.herokuapp.com.bookinginfo;

import booker_restful.herokuapp.com.model.BookingPojo;
import booker_restful.herokuapp.com.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateBookingTest extends TestBase {

    @Test
    public void createBooking(){
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("jim");
        bookingPojo.setLastname("brown");
        bookingPojo.setTotalprice(999);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setAdditionalneeds("Breakfast");
        HashMap<Object,Object> bookingdates = new HashMap<>();
        bookingdates.put("check in ","2018-01-01");
        bookingdates.put("checkout","2019-01-01");
        bookingPojo.setBookingdates(bookingdates);


        Response response = (Response) given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Cookie","token : fe11fc742c7fdbc")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.prettyPrint();
        response.then().statusCode(200);


    }

}
