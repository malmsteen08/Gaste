package com.example.app;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by NZR on 17.02.2014.
 */
public class FragmentTwo extends android.app.Fragment {


    WebView webView;
    final static String radikalUrl = "http://m.radikal.com.tr/";
    String myUrl;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,
                container, false);
        webView = (WebView) view.findViewById(R.id.content_frame);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());

        if (myUrl == null) {
            myUrl = radikalUrl;
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
   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_2);
    /

    @Override
    public void onBackPressed() {
        FragmentTwo fragment = (FragmentTwo) getFragmentManager()
                .findFragmentById(R.id.webview);
        WebView webView = fragment;

       /* if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }*/
}







