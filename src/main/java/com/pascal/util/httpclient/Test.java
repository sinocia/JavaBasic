package com.pascal.util.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import static com.alibaba.fastjson.util.IOUtils.UTF8;

/**
 * @auther Pascal
 * @date 2020/12/9 10:30
 */
public class Test {
    public static void main(String[] args) {
        //aido 根据版本查询需求信息 http://127.0.0.1:8060/req/changeManagement/getInfoByVersionId
       // String url = "http://172.30.203.168:13306/api/req/changeManagement/getInfoByVersionId";
        //String params = "{\"systemCode\":\"bggl\",\"versionId\":" + 198 + "}";

        //String params = "{\"systemCode\":\"bggl\"}";

        //1.3需求方案评审发起接口
        //String url = "http://172.30.203.168:13306/api/req/changeManagement/listBjEpicInfo";
        //String params = "{\"systemCode\":\"bggl\"}";
        //1.5 需求关联版本信息查询接口
        //String url = "http://172.30.203.168:13306/api/req/changeManagement/listBjUnReleasedVersionInfo";
        //String params = "{\"systemCode\":\"bggl\"}";
        //1.1 ITC系统查询接口172.30.245.6:37300 http://10.1.234.50:37300
        String url="http://172.30.245.6:37300/aici/ats/manual/getManualCaseExecLogs";
        //epicId 57145 57130 57128 57125 57122 57109 57107 57104
        String params = "{\"externalId\":\"51033\"}";
        //String params = "{\"externalIds\":[\"59234\",\"59346\"]}";
        //1.4 需求评审结果推送
        //String url="http://172.30.203.168:13306/api/req/changeManagement/receiveEpicReviewResult";
        //String params = "{\"bizNum\":\"20201010_574015\",\"result\":\"02\"}";
        //cmdb 接口
        //String url = "http://172.30.197.131:53162/api/res/manage/opf/businessDeal.action";

        /*List<String> paramList = new ArrayList<>();
        paramList.add("CRM_BJ_REQ_20201027_0019");
        paramList.add("BJCRM_REQ_20201022_0006");
        String reqIds = "";
        StringBuffer sb = new StringBuffer();
        int idSize=paramList.size();
        for (int i = 0; i < idSize-1; i++) {

            sb.append("\"").append(paramList.get(i)).append("\",");
        }
        sb.append("\"").append(paramList.get(idSize-1)).append("\"");
        reqIds = sb.toString();*/
        //String params = "{\"busiCode\":\"GOVERN_DATA_QRY\",\"httpParam\":{\"requireNumber\":[" + reqIds + "]}}";
        //System.out.println(params);
        // http://172.30.197.131:53162/api/res/manage/opf/businessDeal.action
        //String params = "{\"busiCode\":\"GOVERN_DATA_QRY\",\"httpParam\":{\"requireNumber\":[\"CRM_BJ_REQ_20201116_59346\",\"CRM_BJ_REQ_20210104_59234\",\"CRM_BJ_REQ_20201203_55732\"]}}";
        //String params="{\"busiCode\":\"GOVERN_DATA_QRY\",\"httpParam\":{\"requireNumber\":[\"CRM_BJ_REQ_20201027_0019\"]}}";
        //String params = "{"busiCode":"GOVERN_DATA_QRY","httpParam":{"requireNumber":[CRM_BJ_REQ_20201027_0019]}}";
        //String url="http://172.30.219.11:8080/app/bj/bggl/config/addConfig";
        //String params="{\"name\":\"test\",\"domain\":\"test\"}";

        String result = paramInBody(url, params);
        System.out.println(result);
    }

    public static String paramInBody(String url,String param) {
        String result="";
        HttpClient httpClient = HttpClients.custom().build();
        HttpPost httpPost = new HttpPost(url);
        //StringEntity xmlStringEntity=new StringEntity(xml,ContentType.APPLICATION_XML);
        StringEntity requestEntity = new StringEntity(param,
                ContentType.APPLICATION_JSON);
        httpPost.setEntity(requestEntity);
        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            StatusLine statusLine = httpResponse.getStatusLine();
            HttpEntity httpEntity = httpResponse.getEntity();
            if (statusLine.getStatusCode() == 200 && null != httpEntity) {
                result = EntityUtils.toString(httpEntity, UTF8);
                EntityUtils.consume(httpEntity);//消耗响应实体，并关闭相关资源占用
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static String sendAidoPost(String url, String requestParams) {
        String result="";
        HttpClient httpClient = HttpClients.custom().build();
        HttpPost httpPost = new HttpPost(url);
        //StringEntity xmlStringEntity=new StringEntity(xml,ContentType.APPLICATION_XML);
        StringEntity requestEntity = new StringEntity(requestParams,
                ContentType.APPLICATION_JSON);
        httpPost.setEntity(requestEntity);
        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            StatusLine statusLine = httpResponse.getStatusLine();
            HttpEntity httpEntity = httpResponse.getEntity();
            if (statusLine.getStatusCode() == 200 && null != httpEntity) {
                result = EntityUtils.toString(httpEntity, UTF8);
                EntityUtils.consume(httpEntity);//消耗响应实体，并关闭相关资源占用
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
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
