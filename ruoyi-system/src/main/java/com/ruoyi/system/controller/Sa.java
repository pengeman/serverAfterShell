package com.ruoyi.system.controller;

import org.json.JSONObject;

public class Sa {
    public static void main(String[] args) {
        org.json.JSONObject jsonObject = new org.json.JSONObject();
        String jsonStr = "{\"name\":\"John\", \"age\":30}";
//        jsonObject = new jsonObject(jsonStr);
        jsonObject = new JSONObject(jsonStr);

        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        int r1 = 0 ;
        int r2 = 0;
        System.out.println(" r1 & r2 : ");
        System.out.println(r1 & r2);
    }
}
