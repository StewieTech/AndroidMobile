package com.example.fetchapp;

public class School {
    String name ;
    String stateProvince ;
    String webPage ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public School(String name, String stateProvince, String webPage) {
        this.name = name;
        this.stateProvince = stateProvince;
        this.webPage = webPage;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", webPage='" + webPage + '\'' +
                '}';
    }
}
