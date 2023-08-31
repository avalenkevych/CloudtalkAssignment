import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnixTimestampConverterTests {

    private static final String BASE_URL = "https://helloacm.com/api/unix-timestamp-converter/?cached&s=";

    @Test
    public void testConvertUnixTimestampToDate() {
        long unixTimestamp = 951357;
        String expectedDate = "\"1970-01-12 12:15:57\"";

        String actualResponse =
                given()
                        .when()
                        .get(BASE_URL + unixTimestamp)
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        assertEquals(expectedDate, actualResponse);
    }

    @Test
    public void testConvertNegativeUnixTimestampToDate() {
        long unixTimestamp = -3600;
        String expectedDate = "1969-12-31 23:59:00";

        String actualResponse =
        given()
                .pathParam("timestamp", unixTimestamp)
                .when()
                .get(BASE_URL + "{timestamp}")
                .then()
                .statusCode(200)
                .extract()
                .asString();

        assertEquals(expectedDate, actualResponse);

    }


}