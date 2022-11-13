package com.cydeo.week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class AcceptType {
    /** ipAddress */
    String ipAddress = "3.86.235.137";
    /** endPoint */
    String endPoint = "/api/spartans";
    /** endPoint */
    String id = "/25";
    String baseUrl = "http://" + ipAddress + ":8000" + endPoint;

    @Test
    public void acceptType(){
        //send a get request and save response inside the Response object
        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get(baseUrl);

        System.out.println("response.getStatusCode() = " + response.getStatusCode());
//        response.prettyPeek();

        System.out.println("response.contentType() = " + response.contentType());
    }

    @Test
    public void getASpartan(){
        //send a get request and save response inside the Response object
        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get(baseUrl + id);

        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        System.out.println("response.contentType() = " + response.contentType());
        response.prettyPrint();
    }

    @Test
    public void getHello(){
        Response response = RestAssured
                .when().get("http://3.86.235.137:8000/api/hello");

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.contentType() = " + response.contentType());
        response.prettyPrint();
    }

}
