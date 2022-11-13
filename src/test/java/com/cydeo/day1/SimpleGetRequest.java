package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {
    /** ipAddress */
    String ipAddress = "3.86.235.137";
    /** endPoint */
    String endPoint = "/api/spartans";
    String url = "http://" + ipAddress + ":8000" + endPoint;

    @Test
    public void test1(){
        //send a get request and save response inside the Response object
        Response response = RestAssured.get(url);

        //print response status code
        System.out.println(response.statusCode());

        //print response body
//        response.body().prettyPrint();
        response.prettyPrint();

    }


    @Test
    public void test2(){
        Response response = RestAssured.get(url);

        Assertions.assertEquals(200, response.statusCode());
        //body should contain Allen
        Assertions.assertTrue(response.body().asString().contains("Allen"));
    }


    @Test
    public void test3(){
        // Given accept type is json
        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get(url);


        Assertions.assertEquals(200, response.statusCode());

        // verify response body json
        Assertions.assertEquals("application/json",response.contentType());

    }

}
