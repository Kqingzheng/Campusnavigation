package com.example.struggele.CampusNavigation;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main3Activity extends AppCompatActivity {
    static List<Fruit> fruitList = new ArrayList<>();
    //TextView textView;
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    RecyclerView recyclerView;
    String s;
    History his;
    UIThread thread;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        thread=new UIThread();
    }

    private class UIThread extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            FruitAdapter adapter2 = new FruitAdapter((List<Fruit>)msg.obj);
            Log.d("TAG", "initData: " +(List<Fruit>)msg.obj);
            recyclerView.setAdapter(adapter2);
        }
    }
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.toolbar,menu);
//        return true;
//    }
    private void initData() {
        OkHttpClient client = new OkHttpClient();
        String url = CONFIG.API.URL1;
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        final Call call = client.newCall(request);
        //  同步调用会阻塞主线程,这边在子线程进行
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //同步调用,返回Response,会抛出IO异常
                    Response response = call.execute();
                    // Log.d("asd","as"+response.body().string());
                    Log.v("asd", response.toString());
                    s = response.body().string();
                    Log.v("ad", s);
                    Gson gson = new Gson();
                    his = gson.fromJson(s, History.class);
                    fruitList.clear();
                    for (int i = 0; i < (his.getResult().size() - 1); i++) {
                        Fruit zhang = new Fruit(his.getResult().get(i).getTitle(),
                                his.getResult().get(i).getDes(),his.getResult().get(i).getPic(),
                                1);
                        fruitList.add(zhang);
                    }
                    Message message=new Message();
                    message.obj=fruitList;
                    thread.sendMessage(message);
                    Log.d("TAG", "run: " + fruitList.size());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.v("asd", "asd");
                }
            }
        }).start();
    }

}
