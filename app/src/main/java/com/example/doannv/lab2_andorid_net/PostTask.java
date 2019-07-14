package com.example.doannv.lab2_andorid_net;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PostTask extends AsyncTask<String,Long,String> {
    public static String Chao;
    @Override
    protected String doInBackground(String... strings) {

        try {
            URL url = new URL(strings[0]);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");



            // khoi tao param
            StringBuilder params = new StringBuilder();

            params.append("&");
            params.append("username=admin");
            params.append("&");
            params.append("password=123456");

            OutputStream os = httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter
                    (new OutputStreamWriter(os, "UTF-8"));

            // dua param vao body cua request
            writer.append(params);

            // giai phong bo nho
            writer.flush();
            // ket thuc truyen du lieu vao output
            writer.close();
            os.close();


            // lay du lieu tra ve
            StringBuilder response = new StringBuilder();

            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
            }


            return response.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Chao = s;
    }
}
