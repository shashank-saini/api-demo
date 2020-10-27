package Automation.RestApiFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class getDetailsApi {

		@Test
		public void test() {

			Response response = RestAssured.get("https://reqres.in/api/users?page=2");
			System.out.println(response.statusCode());
			System.out.println(response.asString());
			System.out.println(response.getBody().asString());
			System.out.println(response.statusLine());

			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);

		}
		@Test
		public void test1() {

			given().get("https://reqres.in/api/users?page=2").then().
			statusCode(200).
			body("data.id[0]", equalTo(7));

		}
		@Test
		public void test2() {

			given().get("https://reqres.in/api/users?page=2").then().
			statusCode(200).
			body("data.id[1]", equalTo(8)).
			body("data.first_name", hasItems("Byron","Fields")).
			log().all();
		}
	

	}

