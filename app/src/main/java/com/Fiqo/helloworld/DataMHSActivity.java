package com.Fiqo.helloworld;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DataMHSActivity extends AppCompatActivity  {
     private RecyclerView recylerView;
     private MyAdapter adapter;
     private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_mhsactivity);
        recylerView = findViewById(R.id.recyclerView);

        recylerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recylerView.setLayoutManager(layoutManager);

        String[] daftarmhs = getResources().getStringArray(R.array.daftar_mhs);
        String[] alamat = getResources().getStringArray(R.array.Alamat);
        String[] email = getResources().getStringArray(R.array.email);
        int[] image = {
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man
        };

        MyAdapter adapter = new MyAdapter(daftarmhs, alamat, email, image);
        recylerView.setAdapter(adapter);
    }
}