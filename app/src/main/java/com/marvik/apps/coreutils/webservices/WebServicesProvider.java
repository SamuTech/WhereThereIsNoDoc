package com.marvik.apps.coreutils.webservices;

import android.content.Context;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by victor on 1/10/2016.
 */
public class WebServicesProvider {

    private String query;
    private String url;
    private Context context;

    public WebServicesProvider(Context context, String url, String query) {
        setQuery(query);
        setUrl(url);
        this.context = context;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getUrl() {
        return url;
    }

    public String getQuery() {
        return query;
    }

    public String getParams() {
        return getQuery();
    }

    public Context getContext() {
        return context;
    }

    public String consume() throws IOException {
        String dataStream = null;

        if (getUrl() == null) {
            throw new NullPointerException("URL Cannot be null");
        }

        URL url = new URL(getUrl());

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);

        OutputStream outputStream = httpURLConnection.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeBytes(getQuery());
        dataOutputStream.flush();
        dataOutputStream.close();

        InputStream inputStream = httpURLConnection.getInputStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();

        while ((dataStream = bufferedReader.readLine()) != null) {
            stringBuffer.append(dataStream);
        }

        dataStream = stringBuffer.toString();

        return dataStream;

    }
}
