package com.pratikum.pratikummp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pratikum.pratikummp.Data.sharedprefe.SharedPrefeManager;

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
    }
}