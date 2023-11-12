package com.example.advancedlistphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView txt_subphone;

    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        txt_subphone = findViewById(R.id.txt_subphone);
        btnBack = findViewById(R.id.btnBack);
//        nhận intent
        Intent myintent = getIntent();
//        lấy dữ liệu
        String namephone = myintent.getStringExtra("name");
        txt_subphone.setText(namephone);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}