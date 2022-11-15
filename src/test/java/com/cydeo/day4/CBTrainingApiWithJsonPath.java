package com.cydeo.day4;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;

public class CBTrainingApiWithJsonPath {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
//        baseURI = "http://api.cybertektraining.com";
        baseURI = "https://api.training.cydeo.com";


    }

    @DisplayName("GET Request to individual student")
    @Test
    public void test1(){
        //send a get request to student id 23401 as a path parameter and accept header application/json
        //verify status code=200 /content type=application/json;charset=UTF-8 /Content-Encoding = gzip
        //verify Date header exists
        //assert that

            /*
                firstName Vera
                batch 14
                section 12
                emailAddress aaa@gmail.com
                companyName Cydeo
                state IL
                zipCode 60606

                using JsonPath



        //send a get request to student id 15 as a path parameter and accept header application/json
        // verify status code=200
        // content type=application/json;charset=UTF-8
        // transfer-encoding = chunked
        //verify Date header exists
        //assert that


{
    "students": [
        {
            "studentId": 5,
            "firstName": "Bill",
            "lastName": "Qoper",
            "batch": 13,
            "joinDate": "03/28/2022",
            "birthDate": "03/11/1999",
            "password": "testr4564564",
            "subject": "Agile",
            "gender": "Male",
            "admissionNo": "123",
            "major": "Soft skills",
            "section": "100000",
            "contact": {
                "contactId": 4,
                "phone": "345345345345",
                "emailAddress": "bill@email.com",
                "permanentAddress": "3456 test"
            },
            "company": {
                "companyId": 5,
                "companyName": "Cydeo",
                "title": "Dev",
                "startDate": "03/29/2022",
                "address": {
                    "addressId": 5,
                    "street": "23442 Test ave",
                    "city": "McLean",
                    "state": "VA",
                    "zipCode": 345345
                }
            }
        }
    ]
}
             */
        Response response = get("/student/all");

        //get the 3rd (studentId : 5) student name with JsonPath

        //to use jsonpath we assign response to JsonPath
        JsonPath jsonPath = response.jsonPath();

        String firstName = jsonPath.getString("students[3].firstName");
        String studentId = jsonPath.getString("students[3].studentId");
        String batch = jsonPath.getString("students[3].batch");
        String section = jsonPath.getString("students[3].section");
        String emailAddress = jsonPath.getString("students[3].contact.emailAddress");
        String companyName = jsonPath.getString("students[3].company.companyName");
        String state = jsonPath.getString("students[3].company.address.state");
        String zipCode = jsonPath.getString("students[3].company.address.zipCode");
        System.out.println("firstName = " + firstName);
        System.out.println("studentId = " + studentId);
        System.out.println("batch = " + batch);
        System.out.println("section = " + section);
        System.out.println("emailAddress = " + emailAddress);
        System.out.println("companyName = " + companyName);
        System.out.println("state = " + state);
        System.out.println("zipCode = " + zipCode);


        System.out.println("statusCode() = " + response.statusCode());
        System.out.println("contentType() = " + response.contentType());
        System.out.println("response.getHeader(\"transfer-encoding\") = " + response.getHeader("transfer-encoding"));
        System.out.println("response.getHeader(\"date\") = " + response.getHeader("date"));

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("application/json;charset=UTF-8", response.contentType());
        Assertions.assertEquals("chunked", response.getHeader("transfer-encoding"));
        Assertions.assertTrue(response.headers().hasHeaderWithName("date"));


    }
}
