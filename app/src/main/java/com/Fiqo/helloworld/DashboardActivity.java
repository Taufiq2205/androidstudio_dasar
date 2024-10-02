package com.Fiqo.helloworld;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.datamhs);
    }

    ListViewFragment listViewFragment = new ListViewFragment();
    RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.listmhs) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framelayout, listViewFragment)
                    .commit();
            return true;
        } else if (itemId == R.id.datamhs) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framelayout, recyclerViewFragment)
                    .commit();
            return true;
        } else {
            return false;
        }
    }
}
