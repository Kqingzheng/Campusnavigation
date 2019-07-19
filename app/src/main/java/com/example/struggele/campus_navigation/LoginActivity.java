package com.example.struggele.campus_navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.administrator.mydolphin.R;
//import com.example.administrator.mydolphin.dolphin.MainMenu.MainActivity;
//import com.example.administrator.mydolphin.dolphin.ToastUtils;
//import com.example.administrator.mydolphin.dolphin.User;
//import com.example.administrator.mydolphin.dolphin.regist.RegistActivity;
//import com.google.android.gms.common.api.GoogleApiClient;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends Activity implements OnClickListener {
    TextView tv_regist;
    EditText et_login_user, et_login_password;
    Button bt_login,cela;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        Bmob.initialize(this, "6f59bc1fa4afa6585714fc445207a1d6");
        tv_regist = (TextView) findViewById(R.id.tv_regist);
        bt_login = (Button) findViewById(R.id.login);
        et_login_user = (EditText) findViewById(R.id.et_login_user);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        cela=(Button)findViewById(R.id.cela);
        tv_regist.setOnClickListener(LoginActivity.this);
        bt_login.setOnClickListener(LoginActivity.this);
        cela.setOnClickListener(LoginActivity.this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getId()) {
            case R.id.tv_regist:
                Intent intent_regist = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent_regist);
                break;
            case R.id.login:
                String user_num = et_login_user.getText().toString();
                String user_password = et_login_password.getText().toString().trim();
                // 非空验证
                if (user_num.isEmpty() || user_password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "密码或账号不能为空!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                User bu2 = new User();
                bu2.setUsername(user_num);
                bu2.setPassword(user_password);
                // 使用BmobSDK提供的登录功能

                bu2.login(new SaveListener<BmobUser>() {

                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if(e==null){
                            //ToastUtils.toast(LoginActivity.this, " 登录成功");
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            Intent intent_main = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent_main);
                            //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                            //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                        }else{
                            //ToastUtils.toast(LoginActivity.this, " 登录失败");
                            Toast.makeText(LoginActivity.this," 登录失败", Toast.LENGTH_SHORT).show();
                            //loge(e);

                        }
                    }
                });

                break;
            case R.id.cela:
                Intent intent_cela = new Intent(LoginActivity.this, Main2Activity.class);
                startActivity(intent_cela);
                break;
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

}

