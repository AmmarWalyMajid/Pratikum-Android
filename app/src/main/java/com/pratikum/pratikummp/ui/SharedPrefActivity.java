package com.pratikum.pratikummp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pratikum.pratikummp.Data.sharedprefe.SharedPrefeManager;
import com.pratikum.pratikummp.R;

public class SharedPrefActivity extends AppCompatActivity {


    private TextView textView;
    private EditText editText;
    private Button button;

    //Deklarasi dan Inisialisasi class sharedPrefManager
    private SharedPrefeManager sharedPrefManager;

    //Digunakan Untuk Konfigurasi SharedPreferences
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        editText = findViewById(R.id.eTinput);
        textView = findViewById(R.id.tvOutput);
        button = findViewById(R.id.btSave);

        //membuat object class SharedPrefManager
        sharedPrefManager = new SharedPrefeManager(this);

        textView.setText(sharedPrefManager.getString());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                Toast.makeText(getApplicationContext(),"Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData(){
        //Mendapatkan Input dari user
        String getKonten = editText.getText().toString();
        sharedPrefManager.saveString(getKonten);

        //menampilkan data
        textView.setText(sharedPrefManager.getString());

    }
}