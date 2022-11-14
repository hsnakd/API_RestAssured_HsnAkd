package com.cydeo.Shorts;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;



public class SpartanTestsWithHamcrest {
    @BeforeClass
    public void setUpClass(){
        baseURI = "http://3.86.235.137:8000";
    }

    @Test
    public void test1(){
        // request part
                given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when().get("/api/spartans/{id}")
       // response part
                .then().statusCode(200)
                .and().assertThat().contentType("application/json");

    }


    @Test
    public void test2(){
        // request part
        given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when().get("/api/spartans/{id}")
                // response part
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", Matchers.equalTo(15),
                        "name", Matchers.equalTo("Meta"),
                                              "gender", Matchers.equalTo("Female"),
                                              "phone", Matchers.equalTo(1938695106) );

    }




}
