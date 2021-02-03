package com.pascal.util.josn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @auther Pascal
 * @date 2020/12/9 11:36
 */
public class JsonStringFormat {
    public static void main(String[] args) {
        String jsonString = "{\n" +
                "    \"sessionId\": \"111xxzxxxxx\",\n" +
                "    \"ifInvokeTime\": \"YYYY-MM-DD HH:mm:ss\",\n" +
                "    \"ifInvokeName\": \"UpdateAppServices\",\n" +
                "    \"ifInvokeIp\": \"10.1.198.53\",\n" +
                "    \"ifName\": \"XXXX\",\n" +
                "    \"ifIp\": \"10.1.198.53\",    \n" +
                "\t\"authenResult\" : \"0\",\n" +
                "    \"ifInputArgs\": \"XXXX\",\n" +
                "    \"ifOutputArgs\": \"XXXX\",\n" +
                "    \"ifInvokeResult\": \"0\",\n" +
                "    \"ifInvokeSource\": \"BOSS\",\n" +
                "    \"ifBeinvokeSsource\": \"Hive\"\n" +
                "}";
        JSONObject jsonObject=JSONObject.parseObject(jsonString);
        String formattedString=jsonObject.toString();
        System.out.println(formattedString);

        String jsonArrayResult="[]";
        JSONArray jsonArray = JSON.parseArray(jsonArrayResult);
        //System.out.println(jsonArray);
        JSONObject params=new JSONObject();
        params.put("sessionId","111xxzxxxxx");
        params.put("ifInvokeTime","2021-02-22 12:12:12");
        params.put("ifInvokeName","UpdateAppServices");
        params.put("ifInvokeIp","10.1.198.53");
        params.put("ifName","10.1.198.53");
        params.put("ifIp","111xxzxxxxx");
        params.put("authenResult","0");
        params.put("ifInputArgs","111xxzxxxxx");
        params.put("ifOutputArgs","111xxzxxxxx");
        params.put("ifInvokeResult","0");
        params.put("ifInvokeSource","BOSS");
        params.put("ifBeinvokeSsource","Hive");


    }
}
