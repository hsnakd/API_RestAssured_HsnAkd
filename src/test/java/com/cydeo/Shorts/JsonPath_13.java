package com.cydeo.Shorts;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class JsonPath_13 {

    @BeforeAll
    public static void init(){
        baseURI = "http://3.86.235.137";
        port = 8000;
    }

    @Test
    public void Test(){
        Response response =
                            given().accept(ContentType.JSON)
                            .and().pathParam("id", 10)
                            .when().get("/api/spartans/{id}");


        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());

        JsonPath jsonPathData = response.jsonPath();

        int id = jsonPathData.getInt("id");
        String name = jsonPathData.getString("name");
        String gender = jsonPathData.getString("gender");
        long phone = jsonPathData.getLong("phone");

        System.out.println("Tenth Spartan's Info : " + id + ", " + name + ", " + gender  + ", " + phone);

        Assertions.assertEquals(10, id);
        Assertions.assertEquals("Lorenza", name);
        Assertions.assertEquals("Female", gender);
        Assertions.assertEquals(3312820936l, phone);

    }


}
