package Steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitions {

	public StepDefinitions() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
	}

	@Given("I test post using {string}")
	public void i_test_post_using(String string) {
		RequestSpecification request = RestAssured.given();
		request.header("Content-type", "application/json");
		JsonObject user = new JsonObject();
		user.add("id", "4");
		user.add("name", "tesla");
		user.add("username", "mikelia");
		request.body(user.toString());
		Response response = request.post(string);

		Assert.assertEquals(201, response.getStatusCode());
		Assert.assertTrue(response.jsonPath().get("name").toString().contains("tesla"));
		Assert.assertTrue(response.jsonPath().get("username").toString().contains("mikelia"));

	}

	@When("I test get1 using {string}")
	public void i_test_get1_using(String string) {
		RequestSpecification request = RestAssured.given();
		Response response = request.get(string);
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertTrue(response.jsonPath().get("name").toString().equals("Leanne Graham"));
	}

	@Then("I test get5 using {string}")
	public void i_test_get5_using(String string) {
		RequestSpecification request = RestAssured.given();
		Response response = request.get(string);

		List<String> users = response.jsonPath().getList("username");
		List<String> actualNewUsers = users.subList(0, 5);
		List<String> expectedUsers = new ArrayList<String>();
		expectedUsers.add("Bret");
		expectedUsers.add("Antonette");
		expectedUsers.add("Samantha");
		expectedUsers.add("Karianne");
		expectedUsers.add("Kamren");

		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertArrayEquals(expectedUsers.toArray(), actualNewUsers.toArray());

	}
}