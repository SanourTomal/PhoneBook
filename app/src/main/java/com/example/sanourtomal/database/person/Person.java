package com.example.sanourtomal.database.person;

/**
 * Created by Sanour Tomal on 2/11/2017.
 */

public class Person {
    private String id;
    private String name;
    private String phnNum;

    public Person(String name,String phnNum) {
        this.name = name;
        this.phnNum = phnNum;

    }

    public Person(String id, String name, String phnNum) {
        this.id=id;
        this.name = name;
        this.phnNum = phnNum;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhnNum() {
        return phnNum;
    }

    public void setPhnNum(String phnNum) {
        this.phnNum = phnNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
