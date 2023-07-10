package com.example.testinglagi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MenuUtama extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    ShowLocation showLocation;
    BottomNavigationView bottomNavigationView;
    Fragment fragment;
    FragmentManager fm;
    ShowMovie showMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(this);

        fm = getSupportFragmentManager();

        showMovie = new ShowMovie();
        showLocation = new ShowLocation();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){

            case R.id.bottom_navigation_home:
                fm.beginTransaction()
                        .replace(R.id.fragment_container, showLocation)
                        .commit();

                return true;

            case R.id.bottom_navigation_map:
//                fm.beginTransaction()
//                        .hide(fragment)
//                        .show(mapTestingFragment)
//                        .addToBackStack("")
//                        .commit();
//                fragment = mapTestingFragment;
                fm.beginTransaction()
                        .replace(R.id.fragment_container, showMovie)
                        .commit();
        }

        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}