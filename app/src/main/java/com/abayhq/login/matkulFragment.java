package com.abayhq.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link matkulFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class matkulFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public matkulFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment pDasarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static matkulFragment newInstance(String param1, String param2) {
        matkulFragment fragment = new matkulFragment();
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
    private adapterDosen adapter;
    private  ArrayList<setDosen> dosenArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_matkul, container, false);
        Bundle bundle = getArguments();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.dosenList);
        adapter = new adapterDosen(dosenArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        if (bundle != null) {
            String idMatkul = bundle.getString("id");
            String setMatkul = bundle.getString("mk");

            if (idMatkul.equals("TIF10101")) {
                TextView id = rootView.findViewById(R.id.idMkl);
                TextView mkl = rootView.findViewById(R.id.nmMkl);
                TextView desnya = rootView.findViewById(R.id.desnya);

                id.setText(idMatkul);
                mkl.setText(setMatkul);
                desnya.setText("Ini Deskripsi Mata Kuliah Pemrograman dasar");

                addData01();
            }
        }
        return rootView;
    }

    void addData01(){
        dosenArrayList = new ArrayList<>();
        dosenArrayList.add(new setDosen("ini gambar", "ini nama"));
    }
}