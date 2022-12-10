package com.cydeo.Shorts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GET_TestCases_8 {

    String baseUrl = "http://3.86.235.137";
    String port = ":8000";
    String endPoint = "/api/spartans";
    String basePath = "/api/spartans";
    String idNumber = "";

    String baseURI = baseUrl + port + endPoint;


    @Test
    public void viewSpartanTest2(){
        Response response = RestAssured.get(baseURI);

        Assert.assertEquals(200, response.statusCode());

        Assert.assertEquals("application/json", response.contentType());

        Assertions.assertTrue(response.body().asString().contains("hsnakd"));
    }

    @Test
    public void viewSpartanTest3(){
        Response response = RestAssured
                            .given().accept(ContentType.JSON)
                            .when().get(baseURI);

        Assert.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());

        Assertions.assertTrue(response.body().asString().contains("hsnakd"));
    }

}
