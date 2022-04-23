package apitest;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

@SuppressWarnings("unchecked")
public class GetAndPostExamples {

    @BeforeClass
    public void setUp() {
        baseURI = "https://reqres.in/api";
    }
    @Test
    public void getTest(){

        given()
                .get("/users?page=2")
        .then()
                .statusCode(200)
                .body("data[4].first_name",equalTo("George"))
                .body("data.first_name",hasItems("George","Rachel"));
    }

    @Test
    public void postTest() {

        JSONObject request = new JSONObject();
        request.put("name","Suresh");
        request.put("job","QA");
        System.out.println(request.toJSONString());

        given()
                .body(request.toJSONString())
        .when()
                .post("/users")
        .then()
                .statusCode(201)
                .log().all();
    }
}
