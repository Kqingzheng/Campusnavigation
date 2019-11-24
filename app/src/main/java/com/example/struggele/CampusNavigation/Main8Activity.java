package com.example.struggele.CampusNavigation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.List;

public class Main8Activity extends AppCompatActivity {
    private long firstTime = 0;//判断退出程序
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
//List<String> s=new ArrayList<String>();
        webView=(WebView)findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl("http://www.baidu.com");
    }
    /**
     * 防止有 URL Scheme 跳转协议类型的url 导致webView加载网页失败
     * */
    public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url == null) return false;
            if (url.startsWith("http:") || url.startsWith("https:") ){
                view.loadUrl(url);
                return false;
            }else{
                try{
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    MyApplication.getContext().startActivity(intent);
                }catch (Exception e){
//                    ToastUtils.showShort("暂无应用打开此链接");
                }
                return true;
            }
        }
    }
}
