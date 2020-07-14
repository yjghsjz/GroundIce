package com.example.groundice.action;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout;

import com.example.groundice.MainActivity;
import com.example.groundice.R;

public class WelcomeActivity extends  AppCompatActivity {


    // ctrl+alt+c 并将"start_main"选中 创建静态常量
    public static final String START_MAIN = "start_main";
    RelativeLayout start_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        start_app =  findViewById(R.id.start_app);

        //动画
        // 渐变
        AlphaAnimation change = new AlphaAnimation(0,1);
        change.setDuration(3000);
        change.setFillAfter(true);
//        //缩放
//        ScaleAnimation sa = new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
//        sa.setDuration(1000);
//        sa.setFillAfter(true);
//        //旋转
//        RotateAnimation ra = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
//        ra.setDuration(1000);
//        ra.setFillAfter(true);
//
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(change);

        start_app.setAnimation(set);
        set.setAnimationListener(new Animation.AnimationListener() {
            //当动画开始播放的时候
            @Override
            public void onAnimationStart(Animation animation) {

            }
            //当动画播放结束的时候
            @Override
            public void onAnimationEnd(Animation animation) {
//                Toast.makeText(WelcomeActivity.this,"动画播放完成!",Toast.LENGTH_LONG).show();
                //判断是否进入过 主页面
                SharedPreferences setting = getSharedPreferences(START_MAIN, 0);
                boolean isStartMain =  setting.getBoolean("FIRST",true);

                if (isStartMain){
                    setting.edit().putBoolean("FIRST",false).apply();
                    //如果没有进入过主界面,直接进引导页面
                    startActivity(new Intent(WelcomeActivity.this, GuideActivity.class));

                }else {
                    //如果进入过主界面,直接进入主页面
                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                }
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
