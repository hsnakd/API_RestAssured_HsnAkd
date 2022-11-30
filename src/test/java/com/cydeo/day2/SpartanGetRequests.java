package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanGetRequests {


//    Given Accept type application/json
//    When user send GET request to api/spartans end point
//    Then status code must 200
//    And response Content Type must be application/json
//    And response body should include spartan result


    String baseUrl = "http://3.86.235.137";
    String port = ":8000";
    String endPoint = "/api/spartans";
    String basePath = "/api/spartans";
    String idNumber = "/3";

    String baseURI = baseUrl + port + endPoint;



    @Test
    public void test1(){


        Response response =  RestAssured.given().accept(ContentType.JSON)
                                        .when()
                                        .get(baseURI);

        //printing status code from response object
        System.out.println("response.statusCode() = " + response.statusCode());

        //printing response content type from response object
        System.out.println("response.contentType() = " + response.contentType());

        //print whole result body
        response.prettyPrint();

        //how to do API testing then ?
        //verify status code is 200
        /** statusCode */
        int statusCode = 200;
        Assertions.assertEquals(response.statusCode(),statusCode);

        //verify content type is application/json
        /** contentType */
        String contentType = "application/json";
        Assertions.assertEquals(response.contentType(),contentType);

    }

     /*
        Given accept header is application/json
        When users sends a get request to /api/spartans/3
        Then status code should be 200
        And content type should be application/json
        and json body should contain Fidole
     */

    @DisplayName("GET one spartan /api/spartans/3 and verify")
    @Test
    public void test2(){


        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get(baseURI + idNumber);


        //verify status code 200
        /** statusCode */
        int statusCode = 200;
        Assertions.assertEquals(statusCode,response.statusCode());

        //verify content type
        /** contentType */
        String contentType = "application/json";
        Assertions.assertEquals(contentType, response.contentType());

        //verify json body contains Fidole
        Assertions.assertTrue(response.body().asString().contains("Fidole"));

    }

    /*
        Given no headers provided
        When Users sends GET request to /api/hello
        Then response status code should be 200
        And Content type header should be “text/plain;charset=UTF-8”
        And header should contain date
        And Content-Length should be 17
        And body should be “Hello from Sparta"
        */

    @DisplayName("GET request to /api/hello")
    @Test
    public void test3(){
        //send request and save response inside the response object
        /** endPoint */
        String endPoint = "/api/hello";
        Response response = RestAssured.when().get(baseUrl + port + endPoint);

        //verify status code 200
        /** statusCode */
        int statusCode = 200;
        Assertions.assertEquals(statusCode,response.statusCode());

        //verify content type
        /** contentType */
        String contentType = "text/plain;charset=UTF-8";
        Assertions.assertEquals(contentType,response.contentType());

        //verify we have headers named date
        //we use hasHeaderWithName method to verify header exist or not - it returns boolean
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

        //how to get any header from response using header key ?
        //we use response.header(String headerName) method to get any header value
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println(response.header("Date"));

        //verify content length is 17
        Assertions.assertEquals("17",response.header("Content-Length"));
        //verify body is "Hello from Sparta"
        Assertions.assertEquals("Hello from Sparta",response.body().asString());
    }
}
