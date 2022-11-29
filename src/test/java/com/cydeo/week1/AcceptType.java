package com.cydeo.week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class AcceptType {

    String baseUrl = "http://54.167.52.69:8000/api/spartans";

    @Test
    public void acceptType(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseUrl);
        System.out.println("response.statusCode() = " + response.statusCode());
//        response.prettyPeek();
        System.out.println("response.contentType() = " + response.contentType());
    }

    @Test
    public void getASpartan(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseUrl + "/25");

        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.contentType() = " + response.contentType());

        response.prettyPrint();
    }

    @Test
    public void getHello(){
        Response response = RestAssured
                .when().get("http://54.167.52.69:8000/api/hello");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }
}
