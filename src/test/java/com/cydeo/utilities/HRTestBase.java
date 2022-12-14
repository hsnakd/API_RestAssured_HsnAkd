package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public abstract class HRTestBase {
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
//        baseURI = "http://3.86.235.137::1000";

        baseURI = "http://3.86.235.137";
        port = 1000;
        basePath ="/ords/hr";

        //get ip address from configurations
        String dbUrl = "jdbc:oracle:thin:@3.86.235.137:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

      //  DBUtils.createConnection(dbUrl,dbUsername,dbPassword);
    }

    @AfterAll
    public static void teardown(){

        //DBUtils.destroy();
    }
}
