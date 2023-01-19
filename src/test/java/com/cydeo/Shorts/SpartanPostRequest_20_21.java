package com.cydeo.Shorts;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

// short20 ==> 20 - POST Request Rest Assured
public class SpartanPostRequest_20_21 {
    @BeforeClass
    public void setUpClass(){
        baseURI = "http://3.86.235.137:8000";
    }

    /* Given accept type and ContentType is JSON
     And request json body is
        {
            "gender"    : "Male",
            "name"      : "Mike",
            "phone"     : 8877445596
        }
    When user sends POST request to '/api/spartans'
    Then status code 201
    And content type should be application/json
    And json payload/response should contain
    "A spartan is Born!" message and same data what is posted
    */


    @Test
    public void PostWithString(){
        // sending json body as String
         Response response =
                 given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(" {\n" +
                        "            \"gender\"    : \"Male\",\n" +
                        "            \"name\"      : \"Mike\",\n" +
                        "            \"phone\"     : 8877445596\n" +
                        "        }")
                .when().post("/api/spartans/");

         response.prettyPrint();
        // validation
        // verify status code is 201
        assertEquals(201, response.statusCode());
        assertEquals("application/json", response.contentType());

        // verify success message
        assertEquals(response.path("success"), "A Spartan is Born!");
        assertEquals(response.path("data.name"), "Mike");

        // verify request body
        JsonPath json = response.jsonPath();

        assertEquals(json.getString("data.name"), "Mike");
        assertEquals(json.getString("data.gender"), "Male");
        assertEquals(json.getLong("data.phone"), 8877445596l);

    }

    @Test
    public void PostMethodWithMap(){
        //create a map to be as a body for post request
        Map<String, Object> requestMap = new HashMap<>();

        requestMap.put("name", "MikeMAP");
        requestMap.put("gender", "Male");
        requestMap.put("phone", "8877445566");

        Response response =
                given().accept(ContentType.JSON)
                        .and().contentType(ContentType.JSON)
                        .body(requestMap)
                        .when().post("/api/spartans/");

        assertEquals(201, response.statusCode());

        response.prettyPrint();

    }

    // Short21 ==> 21 - POST Request Serialization
    @Test
    public void PostWithPojo(){
        Spartan spartan = new Spartan();
        spartan.setName("MikePOJO_131");
        spartan.setGender("Male");
        spartan.setPhone(1234567890l);

        Response response =
                given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(spartan)
                .when().post("/api/spartans/");

        assertEquals(201, response.statusCode());
        assertEquals("application/json", response.contentType());

        response.prettyPrint();

        // ====================GET REQUEST ======================
        Response response2 =
                given().accept(ContentType.JSON)
                        .pathParam("id", 131)
                        .and().when().get("/api/spartans/{id}");

        Spartan spartanResponse = response2.body().as(Spartan.class);
        System.out.println("spartanResponse.toString() = " + spartanResponse.toString());

    }



}
