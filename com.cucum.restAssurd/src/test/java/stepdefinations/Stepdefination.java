package stepdefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class Stepdefination extends Utils {

	RequestSpecification res1;
	Response res2;
	Response respons;
	static String placeid; //because it is asking from first scenarios place_id  and in 2nd scenarios res1, res2 all will become null so when we will give static it will hold the value

	@Given("Add place payload with {string} {string} {string}")
	public  void add_place_payload_with(String name, String language, String address) throws IOException {

		res1 = given().spec(requestSpecification()).body(TestDataBuild.addPlacePayload(name, language, address));
	}

	@When("user call's {string} with {string} http request")
	public void user_call_s_with_http_request(String methodresource, String httpmethod) {
		APIResources resourceAPI = APIResources.valueOf(methodresource);
		System.out.println(resourceAPI.getResource());

		ResponseSpecification res =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();
		if (httpmethod.equalsIgnoreCase("POST"))
			res2 = res1.when().post(resourceAPI.getResource());
		else if (httpmethod.equalsIgnoreCase("GET"))
			res2 = res1.when().get(resourceAPI.getResource());

		respons = res2.then().spec(res).extract().response();

	}

	@Then("The API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {

		assertEquals(respons.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {

		assertEquals(getJsonPath(respons, keyValue), ExpectedValue);
	}

	@Then("verify {string} created maps to {string} using {string} with {string} method")                                          // "GetPlaceAPI"
	public void verify_created_maps_to_using_with_method(String responseKeyvalue, String expectedname, String methodresource,
			String method) throws IOException {

		 placeid = getJsonPath(respons, responseKeyvalue);
		res1 = given().spec(requestSpecification()).queryParam(responseKeyvalue, placeid);
		user_call_s_with_http_request(methodresource, method);
		String actualname = getJsonPath(respons, "name");
		assertEquals(actualname, expectedname);
		
	}
	@Given("delete place payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res1 = given().spec(requestSpecification()).body(TestDataBuild.DeletePlacePayload(placeid));
	}


}
