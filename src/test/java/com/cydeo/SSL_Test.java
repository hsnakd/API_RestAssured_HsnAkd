package com.cydeo;

import static io.restassured.RestAssured.given;

public class SSL_Test {
    public void test1 (){
        given() 
                .relaxedHTTPSValidation()
                .when().get("https://untrusted-root.badssl.com")
                .prettyPrint();
    }

    public void keyStore(){
        given()
                .keyStore("pathoffile", "password")
                .when().get("myapi");
    }
}
