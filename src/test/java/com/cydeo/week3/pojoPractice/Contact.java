package com.cydeo.week3.pojoPractice;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

    private int contactId;
    private String phone;
    private String emailAddress;
    private String permanentAddress;
}
