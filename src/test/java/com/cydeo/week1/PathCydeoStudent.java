package com.cydeo.week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;

public class PathCydeoStudent {



    @BeforeAll
    public static void init(){
        baseURI = "https://api.training.cydeo.com/";
    }


    @Test
    public void test1(){

        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get("/student/15");

        System.out.println("response.statusCode() = " + response.statusCode());

        response.prettyPrint();

        String id = response.path("students.studentId").toString();
        Assertions.assertEquals("[15]", id);

        String name = response.path("students.firstName").toString();
        Assertions.assertEquals("[Leopold]", name);
    }



}


