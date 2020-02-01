package resources;
import java.util.ArrayList;
import java.util.List;
import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public static AddPlace addPlacePayload(String name, String language, String address) {

		AddPlace p =new AddPlace();
		p.setAccuracy(60);
		p.setName(name);
		p.setLanguage(language);
		p.setPhone_number("6789654378");
		p.setAddress(address);
		p.setWebsite("http://gmkai.com");

		List<String> mylist =new ArrayList<String>();
		mylist.add("Deer");
		mylist.add("Rabbit");
		p.setTypes(mylist);

		Location l =new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		p.setLocation(l);
		return p;
	}
	
	public static String DeletePlacePayload(String placeid) {
		return "{\r\n" + 
				"    \"place_id\":\""+placeid+"\"\r\n" + 
				"}\r\n" + 
				"";
		
	}

}
