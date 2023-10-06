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

    String Username;
    String Password;
    String namaTxt;
    String alamatTxt;
    String emailTxt;
    String tglTxt;
    String NIMtxt;
    String prodiTxt;
    String tlpTxt;
    byte[] byteArray;

    profileFragment profileFragment = new profileFragment();
    mataKuliahFragment mataKuliahFragment = new mataKuliahFragment();
    jadwalFragment jadwalFragment = new jadwalFragment();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);

        Username = getIntent().getStringExtra("username");
        Password = getIntent().getStringExtra("password");
        namaTxt = getIntent().getStringExtra("nama");
        alamatTxt = getIntent().getStringExtra("alamat");
        emailTxt = getIntent().getStringExtra("email");
        tglTxt = getIntent().getStringExtra("tanggalLahir");
        NIMtxt = getIntent().getStringExtra("nim");
        prodiTxt = getIntent().getStringExtra("prodi");
        tlpTxt = getIntent().getStringExtra("tlp");
        byteArray = getIntent().getByteArrayExtra("img");


        Bundle bn = new Bundle();
        bn.putString("nama", namaTxt);
        bn.putString("username", Username);
        bn.putString("alamat", alamatTxt);
        bn.putString("email", emailTxt);
        bn.putString("password", Password);
        bn.putString("tanggalLahir", tglTxt);
        bn.putString("nim", NIMtxt);
        bn.putString("prodi", prodiTxt);
        bn.putString("tlp", tlpTxt);
        bn.putByteArray("img", byteArray);
        profileFragment.setArguments(bn);

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