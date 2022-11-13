package com.cydeo.week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class CydeoGetRequest {

    String baseUrl = "https://api.training.cydeo.com";

    @Test
    public void getAllStudents(){

        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get(baseUrl + "/student/all");

        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        System.out.println("response.contentType() = " + response.contentType());

        response.prettyPrint();

    }

    @Test
    public void getByStudentId(){

        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get(baseUrl + "/student/14");

        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        System.out.println("response.contentType() = " + response.contentType());

        response.prettyPrint();

    }
    @Test
    public void getAllTeachers(){

        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get(baseUrl + "/teacher/all");

        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        System.out.println("response.contentType() = " + response.contentType());

        response.prettyPrint();

    }
}
