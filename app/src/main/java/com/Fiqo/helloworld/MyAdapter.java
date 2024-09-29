package com.Fiqo.helloworld;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private int[] image;
    private String[] daftarmhs;
    private String[] alamat;
    private String[] email;

    public MyAdapter(String[] daftarmhs, String[] alamat, String[] email,int[] image) {
        this.image = image;
        this.daftarmhs = daftarmhs;
        this.alamat = alamat;
        this.email = email;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.txt_nama.setText(daftarmhs[position]);
        holder.txt_alamat.setText(alamat[position]);
        holder.txt_email.setText(email[position]);
        holder.images.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
        return daftarmhs.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txt_nama;
        public TextView txt_alamat;
        public TextView txt_email;
        public ImageView images;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nama = itemView.findViewById(R.id.txt_name);
            txt_alamat = itemView.findViewById(R.id.txt_alamat);
            txt_email =itemView.findViewById(R.id.txt_email);
            images = itemView.findViewById(R.id.foto);
        }
    }
}
