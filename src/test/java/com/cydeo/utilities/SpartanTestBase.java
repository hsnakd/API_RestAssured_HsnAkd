package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanTestBase {
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
        /** ipAddress */
        String ipAddress = "3.86.235.137";
        baseURI = "http://" + ipAddress + ":8000";

        String dbUrl = "jdbc:oracle:thin:@" + ipAddress + ":1521:xe";
        String dbUsername = "SP";
        String dbPassword = "SP";

        DBUtils.createConnection(dbUrl,dbUsername,dbPassword);
    }

    @AfterAll
    public static void teardown(){

        //DBUtils.destroy();
    }



}
