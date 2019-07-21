package com.example.struggele.campus_navigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.multidex.MultiDexApplication;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private long firstTime = 0;//判断退出程序
    private DrawerLayout mDrawerLayout;
   // WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button=(Button)findViewById(R.id.bu_heida);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_cela2 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent_cela2);
            }
        });

//        webView=(WebView)findViewById(R.id.webview);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebViewClient(new MyWebViewClient());
//        webView.loadUrl("http://www.baidu.com");
        mDrawerLayout=(DrawerLayout)findViewById(R.id.asas);
        NavigationView navView=(NavigationView)findViewById(R.id.nav_view);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icon41);
        }
        navView.setCheckedItem(R.id.nav_home);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent_cela = new Intent(Main2Activity.this, Main3Activity.class);
                        startActivity(intent_cela);
                        break;
                    case R.id.nav_me:
                        Intent intent_cela1 = new Intent(Main2Activity.this, Main5Activity.class);
                        startActivity(intent_cela1);
                        break;
                    case R.id.nav_trip:
                        Intent intent_cela2 = new Intent(Main2Activity.this, Main8Activity.class);
                        startActivity(intent_cela2);
                        break;
                    case R.id.nav_wallet:
                        Intent intent_cela3 = new Intent(Main2Activity.this, Main4Activity.class);
                        startActivity(intent_cela3);
                        break;
                }
                return true;
            }
        });
    }
//    /**
//     * 防止有 URL Scheme 跳转协议类型的url 导致webView加载网页失败
//     * */
//    public class MyWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            if (url == null) return false;
//            if (url.startsWith("http:") || url.startsWith("https:") ){
//                view.loadUrl(url);
//                return false;
//            }else{
//                try{
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(url));
//                    MyApplication.getContext().startActivity(intent);
//                }catch (Exception e){
////                    ToastUtils.showShort("暂无应用打开此链接");
//                }
//                return true;
//            }
//        }
//    }
//    /**
//     * 使点击回退按钮不会直接退出整个应用程序而是返回上一个页面
//     *
//     * */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        long secondTime = System.currentTimeMillis();
//        if(keyCode == KeyEvent.KEYCODE_BACK){
//            if(webView.canGoBack()){
//                webView.goBack();//返回上个页面
//                return true;
//            }else{
//                if (secondTime - firstTime < 5000) {
//                    //System.exit(0);
//                    finish();
//                }else {
//                    Toast.makeText(Main2Activity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                    firstTime = System.currentTimeMillis();
//                }
//            }
//
//
//        }
//       // return super.onKeyDown(keyCode, event);//退出整个应用程序
//        return true;
//    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long secondTime = System.currentTimeMillis();
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (secondTime - firstTime < 2000) {
                System.exit(0);
            } else {
                Toast.makeText(Main2Activity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Intent intent_1 = new Intent(Main2Activity.this, Main6Activity.class);
                startActivity(intent_1);
                break;
            case R.id.delete:
                Intent intent_3 = new Intent(Main2Activity.this, Main7Activity.class);
                startActivity(intent_3);
                break;
            case R.id.settings:
                Intent intent_2 = new Intent(Main2Activity.this, LoginActivity.class);
                startActivity(intent_2);
                break;
        }
        return true;
    }
}
