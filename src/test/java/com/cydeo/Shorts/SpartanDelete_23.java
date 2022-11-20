package com.cydeo.Shorts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

// short23 ==> 23 - DELETE Request
public class SpartanDelete_23 {
    @BeforeClass
    public void setup (){
        baseURI = "http://3.86.235.137:8000";
    }

    @Test
    public void deleteRequest(){

           given().pathParam("id", 112)
                .when().delete("/api/spartans/{id}")
                .then().assertThat().statusCode(204);


        given().pathParam("id", 112)
                .when().delete("/api/spartans/{id}")
                .then().assertThat().statusCode(404);


    }



}
