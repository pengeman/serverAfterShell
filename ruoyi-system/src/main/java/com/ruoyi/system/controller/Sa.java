package com.ruoyi.system.controller;

import com.ruoyi.common.exception.UtilException;
import com.ruoyi.common.utils.StringUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Sa {
    public static void m1(String[] args) {
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
    public static void m2(){
        List list = new ArrayList<String>();
        String name = "123123";
        list.add(name);
        System.out.println(list);
        name = "456456";
        System.out.println(list);
    }

    public static void filterKeyword(String value)
    { String SQL_REGEX = "and |extractvalue|updatexml|exec |drop |count |chr |mid |master |truncate |char |declare |or |+|user()";
         String SQL_REGEX2 = "insert |select |delete |update |drop";

        if (StringUtils.isEmpty(value))
        {
            return;
        }
        String[] sqlKeywords = StringUtils.split(SQL_REGEX, "\\|");
        for (String sqlKeyword : sqlKeywords)
        {
            if (StringUtils.indexOfIgnoreCase(value, sqlKeyword) > -1)
            {
                throw new UtilException("参数存在SQL注入风险, or 参数存在关键字冲突:" + sqlKeyword);
            }
        }
        sqlKeywords = StringUtils.split(SQL_REGEX2, "\\|");
        int value1 = StringUtils.ordinalIndexOf(value,"|",1);
        value = StringUtils.substring(value,0,value1);
        for (String sqlKeyword : sqlKeywords){
            if (StringUtils.indexOfIgnoreCase(value, sqlKeyword) > -1)
            {
                throw new UtilException("参数存在SQL注入风险, or 参数存在关键字冲突:" + sqlKeyword);
            }
        }
    }
    public static void main(String[] args) {
        filterKeyword("insert into xxx");
    }
}
