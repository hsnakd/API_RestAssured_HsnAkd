package com.cydeo.week3.pojoPractice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class StudentToPojo {

    @BeforeAll
    public static void setUp(){
        baseURI = "https://api.training.cydeo.com";
    }

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id",15)
                .when().get("/student/{id}");

        System.out.println(response.statusCode());

        Student student15 = response.as(Student.class);
        System.out.println(student15);
//        System.out.println(student15.getFirstName());
    }
}
