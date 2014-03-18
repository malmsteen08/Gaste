package com.example.app;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by NZR on 17.02.2014.
 */
public class FragmentDipnot extends android.app.Fragment  {

    WebView webView;
    final static String dipnotUrl = "http://www.dipnot.tv/";
    String myUrl;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1,
                container, false);
        webView = (WebView) view.findViewById(R.id.webview1);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());




        if (myUrl == null) {
            myUrl = dipnotUrl;
        }
        webView.loadUrl(myUrl);

        return view;



    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            myUrl = url;
            view.loadUrl(url);
            return true;
        }


        }


    }







