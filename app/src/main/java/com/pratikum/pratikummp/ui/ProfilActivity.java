package com.pratikum.pratikummp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pratikum.pratikummp.Data.sharedprefe.SharedPrefeManager;
import com.pratikum.pratikummp.R;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        final SharedPrefeManager sharedPrefManager = new SharedPrefeManager(this);


        TextView username = findViewById(R.id.tvUsername);
        TextView password = findViewById(R.id.tvPassword);
        TextView logout = findViewById(R.id.tvLogout);

        username.setText(sharedPrefManager.getUsername());
        password.setText(sharedPrefManager.getPassword());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfilActivity.this, MainActivity.class);
                sharedPrefManager.saveIsLogin(false);
                finishAffinity();
                startActivity(i);
            }
        });


    }
}