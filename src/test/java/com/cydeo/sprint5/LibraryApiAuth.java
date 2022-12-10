package com.cydeo.sprint5;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LibraryApiAuth {


    public static Header token = new Header("x-library-token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7ImlkIjoiMTAwNjEiLCJmdWxsX25hbWUiOiJUZXN0IExpYnJhcmlhbiAyIiwiZW1haWwiOiJsaWJyYXJpYW4yQGxpYnJhcnkiLCJ1c2VyX2dyb3VwX2lkIjoiMiJ9LCJpYXQiOjE2NzAwMTM3NzksImV4cCI6MTY3MjYwNTc3OX0.9feRBQzJZFJqfL3Ti9rieRb8CH5fpfY5e64hg5Wun7g");
    public static Map<String,Object> book1 = new LinkedHashMap<>();

    @BeforeAll
    public static void logWithCredentials(){
        baseURI = "http://library1.cydeo.com/rest/v1/";
        //henuz post u yapamadım, ama get ile bu sekilde automation yapabildim.

        book1.put("name","intellijden");
        book1.put("isbn","121");
        book1.put("year","2002");
        book1.put("author","sen");
        book1.put("book_category_id","3");
        book1.put("description","simplest");
        //Response response =

    }
    @Test
    public void test1(){

        given().accept(ContentType.JSON).
                header(token).
                get("get_book_categories").
                then().log().all().
                statusCode(200).
                contentType(ContentType.JSON);

    }
}