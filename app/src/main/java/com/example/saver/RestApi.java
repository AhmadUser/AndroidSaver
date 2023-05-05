package com.example.saver;

import android.util.JsonReader;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class RestApi {






    public static  boolean loginRestApi(String username,String password){
        boolean exists=false;
        try {
            String api=ApiPaths.LOGIN_API;
            api+="?Admin="+username+"&Password="+password;
            URL url = new URL(api);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                String jsonString = response.toString();
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    exists=jsonObject.getBoolean("Authenticated");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(MainActivity.MAIN_CONTEXT,"Check Internet Connection", Toast.LENGTH_LONG).show();
            }
            connection.disconnect();
        } catch (Exception e) {
            Toast.makeText(MainActivity.MAIN_CONTEXT,"Error", Toast.LENGTH_LONG).show();
            e.printStackTrace();
            return false;
        }
        return exists;
    }
}
