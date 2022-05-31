package booker_restful.herokuapp.com.bookinginfo;

import booker_restful.herokuapp.com.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends TestBase {
    @Test
    public void deleteBooking(){
        Response response = (Response) given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Authorisation","YWRtaW46cGFzc3dvcmQxMjM=]")
                .header("Cookie","token=cce7ea74c94f244")


                .pathParam("id",369)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
