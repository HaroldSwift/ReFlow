package com.hfatih.reflow.Models;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by fatih on 1.3.2015.
 */
public class RedditAccount {
    public static enum LoginResult {
        SUCCESS, INTERNAL_ERROR, CONNECTION_ERROR, REQUEST_ERROR, JSON_ERROR, WRONG_PASSWORD, UNKNOWN_REDDIT_ERROR, RATELIMIT
    }

    public static class LoginResultPair {
        public final LoginResult result;
        public final RedditAccount account;
        public final String extraMessage;

        public LoginResultPair(final LoginResult result) {
            this(result, null, null);
        }

        public LoginResultPair(final LoginResult result, String extraMessage) {
            this(result, null, extraMessage);
        }

        public LoginResultPair(final LoginResult result, final RedditAccount account, final String extraMessage) {
            this.result = result;
            this.account = account;
            this.extraMessage = extraMessage;
        }
    }

    public final String username, modhash;
    public final long priority;

    public RedditAccount(final String username, final String modhash, final long priority) {

        if (username == null) throw new RuntimeException("Null user in RedditAccount");

        this.username = username.trim();
        this.modhash = modhash;
        this.priority = priority;
    }

    public boolean isAnonymous() {
        return username.length() == 0;
    }

    public String getCanonicalUsername() {
        return username.toLowerCase().trim();
    }

    public static void login(final Context context, final String username, final String password, FutureCallback callback) {

        final ArrayList<NameValuePair> fields = new ArrayList<NameValuePair>(3);
        fields.add(new BasicNameValuePair("user", username));
        fields.add(new BasicNameValuePair("passwd", password));
        fields.add(new BasicNameValuePair("api_type", "json"));


        Ion.with(context)
                .load("https://ssl.reddit.com/api/login")
                .addHeader("user", username)
                .addHeader("passwd", password)
                .addHeader("api_type", "json")
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        if (e == null) {
                            System.out.println(result);
                            System.out.println(result);
                        }
                    }
                });

    }


    @Override
    public boolean equals(final Object o) {
        return o instanceof RedditAccount && username.equals(((RedditAccount) o).username);
    }
}
