import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import static io.restassured.RestAssured.basePath;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnixTimestampConverterTests {

    private static final String API_BASE_URL = "http://helloacm.com";
    private static final String API_BASE_PATH = "/api/unix-timestamp-converter/";
    public static Headers headers = new Headers(
            new Header("User-Agent", "")

    );

    @BeforeEach
    public void setUp(){
        RestAssured.baseURI = API_BASE_URL;
        basePath = API_BASE_PATH;

    }

    @ParameterizedTest
    @MethodSource("convertUnixTimestampToDateParameters")
    public void testConvertUnixTimestampToDate(String unixTimestamp, String date) {

        // Send a GET request using RestAssured
        String response = RestAssured
                .given()
                .headers(headers)
                .queryParam("cached", "null") // Add query parameters as needed
                .queryParam("s", unixTimestamp)
                .get()
                .then()
                .statusCode(200).extract().asString();

        // Assert the response body matches the expected date string
        assertEquals(date, response.replaceAll("\"",""));

    }

    @ParameterizedTest
    @MethodSource("convertDateToUnixTimestampParameters")
    public void testConvertDateToUnixTimestamp(String date) throws ParseException {
        // Define the date format for parsing
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date getDate = dateFormat.parse(date);
        long timestamp = getDate.getTime() / 1000L;


        // Send a GET request using RestAssured
        String response = RestAssured
                .given()
                .headers(headers)
                .queryParam("cached", "null") // Add query parameters as needed
                .queryParam("s", date)
                .get()
                .then()
                .statusCode(200)
                .extract()
                .asString();


        // Assert the response body matches the expected date string
        assertEquals(timestamp, Long.parseLong(response));


    }
    private static Stream<Arguments> convertDateToUnixTimestampParameters() {
        return Stream.of(
                Arguments.of( "2037-04-12 04:25:23"),
                Arguments.of( "1969-08-24 12:12:49"),
                Arguments.of( "1969-08-24 48:99:49")
        );
    }

    private static Stream<Arguments> convertUnixTimestampToDateParameters() {
        return Stream.of(
                Arguments.of("2123123123", "2037-04-12 04:25:23"),
                Arguments.of("-11231231", "1969-08-24 12:12:49"),
                Arguments.of("asdasdasd", "false")
        );
    }

}