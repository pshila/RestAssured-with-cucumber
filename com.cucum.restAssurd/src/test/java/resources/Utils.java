package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	static Properties prop;
	public static RequestSpecification res;

	public static RequestSpecification requestSpecification() throws IOException {
		if (res == null) {
			PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
			
			res =new RequestSpecBuilder().setBaseUri(getGlobleValue("baseUrl"))
					.setContentType(ContentType.JSON).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return res;
		}
		return res;
	}

	public static String getGlobleValue(String key) throws IOException {
		prop =new Properties();
		FileInputStream fis =new FileInputStream(
				"C:\\Users\\shila\\eclipse-api\\com.cucum.restAssurd\\src\\test\\java\\resources\\globle.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}
	
	public String getJsonPath(Response response, String key) {
		String response1=response.asString();
		 JsonPath js=new JsonPath(response1);
		 return js.get(key).toString();
		
	}

}
