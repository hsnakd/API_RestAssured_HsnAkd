package com.cydeo.week2.pojo;

import java.util.List;

public class AllSpartans {

    private List<Spartan> spartanList;

    public List<Spartan> getSpartanList() {
        return spartanList;
    }

    public void setSpartanList(List<Spartan> spartanList) {
        this.spartanList = spartanList;
    }

    @Override
    public String toString() {
        return "AllSpartans{" +
                "spartanList=" + spartanList +
                '}';
    }
}
