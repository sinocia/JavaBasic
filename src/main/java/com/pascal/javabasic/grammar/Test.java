package com.pascal.javabasic.grammar;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @auther Pascal
 * @date 2020/12/9 10:30
 */
public class Test {
    public static void main(String[] args) {
        //log
        String url="http://10.1.192.213:1116/api/v1/interface";

        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        Date date = new Date();
        String time = format.format(date);
        String sId= UUID.randomUUID().toString();
        JSONObject paramsJson=new JSONObject();
        paramsJson.put("sessionId",sId);
        paramsJson.put("ifInvokeTime",time);
        paramsJson.put("ifInvokeName","UpdateAppServices");
        paramsJson.put("ifInvokeIp","10.1.198.53");
        paramsJson.put("ifName","10.1.198.53");
        paramsJson.put("ifIp","111xxzxxxxx");
        paramsJson.put("authenResult","0");
        paramsJson.put("ifInputArgs","111xxzxxxxx");
        paramsJson.put("ifOutputArgs","111xxzxxxxx");
        paramsJson.put("ifInvokeResult","0");
        paramsJson.put("ifInvokeSource","BOSS");
        paramsJson.put("ifBeinvokeSource","Hive");
        String params=paramsJson.toJSONString();
        System.out.println(sId);
        //String params="{\"ifInvokeTime\":\"2021-02-22 12:12:12\",\"ifInputArgs\":\"XXXX\",\"ifIp\":\"10.1.198.53\",\"ifName\":\"XXXX\",\"ifInvokeResult\":\"0\",\"ifInvokeSource\":\"BOSS\",\"sessionId\":\"111xxzxxxxx\",\"ifOutputArgs\":\"XXXX\",\"ifInvokeIp\":\"10.1.198.53\",\"ifInvokeName\":\"UpdateAppServices\",\"authenResult\":\"0\",\"ifBeinvokeSource\":\"Hive\"}\n";
        //1.3需求方案评审发起接口
        //String url = "http://172.30.203.168:13306/api/req/changeManagement/listBjEpicInfo";
        //String params = "{\"systemCode\":\"bggl\"}";
        //1.5 需求关联版本信息查询接口
        //String url = "http://172.30.203.168:13306/api/req/changeManagement/listBjUnReleasedVersionInfo";
        //String params = "{\"systemCode\":\"bggl\"}";
        //1.1 ITC系统查询接口172.30.245.6:37300 http://10.1.234.50:37300
        //String url="http://172.30.245.6:37300/aici/ats/manual/getManualCaseExecLogs";
        //epicId 57145 57130 57128 57125 57122 57109 57107 57104
        //String params = "{\"externalId\":\"51033\"}";
        //String params = "{\"externalIds\":[\"51033\",\"57922\"]}";
        //1.4 需求评审结果推送
        //String url="http://172.30.203.168:13306/api/req/changeManagement/receiveEpicReviewResult";
        //String params = "{\"bizNum\":\"20201010_574015\",\"result\":\"02\"}";
        //cmdb 接口
        //String url = "http://172.30.197.131:53162/api/res/manage/opf/businessDeal.action";

        java.util.List<String> paramList = new ArrayList<>();
        paramList.add("CRM_BJ_REQ_20201027_0019");
        paramList.add("BJCRM_REQ_20201022_0006");
        String reqIds = "";
        StringBuffer sb = new StringBuffer();
        int idSize=paramList.size();
        for (int i = 0; i < idSize-1; i++) {

            sb.append("\"").append(paramList.get(i)).append("\",");
        }
        sb.append("\"").append(paramList.get(idSize-1)).append("\"");
        reqIds = sb.toString();
        //String params = "{\"busiCode\":\"GOVERN_DATA_QRY\",\"httpParam\":{\"requireNumber\":[" + reqIds + "]}}";
        //System.out.println(params);
        // http://172.30.197.131:53162/api/res/manage/opf/businessDeal.action
        //String params = "{\"busiCode\":\"GOVERN_DATA_QRY\",\"httpParam\":{\"requireNumber\":[\"CRM_BJ_REQ_20201027_0019\",\"BJCRM_REQ_20201022_0006\"]}}";
        //String params="{\"busiCode\":\"GOVERN_DATA_QRY\",\"httpParam\":{\"requireNumber\":[\"CRM_BJ_REQ_20201027_0019\"]}}";
        //String params = "{"busiCode":"GOVERN_DATA_QRY","httpParam":{"requireNumber":[CRM_BJ_REQ_20201027_0019]}}";
        //String url="http://172.30.219.11:8080/app/bj/bggl/config/addConfig";
        //String params="{\"name\":\"test\",\"domain\":\"test\"}";

        String result = sendPost(url, params);
        System.out.println(result);
    }

    private static String sendPost(String url, String requestParams) {
        String content = "";
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(30 * 1000)
                    .setConnectTimeout(30 * 1000)
                    .build();
            HttpPost post = new HttpPost(url);
            post.setConfig(requestConfig);
            post.setHeader("Content-Type", "application/json;charset=utf-8");
            StringEntity postingString = new StringEntity(requestParams, "utf-8");
            post.setEntity(postingString);
            HttpResponse response = httpClient.execute(post);
            content = EntityUtils.toString(response.getEntity());
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }
}
