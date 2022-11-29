package com.cydeo.week3.pojoPractice;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private int addressId;
    private String street;
    private String city;
    private String state;
    private int zipCode;
}
