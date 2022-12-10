package com.cydeo.Shorts;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class RestAssuredFirstTest_7 {

    String baseUrl = "http://3.86.235.137";
    String port = ":8000";
    String endPoint = "/api/spartans";
    String basePath = "/api/spartans";
    String idNumber = "";

    String baseURI = baseUrl + port + endPoint;


    @Test
    public void viewSpartanTest1(){
        Response response = RestAssured.get(baseURI);
        System.out.println("statusCode = " + response.statusCode());

        int statusCode = response.statusCode();
        System.out.println("statusCode = " + statusCode);

        System.out.println("response.body().asString() = " + response.body().asString());
        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());
    }
}
