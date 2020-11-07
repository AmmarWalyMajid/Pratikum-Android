package com.pratikum.pratikummp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.pratikum.pratikummp.Adapter.RecylerViewAdapter;
import com.pratikum.pratikummp.Data.model.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class ViewRoomDataActivity extends AppCompatActivity {

    RecyclerView myRecyclerview;
    RecylerViewAdapter recycleAdapter;
    List<Mahasiswa> listMahasiswas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_data);
    }
}