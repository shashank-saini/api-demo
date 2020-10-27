package Automation.RestApiFramework;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class postDetailsApi {

		@Test
		public void test2() {

			JSONObject request = new JSONObject();
			request.put("name", "shashank");
			request.put("job", "Software Engineer");

			System.out.println(request);
			System.out.println(request.toString());

			given().
			body(request.toJSONString()).
			when().
			post("https://reqres.in/api/users").
			then().statusCode(201 );

		}

	}
