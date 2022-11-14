package com.cydeo.Shorts;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class SpartanTestsWithJsonPath {
    @BeforeClass
    public void setUpClass(){
        baseURI = "http://3.86.235.137:8000";
    }

    @Test
    public void test1(){
        Response response =
                given().accept(ContentType.JSON)
                .pathParam("id", 11)
                .when().get("/api/spartans/{id}");

        assertEquals(response.statusCode(), 200);

        // how to read value with path() method
        int id = response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");

        assertEquals(id,11);
        assertEquals(name,"Nona");
        assertEquals(gender,"Female");
        assertEquals(phone,7959094216l);

        // how to read value with JsonPath
        JsonPath jsonData = response.jsonPath();


        int id1 = jsonData.getInt("id");
        String name1 = jsonData.getString("name");
        String gender1 = jsonData.getString("gender");
        long phone1 = jsonData.getLong("phone");

        System.out.println("id1 = " + id1);
        System.out.println("name1 = " + name1);
        System.out.println("gender1 = " + gender1);
        System.out.println("phone1 = " + phone1);

        assertEquals(id1,11);
        assertEquals(name1,"Nona");
        assertEquals(gender1,"Female");
        assertEquals(phone1,7959094216l);

    }






}
