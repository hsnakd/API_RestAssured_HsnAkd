package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public abstract class SpartanAuthTestBase {
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
//        baseURI = "http://3.86.235.137:8000";
        baseURI = "http://3.86.235.137";
        port = 8000;
        basePath ="";
    }
}
