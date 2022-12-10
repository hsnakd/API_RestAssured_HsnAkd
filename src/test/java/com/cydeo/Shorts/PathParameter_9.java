package com.cydeo.Shorts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class PathParameter_9 {

    @BeforeAll
    public static void init(){
        baseURI = "http://3.86.235.137";
        port = 8000;



    }




    @Test
    public void pathParamTest(){
        Response response = RestAssured
                            .given().accept(ContentType.JSON)
                            .and().pathParam("id", 18)
                            .when().get("/api/spartans/{id}");


        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        Assert.assertEquals(200, response.statusCode());

        Assert.assertEquals("application/json", response.contentType());

        Assertions.assertTrue(response.body().asString().contains("Allen"));

    }

    @Test
    public void negativePathParamTest(){
        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .and().pathParam("id", 500)
                .when().get("/api/spartans/{id}");


        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        Assert.assertEquals(404, response.statusCode());

        Assert.assertEquals("application/json", response.contentType());

        Assertions.assertTrue(response.body().asString().contains("Not Found"));

    }


}
