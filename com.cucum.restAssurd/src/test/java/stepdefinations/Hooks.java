package stepdefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	

	@Before("@DeletePlace ")
	 public void beforeScenario() throws IOException {
		Stepdefination sd = new Stepdefination();
		if(Stepdefination.placeid==null) {
		 sd.add_place_payload_with( "Drig", "Bagheli" ,  "Rewa mp");
		 sd.user_call_s_with_http_request( "AddPlaceAPI",  "POST");
		 sd.verify_created_maps_to_using_with_method( "place_id",  "Drig",  "GetPlaceAPI","get");
		}
		 
	 }

}
