package Day1;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Auth {
  @Test(enabled=false)
  public void f() {
	  given().proxy("192.168.100.1",8081)
	   .auth()
	   .oauth2("5e9c5fac201df9862f9aa05a484135c86d2826d2")
	   .when()
	    .post("http://coop.apps.symfonycasts.com/api/427/chickens-feed")
	   .then()
	    .statusCode(200);
	
  }
  @Test
  public void f2() {
	Response r =given().proxy("192.168.100.1",8081)
    .formParam("client_id", "DemoApp1")
    .formParam("client_secret", "2b506d9b966cda66a25cf5f3df01f8c7") 		
    .formParam("grant_type","client_credentials")
	   .when()
	    .post("http://coop.apps.symfonycasts.com/token");
System.out.println(r.jsonPath().prettify());
String token=r.jsonPath().get("access_token");
System.out.println("Token is"+token);

given().proxy("192.168.100.1",8081)
.auth()
.oauth2(token)
.when()
 .post("http://coop.apps.symfonycasts.com/api/ 427/chickens-feed")
.then()
 .statusCode(200);

  }
}
