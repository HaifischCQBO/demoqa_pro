package tests.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ActivityApi {

    public void setBaseUri(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    public Response getRandomActivity() {
        String url = RestAssured.baseURI + "/api/activity";
        System.out.println("Request URL: " + url);
        return given()
                .when()
                .get(url);
    }

    public Response getActivityByType(String type) {
        String url = RestAssured.baseURI + "/api/activity";
        System.out.println("Request URL: " + url + "?type=" + type);
        return given()
                .queryParam("type", type)
                .when()
                .get(url);
    }

    public Response getActivityByParticipants(int participants) {
        String url = RestAssured.baseURI + "/api/activity";
        System.out.println("Request URL: " + url + "?participants=" + participants);
        return given()
                .queryParam("participants", participants)
                .when()
                .get(url);
    }
}
