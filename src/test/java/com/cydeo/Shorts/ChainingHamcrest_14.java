package com.cydeo.Shorts;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ChainingHamcrest_14 {

    @BeforeAll
    public static void init(){
        baseURI = "http://3.86.235.137";
        port = 8000;
    }

    @Test
    public void Test(){
        // request

                            given().accept(ContentType.JSON)
                            .and().pathParam("id", 10)
                            .when().get("/api/spartans/{id}")
        // response
                            .then().statusCode(200)
                            .and().assertThat().contentType("application/json")
                            .and().assertThat().body(
                        "id", Matchers.equalTo(10),
     "name", Matchers.equalTo("Lorenza"),
                            "gender", Matchers.equalTo("Female"),
                            "phone", Matchers.equalTo(3312820936l));

    }



    @Test
    public void Test2(){
        // request

                given().accept(ContentType.JSON)
                .and().pathParam("id", 10)
                .when().get("/api/spartans/{id}")

        // response
                .then().statusCode(200)
                .and().assertThat().contentType("application/json");

    }




}
