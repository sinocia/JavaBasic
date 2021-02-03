package com.pascal.util.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import static com.alibaba.fastjson.util.IOUtils.UTF8;

/**
 * @auther Pascal
 * @date 2020/11/19 20:48
 */
public class ApacheHttpclient {
    /**
     * fileupload
     *
     * @param filePath
     * @param url
     * @return
     */
    public static String fileUpload(String filePath, String url) {
        String result = "";
        HttpClient httpClient = HttpClients.custom().build();
        HttpPost httpPost = new HttpPost(url);
        FileBody fileBody = new FileBody(new File(filePath));
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
                .addPart("file", fileBody).addTextBody("module", "itsm")
                .addTextBody("uploadBy", "system")
                .addTextBody("province", "gz");
        httpPost.setEntity(multipartEntityBuilder.build());
        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            StatusLine statusLine = httpResponse.getStatusLine();
            System.out.println(statusLine.getStatusCode());
            HttpEntity httpEntity = httpResponse.getEntity();
            if (statusLine.getStatusCode() == 200 && null != httpEntity) {
                long resultLength = httpEntity.getContentLength();
                System.out.println(resultLength);
                System.out.println(httpEntity.getContentType().getValue());
                System.out.println(EntityUtils.toString(httpEntity, UTF8));
                result = EntityUtils.toString(httpEntity, UTF8);
                EntityUtils.consume(httpEntity);//消耗响应实体，并关闭相关资源占用

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 伪装成浏览器提交表单
     */
    public static void fakeBrowserPost() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost("http://www.oschina.net/search");
        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("scope", "project"));
        parameters.add(new BasicNameValuePair("q", "java"));
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = null;
        try {
            formEntity = new UrlEncodedFormEntity(parameters);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);
        //伪装浏览器
        httpPost.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            System.out.println(response.getStatusLine().getStatusCode());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                //内容写入文件
                //FileUtils.writeStringToFile(new File("E:\\devtest\\oschina-param.html"), content, "UTF-8");
                System.out.println("内容长度：" + content.length());
            } else if (response.getStatusLine().getStatusCode() == 301) {
                System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * post with simple key value
     *
     * @param url
     */
    public static void doSimplePost(String url) {
        //HttpClient httpClient = HttpClients.custom().build();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();


        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("params", "John"));
        params.add(new BasicNameValuePair("taskOid", "pass"));
        params.add(new BasicNameValuePair("proId", "John"));
        params.add(new BasicNameValuePair("assignTo", "pass"));
        params.add(new BasicNameValuePair("toNodeId", "pass"));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            CloseableHttpResponse response = client.execute(httpPost);
            System.out.println(response.getStatusLine().getStatusCode());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
    }

    /**
     * @param url
     */
    public static void paramInEntity(String url) {
        HttpClient httpClient = HttpClients.custom().build();
        HttpPost httpPost = new HttpPost(url);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
                .addTextBody("params", "system")
                .addTextBody("taskOid", "gz")
                .addTextBody("proId", "system")
                .addTextBody("assignTo", "gz")
                .addTextBody("toNodeId", "gz");
        httpPost.setEntity(multipartEntityBuilder.build());
        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            StatusLine statusLine = httpResponse.getStatusLine();
            System.out.println(statusLine.getStatusCode());
            HttpEntity httpEntity = httpResponse.getEntity();
            if (null != httpEntity) {
                long resultLength = httpEntity.getContentLength();
                System.out.println(resultLength);
                System.out.println(httpEntity.getContentType().getValue());
                System.out.println(EntityUtils.toString(httpEntity, UTF8));
                EntityUtils.consume(httpEntity);//消耗响应实体，并关闭相关资源占用

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) {
        String url = "http://172.30.203.168:13306/api/req/changeManagement/getInfoByVersionId";
        String params = "{\"systemCode\":\"bggl\",\"versionId\":" + 198 + "}";

        //String url = "http://10.1.130.104/rest/common/file/upload";
        String filePath = "D:\\Asiainfo\\需求\\北京-集中化\\接口文档.docx";
        //ApacheHttpclient.fileUpload(filePath, url);
        //ApacheHttpclient.fakeBrowserPost();
        String updateToNextURL = "http://10.1.130.104/rest/itsm/updateToNode";
        String result=ApacheHttpclient.sendPost(url,params);
        System.out.println(result);
    }
}
