package com.example.groundice.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.groundice.R;

public class LoginActivity extends AppCompatActivity {


    private EditText et_name;
    private EditText et_password;
    private Button bt_toRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt_toRegister = findViewById(R.id.bt_toRegister);
        et_password = findViewById(R.id.et_password);
        et_name = findViewById(R.id.et_name);


        et_name.addTextChangedListener(new TextWatcher(){

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int start, int before,
                                      int count) {
                if (arg0.length() == 0) {
                    // No entered text so will show hint
                    et_name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                } else {
                    et_name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                }
            }
        });

        et_password.addTextChangedListener(new TextWatcher(){

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int start, int before,
                                      int count) {
                if (arg0.length() == 0) {
                    // No entered text so will show hint
                    et_password.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                } else {
                    et_password.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                }
            }
        });


        bt_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }



}
