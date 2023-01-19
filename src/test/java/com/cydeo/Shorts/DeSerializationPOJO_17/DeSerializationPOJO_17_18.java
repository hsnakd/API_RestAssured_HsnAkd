package com.cydeo.Shorts.DeSerializationPOJO_17;

import com.cydeo.Shorts.Spartan;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class DeSerializationPOJO_17_18 {
    @BeforeClass
    public void setUpClass(){
        baseURI = "http://3.86.235.137";
        port = 8000;
    }

    @Test
    public void test1(){
        Response response =
                given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .when().get("/api/spartans/{id}");

        // how to convert json response to our spartan class
        Spartan spartan = response.as(Spartan.class);
        System.out.println("spartan.toString() = " + spartan.toString());

        assertEquals(spartan.getId(), 10);
        assertEquals(spartan.getName(), "Lorenza");
        assertEquals(spartan.getGender(), "Female");
        assertEquals(spartan.getPhone(), 3312820936l);

    }




    @Test
    public void gsonExample(){
        Gson gson = new Gson();
        String myJsonBody =
                "{\n" +
                        "    \"id\": 10,\n" +
                        "    \"name\": \"Lorenza\",\n" +
                        "    \"gender\": \"Female\",\n" +
                        "    \"phone\": 3312820936\n" +
                        "}";

        // Using gson method do de serialize our json body
        Spartan spartan = gson.fromJson(myJsonBody, Spartan.class);

        System.out.println("spartanMeta.toString() = " + spartan.toString());


        // serialization  ( Java object ==> JSON BODY )

        Spartan spartan2 = new Spartan(131, "HSNAKD", "Male", 5555555555l);

        // converting custom class to json (serialization)
        String jsonBody = gson.toJson(spartan2);
        System.out.println(jsonBody);
    }





    @Test
    public void gsonExample2(){
        // request part
        Response response =
                given().accept(ContentType.JSON)
                .pathParam("id", 131)
                .when().get("/api/spartans/{id}");

        response.prettyPrint();


    }

}
