package com.example.struggele.CampusNavigation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ImageView imageView=(ImageView)findViewById(R.id.animaator_image);
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                R.animator.property_animator);
        set.setTarget(imageView);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Intent intent=new Intent(AnimationActivity.this,MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
//        RelativeLayout layoutsplash=(RelativeLayout)findViewById(R.id.activity_animation);//布局文件是相对布局
//        //TextView textView=(TextView)findViewById(R.id.ani_textview);
//       // Animation animation = AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.view_anim);
//       // textView.startAnimation(animation);
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f,1.0f);
//        alphaAnimation.setDuration(2500);
//
//        layoutsplash.startAnimation(alphaAnimation);
//        //设置动画监听
//        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {	//当动画结束后就跳转到其他活动中
//                Intent intent=new Intent(AnimationActivity.this,MainActivity.class);
//                startActivity(intent);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });


    }
    @Override
    protected void onPause() {//当动画结束后，就把该动画活动销毁
        super.onPause();
        finish();
    }
}


