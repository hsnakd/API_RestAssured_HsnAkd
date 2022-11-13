package com.cydeo.week1;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class SpartanTest {
    /** ipAddress */
    String ipAddress = "3.86.235.137";
    /** endPoint */
    String endPoint = "/api/spartans";
    String baseUrl = "http://" + ipAddress + ":8000" + endPoint;

    @Test
    public void bodyValidation(){
        //send a get request and save response inside the Response object
        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get(baseUrl);

        System.out.println("response.body().asString().contains(\"Nels\") = " +
                            response.body().asString().contains("Nels"));

    }

    @Test
    public void getHeaders(){
        //send a get request and save response inside the Response object
        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get(baseUrl);


        System.out.println("response.getHeaders() = " + response.getHeaders());


    }
    @Test
    public void getHeadersList(){
        //send a get request and save response inside the Response object
        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get(baseUrl);


        List<Headers> headers = Collections.singletonList(response.headers());
        System.out.println("headers.toString() = " + headers.toString());

    }
    @Test
    public void hasHeader(){
        //send a get request and save response inside the Response object
        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get(baseUrl);


        System.out.println("response.headers().hasHeaderWithName(\"Content-Type\") = " + response.headers().hasHeaderWithName("Content-Type"));
        System.out.println("response.headers().hasHeaderWithName(\"Connection\") = " + response.headers().hasHeaderWithName("Connection"));

    }

    @Test
    public void headerValue(){
        //send a get request and save response inside the Response object
        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get(baseUrl);

        System.out.println("response.header(\"Date\") = " + response.header("Date"));
        System.out.println("response.header(\"Transfer-Encoding\") = " + response.header("Transfer-Encoding"));
        System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));

    }
}


