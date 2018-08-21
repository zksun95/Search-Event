package com.wejoy.back;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

//import javax.net.ssl.HttpsURLConnection;

@Component
public class RequestSender {


    public static void sendPost() {
        StringBuffer sb=new StringBuffer();
        try {
            String urls = "http://localhost:9200/events/event/_search";
            URL url = new URL(urls);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            String urlParameters = "{\"query\" : { \"match\" : { \"name\" : \"1st\" }}}";
            byte[] data = (urlParameters).getBytes();
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            conn.setRequestProperty("contentType", "application/json");
            conn.connect();
            OutputStream out = new DataOutputStream(conn.getOutputStream()) ;
            out.write(urlParameters.getBytes());
            out.flush();
            out.close();

            System.out.println(conn.getResponseCode());

            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                System.out.println("succeed");
                InputStream in1 = conn.getInputStream();
                try {
                    String readLine=new String();
                    BufferedReader responseReader=new BufferedReader(new InputStreamReader(in1,"UTF-8"));
                    while((readLine=responseReader.readLine())!=null){
                        sb.append(readLine).append("\n");
                    }
                    responseReader.close();
                    System.out.println(sb.toString());

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else {
                System.out.println("error++");

            }

        } catch (Exception e) {

        }

    }
}
