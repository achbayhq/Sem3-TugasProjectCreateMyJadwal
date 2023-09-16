package com.abayhq.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class testCardViewActivity extends AppCompatActivity implements adapterMatkul.OnItemClickListener{

    private RecyclerView recyclerView;
    private adapterMatkul adapter;
    private ArrayList<setMatkul> matkulArrayList;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_card_view);

        fragmentManager = getSupportFragmentManager();

        addData();
        recyclerView = (RecyclerView) findViewById(R.id.listMatkul);
        adapter = new adapterMatkul(this,matkulArrayList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(testCardViewActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    void addData(){
        matkulArrayList = new ArrayList<>();
        matkulArrayList.add(new setMatkul("TIF10101", "Pemrograman Dasar"));
        matkulArrayList.add(new setMatkul("TIF10102", "Kualitas Perangkat Lunak"));
        matkulArrayList.add(new setMatkul("TIF10103", "Database"));
        matkulArrayList.add(new setMatkul("TIF10104", "Mobile Aplication"));
        matkulArrayList.add(new setMatkul("TIF10105", "Matematika Diskrit"));
        matkulArrayList.add(new setMatkul("TIF10108", "Intermediate English"));
        matkulArrayList.add(new setMatkul("TIF10111", "Jaringan Komputer"));
    }

    @Override
    public void onItemClick(setMatkul item) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        matkulFragment mkf = new matkulFragment();

        String mkl = item.getterMatkul();
        String id = item.getterIdMatkul();
        Bundle bn = new Bundle();

        bn.putString("id", id);
        bn.putString("mk", mkl);

        mkf.setArguments(bn);
        transaction.replace(R.id.forFragment, mkf);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}