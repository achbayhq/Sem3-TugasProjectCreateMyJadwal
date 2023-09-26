package com.abayhq.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class testCardViewActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_card_view);

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        matkulPilihanFragment mkf = new matkulPilihanFragment();
        transaction.replace(R.id.cekkFragment, mkf);
        transaction.addToBackStack(null);
        transaction.commit();


    }


    public void keMatkulPilihan(View view) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        matkulPilihanFragment mkf = new matkulPilihanFragment();
        transaction.replace(R.id.cekkFragment, mkf);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void keJadwal(View view) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        jadwalMatkulFragment mkf = new jadwalMatkulFragment();
        transaction.replace(R.id.cekkFragment, mkf);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void keIPK(View view) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        IPKFragment mkf = new IPKFragment();
        transaction.replace(R.id.cekkFragment, mkf);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}