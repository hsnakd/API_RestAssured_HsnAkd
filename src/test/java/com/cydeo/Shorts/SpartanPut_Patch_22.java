package com.cydeo.Shorts;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

// short22 ==> 22 - PUT Request
public class SpartanPut_Patch_22 {
    @BeforeClass
    public void setup (){
        baseURI = "http://3.86.235.137:8000";
    }

    @Test
    public void putRequest(){
        // we gonna send request body with updated value, and content type header

        Map<String, Object> putMap = new HashMap<>();

        putMap.put("name", "Mike_PUT_Mike");
        putMap.put("gender", "Male");
        putMap.put("phone", 8877445562l);


           given().contentType(ContentType.JSON)
                .and().pathParam("id", 107)
                .and().body(putMap)
                .when().put("/api/spartans/{id}")
                .then().assertThat().statusCode(204);



    }


    @Test
    public void patchRequest(){
        // we gonna send request body with updated value, and content type header

        Map<String, Object> patchMap = new HashMap<>();

        patchMap.put("name", "Mike_PATCH_Mike");



        given().contentType(ContentType.JSON)
                .and().pathParam("id", 108)
                .and().body(patchMap)
                .when().patch("/api/spartans/{id}")
                .then().assertThat().statusCode(204);



    }

}
