package com.cydeo.week1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;

public class PathMethod {


    String id = "/{id}";
    @BeforeAll
    public static void init(){
        baseURI = "http://3.86.235.137:8000/api/spartans";
    }


    @Test
    public void test1(){

        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get("10");

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.path(\"id\").toString() = " + response.path("id").toString());
        System.out.println("response.path(\"name\").toString() = " + response.path("name").toString());
        System.out.println("response.path(\"gender\").toString() = " + response.path("gender").toString());
        System.out.println("response.phone(\"name\").toString() = " + response.path("phone").toString());


        int id = response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");

        Assertions.assertEquals(id, 10);
        Assertions.assertEquals(gender, "Female");

    }

    @Test
    public void test2(){

        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .when().get();

//        List<Integer> ids = response.path("id");
//        System.out.println(ids);
//
//        List<Integer> names = response.path("name");
//        System.out.println(names);

        System.out.println("response.path(\"name[0]\").toString() = " + response.path("name[0]").toString());
        System.out.println("response.path(\"phone[10]\".toString()) = " + response.path("phone[10]").toString());
        System.out.println("response.path(\"gender[-10]\").toString() = " + response.path("gender[-10]").toString());
        System.out.println("response.path(\"name[-10]\").toString() = " + response.path("name[-10]").toString());
    }

    @Test
    public void test3(){

        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .and().queryParam("gender","Male")
                .when().get("/search");

    List<String> genders = response.path("content.gender");
    Assertions.assertEquals(genders.get(15),"Male");
    Assertions.assertEquals("53", response.path("totalElement").toString());


    }

}


