package com.cydeo.day10;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.get;

public class govXmlTest2 {



    @Test
    public void test1(){
        //send a get request to
        //https://data.ct.gov/resource/y6p2-px98.xml
        //get all the "farmer_id"
        //get all "business"
        //get third element's "zipcode"
        //get fifth element's "_address"


        Response response = get("https://data.ct.gov/resource/y6p2-px98.xml")
                            .then().statusCode(200).extract().response();

        XmlPath xmlPath = response.xmlPath();

        //get all the "farmer_id"
        List<Integer> farmer_id = xmlPath.getList("response.rows.row.farmer_id");
        System.out.println("list = " + farmer_id);
        //get all "business"
        List<String> business = xmlPath.getList("response.rows.row.business");
        System.out.println("business = " + business);
        //get third element's "zipcode"
        int zipcode = xmlPath.getInt("response.rows.row[2].zipcode");
        System.out.println("third element's zipcode = " + zipcode);
        //get fifth element's "_address"
        String address2007 = xmlPath.getString("response.rows.row[4].@_address");
        System.out.println("address2007 = " + address2007);


    }
}
