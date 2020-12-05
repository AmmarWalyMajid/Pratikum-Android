package com.pratikum.pratikummp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pratikum.pratikummp.Data.Dao.MahasiswaDao;
import com.pratikum.pratikummp.Data.db.MyApp;
import com.pratikum.pratikummp.Data.model.Mahasiswa;
import com.pratikum.pratikummp.R;

import static com.pratikum.pratikummp.Data.db.MyApp.db;
import static com.pratikum.pratikummp.Data.db.MyApp.getInstance;

public class AddRoomDataActivity extends AppCompatActivity {

    public static String TAG_DATA_INTENT = "data_mahasiswa";

    EditText etNama;
    EditText etNim;
    EditText etKejuruan;
    EditText etAlamat;
    Mahasiswa mahasiswa;
    private MahasiswaDao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room_data);

        Button btnTambah =  findViewById(R.id.btInsert);
        etNama = findViewById(R.id.etNama);
        etNim = findViewById(R.id.etNim);
        etKejuruan= findViewById(R.id.etKejuruan);
        etAlamat = findViewById(R.id.etAlamat);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahData();
            }
        });
    }

    private void tambahData() {
        if (!etAlamat.getText().toString().isEmpty()&&!etKejuruan.getText().toString().isEmpty()&&
                !etNama.getText().toString().isEmpty()&&!etNim.getText().toString().isEmpty()){

            mahasiswa = new Mahasiswa();
            mahasiswa.setAlamat(etAlamat.getText().toString());
            mahasiswa.setKejuruan(etKejuruan.getText().toString());
            mahasiswa.setNama(etNama.getText().toString());
            mahasiswa.setNim(etNim.getText().toString());
            //Insert data in database
//            getDb(getApplicationContext()).userDao().insertAll(mahasiswa);
            dao = (MahasiswaDao) getInstance().getDb().userDao();
            dao.insertAll(mahasiswa);
            startActivity(new Intent(AddRoomDataActivity.this,RoomDataActivity.class));
        }else {
            Toast.makeText(this, "Mohon masukkan dengan benar", Toast.LENGTH_SHORT).show();
        }
    }
}