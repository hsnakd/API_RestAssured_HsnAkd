package com.cydeo.week1;

import io.restassured.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

public class FirstTest {
    /** ipAddress */
    String ipAddress = "3.86.235.137";
    /** endPoint */
    String endPoint = "/api/spartans";
    String baseUrl = "http://" + ipAddress + ":8000" + endPoint;

    @Test
    public void test1(){
        //send a get request and save response inside the Response object
        Response response = RestAssured.get(baseUrl);

        //print response status code
        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.prettyPeek() = " + response.prettyPeek());

        //print response body
//        response.body().prettyPrint();
        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        Assertions.assertEquals(200,response.statusCode());
    }


}
