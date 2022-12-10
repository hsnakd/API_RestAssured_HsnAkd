package com.cydeo.Shorts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class PathMethod_11_12 {

    @BeforeAll
    public static void init(){
        baseURI = "http://3.86.235.137";
        port = 8000;
    }

    @Test
    public void Test(){
        Response response = //RestAssured. (import static io.restassured.RestAssured.*;)
                            given().accept(ContentType.JSON)
                            .and().pathParam("id", 10)
                            .when().get("/api/spartans/{id}");


        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());

        System.out.println("response.body().path(\"id\").toString() = " + response.body().path("id").toString());
        System.out.println("response.body().path(\"name\").toString() = " + response.body().path("name").toString());
        System.out.println("response.body().path(\"gender\").toString() = " + response.body().path("gender").toString());
        System.out.println("response.body().path(\"phone\").toString() = " + response.body().path("phone").toString());

    }

    @Test
    public void Test1(){
        Response response = //RestAssured. (import static io.restassured.RestAssured.*;)
                given().accept(ContentType.JSON)
                        .and().pathParam("id", 10)
                        .when().get("/api/spartans/{id}");


        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());

        int id = response.body().path("id");
        String name = response.body().path("name");
        String gender = response.body().path("gender");
        long phone = response.body().path("phone");

        Assertions.assertEquals(id,10);
        Assertions.assertEquals(name,"Lorenza");
        Assertions.assertEquals(gender,"Female");
        Assertions.assertEquals(phone,3312820936l);
    }


    @Test
    public void Test2(){
        Response response = get("/api/spartans");

        int id = response.path("id[9]");
        String name = response.path("name[9]");
        String gender = response.body().path("gender[9]");
        long phone = response.body().path("phone[9]");

        System.out.println("Tenth Spartan's Info : " + id + ", " + name + ", " + gender  + ", " + phone);


        List<String> names = response.path("name");
        System.out.println("names = " + names);
        System.out.println("names.size() = " + names.size());

    }


}
