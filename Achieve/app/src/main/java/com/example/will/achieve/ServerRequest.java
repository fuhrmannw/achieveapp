package com.example.will.achieve;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by enclark on 11/29/17.
 */

public class ServerRequest {

    private static final String IP = "http://10.26.136.9";
    private static final String URL = IP + ":8080";
    private static String charset = "UTF-8";

    private JSONObject body;

    private String endpoint;

    private boolean get;

    public ServerRequest(JSONObject json, String endpoint, boolean get) {
        this.get = get;
        this.body = json;
        this.endpoint = endpoint;

    }

    public JSONObject sendRequest(){
        try {
            Log.i("ServerRequest", "Sending Request to " + endpoint);
            HttpURLConnection connection = (HttpURLConnection) new URL(URL + endpoint).openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Host", URL);
            connection.setUseCaches(false);

            if (!get) {
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);//Sets POST
                connection.setDoInput(true);
                if (body !=  null) {
                    writeReqBody(connection, body);
                }
            }else {
                connection.setRequestMethod("GET");
            }

            connection.connect();
            int responseStatus = connection.getResponseCode(); // 200 is the only acceptable response
            if(responseStatus != 200)
            {
                System.out.println(responseStatus);
                System.out.println(connection.getResponseMessage());
            }

            JSONObject newJson = new JSONObject(readRes(connection));
            Log.i("ServerRequest", "Recevied " + newJson.toString());
            return newJson;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeReqBody(HttpURLConnection connection, JSONObject body) {
        //Allows for writing to the body of the request
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            out.write(body.toString());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readRes(HttpURLConnection connection) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
            String line = "";
            while((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
            return sb.toString();
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }

    }
}

