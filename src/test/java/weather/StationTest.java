package weather;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class StationTest {

    private static final String  OPEN_WEATHER_API = "http://api.openweathermap.org/data/3.0/stations";

    @io.cucumber.java.en.Given("^A list of stations$")
    public void aListOfStations() {
    }
    @And("I perform POST without API Key")
    public void iPerformPOSTWithoutAPIKey() {
        JSONObject request = new JSONObject();
        request.put("external_id","DEMO_TEST001");
        request.put("name","Team Demo Test Station 001");
        request.put("latitude", 33.33);
        request.put("longitude",-122.43);
        request.put("altitude",222);

        given()
                .contentType(JSON)
                .queryParam("id","524901")
                .body(request.toJSONString())
                .when()
                .post(OPEN_WEATHER_API)
                .then()
                .log()
                .all()
                .statusCode(401)
                .body("cod",is(401))
                .body("message",is("Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."));
    }

    @Then("I get error response")
    public void iGetErrorResponse() {
    }

    @And("I register First new stations")
    public void iRegisterFirstNewStation() {
        JSONObject request = new JSONObject();
        request.put("external_id","DEMO_TEST001");
        request.put("name","Team Demo Test Station 001");
        request.put("latitude", 33.33);
        request.put("longitude",-122.43);
        request.put("altitude",222);

        given()
                .contentType(JSON)
                .queryParam("id","524901")
                .queryParam("appid","9405a8e518b158387fbba22ae510a14e")
                .body(request.toJSONString())
                .when()
                .post(OPEN_WEATHER_API)
                .then()
                .log()
                .all()
                .statusCode(201);

    }
    @And("I register Second new stations")
    public void iRegisterSecondNewStation() {
        JSONObject request = new JSONObject();
        request.put("external_id","DEMO_TEST002");
        request.put("name","Team Demo Test Station 002");
        request.put("latitude", 44.44);
        request.put("longitude",-122.43);
        request.put("altitude",111);

        given()
                .contentType(JSON)
                .queryParam("id","524901")
                .queryParam("appid","9405a8e518b158387fbba22ae510a14e")
                .body(request.toJSONString())
                .when()
                .post(OPEN_WEATHER_API)
                .then()
                .log()
                .all()
                .statusCode(201);

    }

    @And("I Perform get all stations and verify")
    public void iPerformGetAllStationsAndVerify() {
        RestAssured.given()
                .queryParam("id","524901")
                .queryParam("appid","9405a8e518b158387fbba22ae510a14e")
                .when()
                .get(OPEN_WEATHER_API)
                .then()
                .statusCode(200)
                .body("external_id",hasItem("DEMO_TEST001"))
                .body("external_id",hasItem("DEMO_TEST002"));
    }

}

