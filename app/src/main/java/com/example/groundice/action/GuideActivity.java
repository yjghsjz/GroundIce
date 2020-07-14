package com.example.groundice.action;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.example.groundice.MainActivity;
import com.example.groundice.R;

public class GuideActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private GestureDetector detector;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        detector = new GestureDetector(this, listener);
        viewFlipper = findViewById(R.id.viewFlipper);
        button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    GestureDetector.SimpleOnGestureListener listener = new GestureDetector.SimpleOnGestureListener() {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            //向右划动
            if (e1.getRawX() < e2.getRawX() && Math.abs(velocityX) > 50) {
                //显示上一张图片
                viewFlipper.showPrevious();
            } else if (e1.getRawX() > e2.getRawX() && Math.abs(velocityX) > 50) {
                viewFlipper.showNext();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    };

    /**
     * 拦截触摸事件，交给GestureDetector处理
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}


