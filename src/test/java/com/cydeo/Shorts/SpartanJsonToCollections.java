package com.cydeo.Shorts;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class SpartanJsonToCollections {
    @BeforeClass
    public void setUpClass(){
        baseURI = "http://3.86.235.137:8000";
    }

    @Test
    public void test1(){
        // request part
         Response response =
                 given().accept(ContentType.JSON)
                .pathParam("id", 11)
                .when().get("/api/spartans/{id}");

        Map<String, Object> spartanMap = response.body().as(Map.class);
        spartanMap.get("id");
        spartanMap.get("name");

        assertEquals(spartanMap.get("name"), "Nona");
    }

    @Test
    public void test2(){
        Gson gson = new Gson();
        String myJsonBody =
                "{\n" +
                "    \"id\": 15,\n" +
                "    \"name\": \"Meta\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"phone\": 1938695106\n" +
                "}";

        // Using gson method do de serialize our json body
        Spartan spartanMeta = gson.fromJson(myJsonBody, Spartan.class);

        System.out.println("spartanMeta.toString() = " + spartanMeta.toString());


        // serialization Java object ==> JSON BODY

        Spartan spartan = new Spartan(101, "Mike", "Male", 321342123l);

        // converting custom class to json (serialization)
        String jsonBody = gson.toJson(spartan);
        System.out.println(jsonBody);
    }



}
