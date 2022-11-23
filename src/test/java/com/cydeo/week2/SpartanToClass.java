package com.cydeo.week2;

import com.cydeo.week2.pojo.Search;
import com.cydeo.week2.pojo.Spartan;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class SpartanToClass {

    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.87.65.105:8000";
    }

    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/15");

        Spartan spartan15 = response.as(Spartan.class);
//        System.out.println(spartan15);

        System.out.println(spartan15.getName());
        Assertions.assertEquals("Meta",spartan15.getName());
        Assertions.assertEquals(15,spartan15.getId());
        Assertions.assertEquals("Female",spartan15.getGender());
    }

//    @Test
//    public void test2(){
//        Response response = given().accept(ContentType.JSON)
//                .when().get("/api/spartans");
//
//        AllSpartans spartans = response.as(AllSpartans.class);
//
//        System.out.println(spartans);
//    }

    @Test
    public void test3(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("nameContains","m")
                .when().get("/api/spartans/search");

        Search searchByName = response.as(Search.class);
        System.out.println(searchByName);
//        response.prettyPrint();

    }

    @Test
    public void test4(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("nameContains","m")
                .when().get("/api/spartans/search");
        JsonPath jsonPath = response.jsonPath();

        Spartan spartan2 = jsonPath.getObject("content[1]", Spartan.class);
        System.out.println(spartan2);

    }
}
