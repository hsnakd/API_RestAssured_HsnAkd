package com.cydeo.Shorts;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;


public class SpartanTestsWithQueryParams {
    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI = "http://3.86.235.137:8000";
    }

    @Test
    public void queryParam1(){
        Response response =
                given().accept(ContentType.JSON)
                .queryParam("gender", "Female")
                .queryParam("nameContains", "J")
                .when().get("/api/spartans/search");


        assertEquals(response.statusCode(), 200);

        assertEquals(response.contentType(), "application/json");

        assertTrue(response.body().asString().contains("Female"));

        assertFalse(response.body().asString().contains("Male"));

        assertTrue(response.body().asString().contains("Janette"));

        response.body().prettyPrint();


    }

    @Test
    public void queryParams2(){
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("gender", "Female");
        paramsMap.put("nameContains", "J");


        Response response =
                given().accept(ContentType.JSON)
                        .queryParam("gender", "Female")
                        .queryParam("nameContains", "J")
                        .when().get("/api/spartans/search");

        assertEquals(response.statusCode(), 200);

        assertEquals(response.contentType(), "application/json");

        assertTrue(response.body().asString().contains("Female"));

        assertFalse(response.body().asString().contains("Male"));

        assertTrue(response.body().asString().contains("Janette"));

        response.body().prettyPrint();



    }





}
