package com.abayhq.login.futureFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abayhq.login.R;
import com.abayhq.login.adapterMatkul;
import com.abayhq.login.setMatkul;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mataKuliahFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mataKuliahFragment extends Fragment implements adapterMatkul.OnItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public mataKuliahFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mataKuliahFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static mataKuliahFragment newInstance(String param1, String param2) {
        mataKuliahFragment fragment = new mataKuliahFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView recyclerView;
    private adapterMatkul adapter;
    private ArrayList<setMatkul> matkulArrayList;
    FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mata_kuliah, container, false);

        fragmentManager = getChildFragmentManager();
        addData();
        recyclerView = rootView.findViewById(R.id.listMatkul);
        adapter = new adapterMatkul(getContext() ,matkulArrayList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    void addData(){
        matkulArrayList = new ArrayList<>();
        matkulArrayList.add(new setMatkul("TIF10101", "Workshop SIWEB"));
        matkulArrayList.add(new setMatkul("TIF10102", "Workshop Kualitas Perangkat Lunak"));
        matkulArrayList.add(new setMatkul("TIF10103", "Struktur Data"));
        matkulArrayList.add(new setMatkul("TIF10104", "Konsep Jaringan Komputer"));
        matkulArrayList.add(new setMatkul("TIF10105", "Matematika Diskrit"));
        matkulArrayList.add(new setMatkul("TIF10108", "Interpersonal Skill"));
        matkulArrayList.add(new setMatkul("TIF10111", "Workshop Mobile Application"));
    }
    @Override
    public void onItemClick(setMatkul item) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        detailMatkulFragment mkf = new detailMatkulFragment();

        String mkl = item.getterMatkul();
        String id = item.getterIdMatkul();
        Bundle bn = new Bundle();

        bn.putString("id", id);
        bn.putString("mk", mkl);

        mkf.setArguments(bn);
        transaction.replace(R.id.frameForMatkul, mkf);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}