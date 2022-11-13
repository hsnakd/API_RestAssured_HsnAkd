package com.cydeo.week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;

public class Params {



    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
//        /** ipAddress */
//        String ipAddress = "3.86.235.137";
        String endPoint = "/api/spartans";
        baseURI = "http://3.86.235.137:8000" + endPoint;

    }


    @Test
    public void pathParams(){
        String id = "/{id}";

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id",45)
                .when().get(id);

        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();

        Assertions.assertTrue(response.body().asString().contains("Heddie"));
    }

    @Test
    public void getSpartanNegativeTest(){
        String id = "/{id}";

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 4500)
                .when().get(id);

        // when negative testing, the status code is 404
        Assertions.assertEquals(404, response.statusCode());

        // validate error message
        Assertions.assertTrue(response.body().asString().contains("Not Found"));
    }

    @Test
    public void queryParams1(){

        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .and().queryParam("nameContains","z")
                .when().get("/search");

        System.out.println("response.statusCode() = " + response.statusCode());

    }


    @Test
    public void queryParams2(){

        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .and().queryParam("nameContains","c")
                .and().queryParam("gender","Female")
                .when().get("/search");

        System.out.println("response.statusCode() = " + response.statusCode());

        Assertions.assertEquals(200,response.statusCode());


    }

    @Test
    public void queryParams3(){

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("nameContains","c");
        queryMap.put("gender","Female");

        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .and().queryParams(queryMap)
                .when().get("/search");

        System.out.println("response.statusCode() = " + response.statusCode());

        Assertions.assertEquals(200, response.statusCode());

    }

}


