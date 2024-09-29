package com.Fiqo.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListMHSActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lsmhs;

    private ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_mhsactivity);
        lsmhs = findViewById(R.id.ls_mhs);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.daftar_mhs,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        lsmhs.setAdapter(adapter);
        lsmhs.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}