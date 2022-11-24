package com.cydeo.day8;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class BookItTest {
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";
    }

    //create BookItUtil then create a method, that accepts email and password return token Bearer + yourToken as a String
    String accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs";


    @DisplayName("GET all campuses")
    @Test
    public void testAuth1(){
        //how to pass bearer token for bookit ? use header method to give as key value header
      given().
                header("Authorization",accessToken)
                .and().accept(ContentType.JSON)
        .when()
                .get("/api/campuses")
        .then()
                .statusCode(200)
                .log().all();

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

        {
             "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs",
             "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs"
         }

 *******************************************************

 https://cybertek-reservation-api-qa.herokuapp.com/sign?email=blyst6@si.edu&password=barbabaslyst

 teacher_email           blyst6@si.edu
 teacher_password        barbabaslyst

 {
 "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs",
 "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs"
 }

 *******************************************************

 */



/* old ones
//        baseURI = "https://cybertek-reservation-api-docs.herokuapp.com";


//    String accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMzkiLCJhdWQiOiJzdHVkZW50LXRlYW0tbGVhZGVyIn0._vM1-eRoS7SsHu6T-QPdJoEdA8LSwnxUvvTTbhV-8ms";
//    String accessToken = "Bearer eeyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4MiIsImF1ZCI6InN0dWRlbnQtdGVhbS1tZW1iZXIifQ.zIcFXhVng5REMvXmUGrJRSPMp87ImMqxVoM6ofeDpZA";

 */

/**

 The bookit api uses the following error codes:

 Error Code     Name                        Meaning
 400            Bad Request	                your request is invalid.
 401	        Unauthorized	            your authorization token is wrong.
 403	        Forbidden	                the resource requested is hidden for you.
 404	        Not Found	                the specified resource could not be found.
 409	        Conflict	                indicates that the request could not be processed because of conflict in the current state of the resource.
 422	        Unprocessable Entity	    your request structure is right, but something wrong with info you're passing to the service.
 429	        Too Many Requests	        you're requesting too many resources, slow down.
 500	        Internal Server Error	    we had a problem with our server, try again later.

 */