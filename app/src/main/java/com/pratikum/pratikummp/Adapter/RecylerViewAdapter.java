package com.pratikum.pratikummp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pratikum.pratikummp.Data.db.DataListener;
import com.pratikum.pratikummp.Data.db.MyApp;
import com.pratikum.pratikummp.Data.model.Mahasiswa;
import com.pratikum.pratikummp.R;
import com.pratikum.pratikummp.ui.AddRoomDataActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecylerViewAdapter extends  RecyclerView.Adapter<RecylerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Mahasiswa> albumList = new ArrayList<>();

    public void setListener(DataListener listener) {
        this.listener = listener;
    }

    private DataListener listener;




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mahasiswa, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final Mahasiswa album = albumList.get(position);
        holder.nama.setText(album.getNama());
        holder.nim.setText(album.getNim());
        holder.kejuruan.setText(album.getKejuruan());
        holder.alamat.setText(album.getAlamat());
        holder.bind(album,listener);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nama,nim,kejuruan,alamat;
        Button delete;
        private Mahasiswa data;
        private DataListener listener;

        public MyViewHolder(View v) {
            super(v);

            nama = v.findViewById(R.id.tvNama);
            nim = v.findViewById(R.id.tvNim);
            kejuruan = v.findViewById(R.id.tvKejuruan);
            alamat = v.findViewById(R.id.tvAlamat);
            delete = v.findViewById(R.id.deletebtn);

            delete.setOnClickListener(this);
            v.setOnClickListener(this);
        }
        void bind(Mahasiswa data, DataListener listener) {
            this.data = data;
            this.listener = listener;

//            tvNama.setText(data.getNama());
//            tvNim.setText(data.getNim());
//
//            loadImage(new File(data.getGambar()));
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.deletebtn){
//                data=albumList.get(getAdapterPosition());
                MyApp.getInstance().getDb().userDao().deleteUsers(data);
                listener.onRemoveClick(data);
                Toast.makeText(itemView.getContext(),"Berhasil dihapus",Toast.LENGTH_SHORT).show();
            }else if (v.getId() == R.id.item_list){

                Intent intent = new Intent(itemView.getContext(), AddRoomDataActivity.class);
                intent.putExtra(AddRoomDataActivity.TAG_DATA_INTENT,data.getId());
                itemView.getContext().startActivity(intent);
            }
        }
    }

    public RecylerViewAdapter(Context mContext, List<Mahasiswa> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;

    }



}
