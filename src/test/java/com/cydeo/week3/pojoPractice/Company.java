package com.cydeo.week3.pojoPractice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

    private int companyId;
    private String companyName;
    private String title;
    private String startDate;
    private List<Address> addressList;
}
