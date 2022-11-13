package com.cydeo.Shorts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SpartanTestsWithQueryParams {
    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI = "http://3.86.235.137:8000";
    }

    @Test
    public void PathTest1(){
        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .and().pathParam("id", 18)
                .when().get("/api/spartans/{id}");

        assertEquals(response.statusCode(), 200);

        assertEquals(response.contentType(), "application/json");

        assertTrue(response.body().asString().contains("Allen"));

        response.body().prettyPrint();


    }



    @Test
    public void negativePathParamTest(){
        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .and().pathParam("id", 500)
                .when().get("/api/spartans/{id}");


        assertEquals(response.statusCode(), 404);

        assertEquals(response.contentType(), "application/json");

        assertTrue(response.body().asString().contains("Not Found"));

        response.body().prettyPrint();


    }



}
