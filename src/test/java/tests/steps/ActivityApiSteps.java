package tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import tests.pages.ActivityApi;

public class ActivityApiSteps {

    private ActivityApi activityApi = new ActivityApi();
    private Response response;

    @Given("I have the Bored API base URI")
    public void setBaseUri() {
        activityApi.setBaseUri("https://www.boredapi.com");
    }

    @When("I request a random activity")
    public void requestRandomActivity() {
        response = activityApi.getRandomActivity();
    }

    @When("I request an activity with type {string}")
    public void requestActivityWithType(String type) {
        response = activityApi.getActivityByType(type);
    }

    @When("I request an activity with {int} participants")
    public void requestActivityWithParticipants(int participants) {
        response = activityApi.getActivityByParticipants(participants);
    }

    @Then("The response status code is {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, response.statusCode());
    }

    @Then("The response contains an activity")
    public void verifyResponseContainsActivity() {
        Assertions.assertNotNull(response.jsonPath().getString("activity"));
    }

    @Then("The response contains an activity of type {string}")
    public void verifyResponseContainsActivityOfType(String type) {
        Assertions.assertEquals(type, response.jsonPath().getString("type"));
    }

    @Then("The response contains an activity with {int} participants")
    public void verifyResponseContainsActivityWithParticipants(int participants) {
        Assertions.assertEquals(participants, response.jsonPath().getInt("participants"));
    }
}