package com.pratikum.pratikummp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.pratikum.pratikummp.Adapter.RecylerViewAdapter;
import com.pratikum.pratikummp.Data.db.AppDatabase;
import com.pratikum.pratikummp.Data.db.DataListener;
import com.pratikum.pratikummp.Data.db.MyApp;
import com.pratikum.pratikummp.Data.model.Mahasiswa;
import com.pratikum.pratikummp.R;

import java.util.ArrayList;
import java.util.List;

import static com.pratikum.pratikummp.Data.db.MyApp.db;

public class ViewRoomDataActivity extends AppCompatActivity {

    RecyclerView myRecyclerview;
    RecylerViewAdapter recycleAdapter;
    List<Mahasiswa> listMahasiswas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_data);

        myRecyclerview = findViewById(R.id.myRecyclerview);

        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }
    private void fetchDataFromRoom() {
        db = MyApp.getInstance().getDb();
//        db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class,"mahasiswa").allowMainThreadQueries().build();
        listMahasiswas = db.userDao().getAll();

        //just checking data from db
        for (int i = 0 ;i <listMahasiswas.size();i++){
            Log.e("Aplikasi",listMahasiswas.get(i).getAlamat()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getKejuruan()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getNama()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getNim()+i);
        }
    }

    private void initRecyclerView() {
        myRecyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(llm);
        recycleAdapter =new RecylerViewAdapter(this,listMahasiswas);
        recycleAdapter.setListener(new DataListener() {
            @Override
            public Void onRemoveClick(Mahasiswa mahasiswa) {

                listMahasiswas.clear();
                listMahasiswas.addAll(db.userDao().getAll());
                recycleAdapter.notifyDataSetChanged();

                return null;
            }
        });
    }
    private void setAdapter() {
        myRecyclerview.setAdapter(recycleAdapter);
    }

}