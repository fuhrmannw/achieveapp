package com.example.will.achieve.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.will.achieve.Global;
import com.example.will.achieve.ServerRequest;

import org.json.JSONObject;

/**
 * Created by enclark on 11/30/17.
 */

public class LoginAsync extends AsyncTask<Void, Void, JSONObject> {

    private String firstName;
    private String lastName;
    private String username;
    private LoginHandler handler;

    public LoginAsync(String username, String firstName, String familyName, LoginHandler handler) {
        this.username = username;
        this.lastName = familyName;
        this.firstName = firstName;
        this.handler = handler;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {

        JSONObject json = new JSONObject();
        try {
            json.put("username", username);
            json.put("email", username);
            json.put("firstName", firstName);
            json.put("lastName", lastName);

            ServerRequest req = new ServerRequest(json, "/user/login", false);
            return req.sendRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        if(result != null) {
            try {
                Log.i("LoginAsync", "Result " + result.toString());
                JSONObject user = result.getJSONObject("user");
                Global global = Global.getInstance();
                global.username = user.getString("username");
                global.firstName = user.getString("firstName");
                global.lastName = user.getString("lastName");
                global.userId = user.getInt("id");
                handler.handleLogin();
                Log.i("LoginAsync", "Going to HomeActivity");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface LoginHandler {
        void handleLogin();
    }
}
