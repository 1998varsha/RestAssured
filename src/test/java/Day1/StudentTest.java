package Day1;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

public class StudentTest {
  @Test
  public void getCall() {
given()
	  .when()
	     .get("http://localhost:9090/student/list")
	  .then()
	    .statusCode(200);
Response r=given()
                        .when()
                        .get("http://localhost:9090/student/2");
System.out.println(r.prettyPrint().toString());
String fname = r.jsonPath().get("firstName");
Assert.assertEquals(fname, "Murphy");
System.out.println(r.getTime());

  }
  @Test
  public void deleteCall() {
	  given()
	  .when()
	     .get("http://localhost:9090/student/list")
	  .then()
	    .statusCode(200);
Response r=given()
                        .when()
                        .delete("http://localhost:9090/student/100");
System.out.println(r.prettyPrint().toString());
System.out.println(r.getTime());

  }
/*  @Test
  public void postCall() {
	  ArrayList<String> courses=new ArrayList<String>();
	  courses.add("Digital Communication");
	  courses.add("Computer Networking");
	  courses.add("Software Testing");
	  
	  Student st=new Student();
	  st.setFirstName("Mohit");
	  st.setLastName("Sharma");
	  st.setEmail("mohit99@gmail.com");
	  st.setProgramme("ENTC");
	  st.setCourses(courses);
	  
	  given()
	      .contentType(ContentType.JSON)
	      .when()
	      .body(st)
	      .post("http://localhost:9090/student")
	      .then()
	  .statusCode(201);  
  }*/
  @Test
  public void putCall() {
	  ArrayList<String> courses=new ArrayList<String>();
	  courses.add("Digital Communication");
	  courses.add("Computer Networking");
	  courses.add("Software Testing");
	  
	  Student st=new Student();
	  st.setFirstName("Mohit");
	  st.setLastName("Sharma");
	  st.setEmail("mohit99@gmail.com");
	  st.setProgramme("IT");
	  st.setCourses(courses);
	  
	  given()
	      .contentType(ContentType.JSON)
	      .when()
	      .body(st)
	      .put("http://localhost:9090/student/102")
	      .then()
	  .statusCode(200);
	  
  }
}

