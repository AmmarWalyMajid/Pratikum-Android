package com.pratikum.pratikummp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttontest,buttonfragment,sharepref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttontest = findViewById(R.id.btn_senddata);
        buttonfragment = findViewById(R.id.btn_fragment);
        sharepref = findViewById(R.id.btn_sharedpreference);

    }

    @Override
    protected void onResume() {
        super.onResume();

        buttontest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentsend = new Intent(getApplicationContext(), MainGet.class);
                intentsend.putExtra("welcome","Hallo Activity 1");
                startActivity(intentsend);


            }
        });

        buttonfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentsend = new Intent(getApplicationContext(),MainFragment.class);
                startActivity(intentsend);


            }
        });

        sharepref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentsend = new Intent(getApplicationContext(),MainFragment.class);
                startActivity(intentsend);


            }
        });
    }
}