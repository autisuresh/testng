package apitest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@SuppressWarnings("unchecked")
public class PutPatchDeleteExamples {

    @Test
    public void putTest() {

        JSONObject request = new JSONObject();
        request.put("name","Suresh");
        request.put("job","QA");
        System.out.println(request.toJSONString());

        given()
                .body(request.toJSONString())
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

}
