package com.cydeo.Shorts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class QueryParameter_10 {

    @BeforeAll
    public static void init(){
        baseURI = "http://3.86.235.137";
        port = 8000;
    }

    @Test
    public void queryParamTest(){
        Response response = //RestAssured. (import static io.restassured.RestAssured.*;)
                            given().accept(ContentType.JSON)
                            .and().queryParam("gender", "Female")
                            .and().queryParam("nameContains", "J")
                            .when().get("/api/spartans/search");


        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());

        Assertions.assertTrue(response.body().asString().contains("Jeanelle"));

        Assertions.assertTrue(response.body().asString().contains("Female"));

        Assertions.assertFalse(response.body().asString().contains("Male"));

    }

    @Test
    public void queryParamTest2(){
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("gender", "Female");
        paramsMap.put("nameContains", "J");

        // Sent request
        Response response =
                 given().accept(ContentType.JSON)
                .and().queryParams(paramsMap)
                .when().get("/api/spartans/search");


        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());

        Assertions.assertTrue(response.body().asString().contains("Jeanelle"));

        Assertions.assertTrue(response.body().asString().contains("Female"));

        Assertions.assertFalse(response.body().asString().contains("Male"));


    }


}
