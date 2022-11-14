package com.cydeo.Shorts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class SpartanTestsPOJODeserialization {
    @BeforeClass
    public void setUpClass(){
        baseURI = "http://3.86.235.137:8000";
    }

    @Test
    public void test1(){
        // request part
        Response response =
                 given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when().get("/api/spartans/{id}");

        // hot to convert json response to our spartan class
        Spartan spartan1 = response.body().as(Spartan.class);

        System.out.println("spartan1.toString() = " + spartan1.toString());

        assertEquals(spartan1.getId(), 15);
        assertEquals(spartan1.getName(), "Meta");
        assertEquals(spartan1.getGender(), "Female");
        assertEquals(spartan1.getPhone(), 1938695106);
    }

    @Test
    public void gsonExample(){
        // request part
        Response response =
                given().accept(ContentType.JSON)
                        .pathParam("id", 15)
                        .when().get("/api/spartans/{id}");

        // hot to convert json response to our spartan class
        Spartan spartan1 = response.body().as(Spartan.class);

        System.out.println("spartan1.toString() = " + spartan1.toString());

        assertEquals(spartan1.getId(), 15);
        assertEquals(spartan1.getName(), "Meta");
        assertEquals(spartan1.getGender(), "Female");
        assertEquals(spartan1.getPhone(), 1938695106);
    }

}
