package com.example.danielkwok.recycleviewapp;

import org.json.JSONException;
import org.json.JSONObject;

public class Person {
    private int id;
    private String name;
    private int age;

    public Person(){
        this.id++;
        this.name = "John Doe";
        this.age = 0;
    }

    public Person(String name, int age){
        this.id++;
        this.name = name;
        this.age = age;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toJSON(){
        JSONObject jsonObject= new JSONObject();
        try {
            jsonObject.put("id", getId());
            jsonObject.put("name", getName());
            jsonObject.put("age", getAge());

            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }
}
