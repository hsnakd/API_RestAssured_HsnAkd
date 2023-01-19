package com.cydeo.Shorts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class DeSerialization_15_16 {

    @BeforeAll
    public static void init(){
        baseURI = "http://3.86.235.137";
        port = 8000;
    }

    @Test
    public void Test(){
        // request part
        Response response =
                 given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .when().get("/api/spartans/{id}");

        Map<String, Object> spartanMap = response.body().as(Map.class);

        System.out.println("spartanMap.get(\"id\") = " + spartanMap.get("id"));
        System.out.println("spartanMap.get(\"name\") = " + spartanMap.get("name"));

        Assertions.assertEquals("Lorenza", spartanMap.get("name"));

    }



    @Test
    public void Test2(){
        // request part
        Response response =
                 given().accept(ContentType.JSON)
                .when().get("/api/spartans");


        // convert full json body to list of map
        List<Map<String, Object>> listOfSpartans = response.body().as(List.class);

        // print all data of tenth spartan
        System.out.println("listOfSpartans.get(0) = " + listOfSpartans.get(9));

        // print each data of tenth spartan
        Map<String, Object> tenthSpartan = listOfSpartans.get(9);
        System.out.println("tenthSpartan.get(\"id\") = " + tenthSpartan.get("id"));
        System.out.println("tenthSpartan.get(\"name\") = " + tenthSpartan.get("name"));
        System.out.println("tenthSpartan.get(\"gender\") = " + tenthSpartan.get("gender"));
        System.out.println("tenthSpartan.get(\"phone\") = " + tenthSpartan.get("phone"));

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        //
        int counter = 1;
        for (Map<String, Object> map : listOfSpartans) {
            System.out.println(map);
            counter++;
        }


    }




}
