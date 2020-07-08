package com.example.groundice;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabButton;
    private TextView textView;
    private Boolean fabOpened=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabButton = findViewById(R.id.fab);
        fabButton.setOnClickListener(new View.OnClickListener() {
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


        textView = findViewById(R.id.cloud);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                closeMenu(fabButton);
            }
        });

    }

//    点击fab按钮的动画
    public void openMenu(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",0,-210,-180);
        animator.setDuration(500);
        animator.start();
        textView.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,0.7f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        textView.startAnimation(alphaAnimation);
        fabOpened = true;
    }

//关闭fab显示的动画
    public void closeMenu(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",-180,30,0);
        animator.setDuration(500);
        animator.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.7f,0);
        alphaAnimation.setDuration(500);
        textView.startAnimation(alphaAnimation);
        textView.setVisibility(View.GONE);
        fabOpened = false;

    }


}
