package com.cydeo.Shorts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;


public class SpartanTestsWithPathMethod {
    @BeforeClass
    public void setUpClass(){
        baseURI = "http://3.86.235.137:8000";
    }

    @Test
    public void test1(){
        Response response =
                given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .when().get("/api/spartans/{id}");


        assertEquals(response.statusCode(), 200);

        assertEquals(response.contentType(), "application/json");


        System.out.println("response.body().path(\"id\") = " + response.body().path("id"));
        System.out.println("response.path(\"name\") = " + response.path("name"));
        System.out.println("response.path(\"gender\") = " + response.path("gender"));
        System.out.println("response.path(\"phone\") = " + response.path("phone"));

        int id = response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");

        assertEquals(id,10);
        assertEquals(name,"Lorenza");
        assertEquals(gender,"Female");
        assertEquals(phone,3312820936l);




    }



    @Test
    public void test2(){
        Response response = get("/api/spartans");

        int firstId = response.path("id[0]");
        System.out.println("firstId = " + firstId);

        String firstFirstName = response.path("name[0]");
        System.out.println("firstFirstName = " + firstFirstName);

        String lastFirstName = response.path("name[-1]");
        System.out.println("lastFirstName = " + lastFirstName);

        //extract all firstNames and print them
        List<String> names = response.path("name");
        System.out.println("names = " + names);
        System.out.println("names.size() = " + names.size());


        List<Object> phoneNumbers = response.path("phone");
        System.out.println("phoneNumbers = " + phoneNumbers);
        System.out.println("phoneNumbers.size() = " + phoneNumbers.size());




    }



}
