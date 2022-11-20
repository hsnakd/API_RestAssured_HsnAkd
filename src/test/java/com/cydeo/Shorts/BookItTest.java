package com.cydeo.Shorts;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookItTest {
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";

    }

    //create BookItUtil then create a method, that accepts email and password return token Bearer +yourToken as a String

    String accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs";

    @DisplayName("GET all campuses")
    @Test
    public void testAuth1(){
        //how to pass bearer token for bookit ? use header method to give as key value header
      Response response =
              given().header("Authorization",accessToken)
        .when().get("/api/campuses");


      assertEquals(200, response.statusCode());
      response.prettyPrint();

    }


}

/**
 Related environments or credentials for API day7,8 and BookIt app:

 API
 QA1    api.qa.bookit.cydeo.com
 QA2    api.qa2.bookit.cydeo.com
 QA3    api.qa3.bookit.cydeo.com
 Swagger    https://cybertek-reservation-api-docs.herokuapp.com/

 UI
 QA1    qa.bookit.cydeo.com
 QA2    qa2.bookit.cydeo.com
 QA3    qa3.bookit.cydeo.com

 Database
 Host    room-reservation-qa.cxvqfpt4mc2y.us-east-1.rds.amazonaws.com
 Port    5432
 User    qa_user
 Password    Cybertek11!
 database type   PostgreSQL

 Credentials
 teacher_email    blyst6@si.edu
 teacher_password    barbabaslyst
 team_member_email    raymond@cydeo.com
 team_member_password    abs123
 team_leader_email    lfinnisz@yolasite.com
 team_leader_password    lissiefinnis

 https://cybertek-reservation-api-qa.herokuapp.com/sign?email=blyst6@si.edu&password=barbabaslyst

 {
 "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs",
 "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs"
 }




 emaynell8f@google.es
 besslebond
 */