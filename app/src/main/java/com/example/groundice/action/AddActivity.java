package com.example.groundice.action;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.groundice.R;

public class AddActivity extends AppCompatActivity {

    private ImageButton btn_getPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btn_getPhoto = findViewById(R.id.imgbtn_getPhoto);
    }
}
