package com.pratikum.pratikummp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainGet extends AppCompatActivity {

    String message;
    TextView tvText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        tvText1 = findViewById(R.id.text1);

        Intent intentget = getIntent();
        message = intentget.getStringExtra("welcome");
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvText1.setText(message);

    }
}