package com.abayhq.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.abayhq.login.futureFragment.profileFragment;
import com.abayhq.login.futureFragment.mataKuliahFragment;
import com.abayhq.login.futureFragment.jadwalFragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dasboardActivity extends AppCompatActivity {


    profileFragment profileFragment = new profileFragment();
    mataKuliahFragment mataKuliahFragment = new mataKuliahFragment();
    jadwalFragment jadwalFragment = new jadwalFragment();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);


        BottomNavigationView nav = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.forKonten, profileFragment).commit();
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragmen = null;
                int itemId = item.getItemId();
                if (itemId == R.id.menu1){
                    selectedFragmen = profileFragment;
                } else if (itemId == R.id.menu2) {
                    selectedFragmen = mataKuliahFragment;
                } else if (itemId == R.id.menu3) {
                    selectedFragmen = jadwalFragment;
                }

                if (selectedFragmen != null){

                    getSupportFragmentManager().beginTransaction().replace(R.id.forKonten, selectedFragmen).commit();
                }
                return true;
            }
        });
    }
}