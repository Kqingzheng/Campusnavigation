package com.example.struggele.CampusNavigation;

import android.Manifest;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import pub.devrel.easypermissions.EasyPermissions;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, EasyPermissions.PermissionCallbacks {
    private NavigationView navView;
    private View headview;
    CircleImageView cimage;
    ImageView nav_header_image;
    private File cameraSavePath;//拍照照片路径
    private Uri uri;
    private String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private long firstTime = 0;//判断退出程序
    private DrawerLayout mDrawerLayout;
   // WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        navView=findViewById(R.id.nav_view);
        headview=navView.inflateHeaderView(R.layout.nav_header);
        cimage=(CircleImageView)headview.findViewById(R.id.lu);
        nav_header_image=(ImageView)headview.findViewById(R.id.nav_header_imageview);
        Resources res = getResources();
        Bitmap scaledBitmap = BitmapFactory.decodeResource(res, R.drawable.lu);

        //        scaledBitmap为目标图像，10是缩放的倍数（越大模糊效果越高）
        Bitmap blurBitmap = FastBlurUtil.toBlur(scaledBitmap, 10);
        nav_header_image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        nav_header_image.setImageBitmap(blurBitmap);


//        Glide.with(Main2Activity.this)
//                .load(R.drawable.lu)
//                .bitmapTransform(new BlurTransformation(Main2Activity.this,20,2))
//                .into(nav_header_image);
        setSupportActionBar(toolbar);
        Button button=(Button)findViewById(R.id.bu_heida);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_cela2 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent_cela2);
            }
        });
        cimage.setOnClickListener(this);

//        webView=(WebView)findViewById(R.id.webview);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebViewClient(new MyWebViewClient());
//        webView.loadUrl("http://www.baidu.com");
        mDrawerLayout=(DrawerLayout)findViewById(R.id.asas);
        //navView=(NavigationView)findViewById(R.id.nav_view);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icon41);
        }
        cameraSavePath = new File(Environment.getExternalStorageDirectory().getPath() + "/" + System.currentTimeMillis() + ".jpg");

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
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.lu:
                goPhotoAlbum();
                getPermission();
                break;

        }
    }
    //获取权限
    private void getPermission() {
        if (EasyPermissions.hasPermissions(this, permissions)) {
            //已经打开权限
            //Toast.makeText(this, "已经申请相关权限", Toast.LENGTH_SHORT).show();
        } else {
            //没有打开相关权限、申请权限
            EasyPermissions.requestPermissions(this, "需要获取您的相册、照相使用权限", 1, permissions);
        }

    }


    //激活相册操作
    private void goPhotoAlbum() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }

    //激活相机操作
//    private void goCamera() {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            uri = FileProvider.getUriForFile(MainActivity.this, "com.example.hxd.pictest.fileprovider", cameraSavePath);
//            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        } else {
//            uri = Uri.fromFile(cameraSavePath);
//        }
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//        MainActivity.this.startActivityForResult(intent, 1);
//    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //框架要求必须这么写
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    //成功打开权限
    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

        Toast.makeText(this, "相关权限获取成功", Toast.LENGTH_SHORT).show();
    }
    //用户未同意权限
    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this, "请同意相关权限，否则功能无法使用", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final String photoPath;
        if (requestCode == 2 && resultCode == RESULT_OK) {
            photoPath = getPhotoFromPhotoAlbum.getRealPathFromUri(this, data.getData());
            Glide.with(Main2Activity.this).load(photoPath).into(cimage);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int scaleRatio = 10;
                    //                        下面的这个方法必须在子线程中执行
                    final Bitmap blurBitmap2 = FastBlurUtil.GetUrlBitmap(photoPath, scaleRatio);

                                          //  刷新ui必须在主线程中执行
                    MyApplication.runOnUIThread(new Runnable() {//这个是我自己封装的在主线程中刷新ui的方法。
                        @Override
                        public void run() {
                            Log.v("asd",photoPath);
//                            nav_header_image.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                            nav_header_image.setImageBitmap(blurBitmap2);
                            Glide.with(Main2Activity.this).load(photoPath).into(nav_header_image);

                        }
                    });
                }
            }).start();
        }

        super.onActivityResult(requestCode, resultCode, data);
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
