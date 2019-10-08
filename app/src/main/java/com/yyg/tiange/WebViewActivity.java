package com.yyg.tiange;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.wv_wv);
        //app内加载设置JavaScript支持
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyWebChromeClient());
        //加载本地HTML
        //webView.loadUrl("file:///android_asset/helloworld.html");
        //加载网络URL m开头 移动端
//        webView.loadUrl("https://m.bilibili.com/index.html");
        webView.loadUrl("https://m.baidu.com");

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //webview网页可后退 优先网页后退 不返回至上级Activity
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            //webview里直接加载 不会调用chrome浏览器
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView", "onPageStarted...");
//            webView.loadUrl("javascript:alert('pagestarted')");
//            webView.evaluateJavascript("javascript:alert('pagestarted')", null);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView", "onPageFinished...");
//            webView.loadUrl("javascript:alert('pagefinished')");
            webView.evaluateJavascript("javascript:alert('pagefinished')", null);
        }
    }

    class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            //设置WebViewActivity title
            setTitle(title);
        }
    }
}
