package com.company;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
//Clasa implementeaza un document
public class Document implements Serializable {
    private String id;
    private String name;
    private String location;//file name or Web page

    private Map<String, Object> tags = new HashMap<String, Object>();//documentul va avea o cheie unica + un diferit tip(object)

    public Document(String java1, String s, String s1) {
        this.id=java1;
        this.name=s;
        this.location=s1;
    }

    public String getId() {
        return id;
    }

    public void addTag(String key, Object obj){
        tags.put(key,obj);
    } //adauga un nou tag

    public String getLocation() {
        return location;
    }
}
