package com.example.groundice;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

import com.example.groundice.action.AddActivity;
import com.example.groundice.user.LoginActivity;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;


public class MainActivity extends AppCompatActivity {

    private FloatingActionMenu fabMenu;
    private Boolean fabOpened=false;
    private FloatingActionButton fab_login;
    private FloatingActionButton fab_add;
    public static MainActivity instance=null;

    public void init(){
        fab_login = findViewById(R.id.fab_login);
        fabMenu = findViewById(R.id.fab_menu);
        fab_add = findViewById(R.id.fab_add);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;

        init();

        listen();

    }

//    点击fabMenu按钮的动画
    public void openMenu(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",0,-210,-180);
        animator.setDuration(500);
        animator.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,0.5f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        fabOpened = true;
    }

//关闭fab显示的动画
    public void closeMenu(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",-180,30,0);
        animator.setDuration(500);
        animator.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f,0);
        alphaAnimation.setDuration(500);
        fabOpened = false;

    }


    public void listen(){
        fabMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fabOpened){
                    openMenu(view);
                }
                else {
                    closeMenu(view);
                }

            }
        });

        fab_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, AddActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }



}
