package com.abayhq.login.futureFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.abayhq.login.R;
import com.abayhq.login.adapterJadwal;
import com.abayhq.login.setJadwal;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link jadwalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class jadwalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public jadwalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment jadwalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static jadwalFragment newInstance(String param1, String param2) {
        jadwalFragment fragment = new jadwalFragment();
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
    private adapterJadwal adapter;
    private ArrayList<setJadwal> jadwalArrayList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_jadwal, container, false);

        Button btS = root.findViewById(R.id.buttonSenin);
        Button btSe = root.findViewById(R.id.buttonSelasa);
        Button btR = root.findViewById(R.id.buttonRabu);
        Button btK = root.findViewById(R.id.buttonKamis);
        Button btJ = root.findViewById(R.id.buttonJumat);
        TextView hr = root.findViewById(R.id.hari);

        hr.setText("Senin");
        addDataSenin();
        recyclerView = root.findViewById(R.id.rcyJadwal);
        adapter = new adapterJadwal(jadwalArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        btS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hr.setText("Senin");
                addDataSenin();
                adapter.notifyDataSetChanged();
            }
        });
        btSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hr.setText("Selasa");
                addDataSelasa();
                adapter.notifyDataSetChanged();
            }
        });
        btR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hr.setText("Rabu");
                addDataRabu();
                adapter.notifyDataSetChanged();
            }
        });
        btK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hr.setText("Kamis");
                addDataKamis();
                adapter.notifyDataSetChanged();
            }
        });
        btJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hr.setText("Jumat");
                addDataJumat();
                adapter.notifyDataSetChanged();
            }
        });

        return root;
    }
    void addDataSenin(){
        jadwalArrayList.clear();
        jadwalArrayList.add(new setJadwal("3.8", "Workshop Kualitas Perangkat Lunak", "07.00-09.00"));
        jadwalArrayList.add(new setJadwal("3.8", "Workshop Kualitas Perangkat Lunak ", "09.00-11.00"));
        jadwalArrayList.add(new setJadwal("Lab KSI", "Workshop SIWEB", "13.00-15.00"));
        jadwalArrayList.add(new setJadwal("Lab KSI", "Workshop SIWEB", "15.00-17.00"));
    }
    void addDataSelasa(){
        jadwalArrayList.clear();
        jadwalArrayList.add(new setJadwal("Lab RSI", "Workshop SIWEB", "07.00-09.00"));
        jadwalArrayList.add(new setJadwal("Lab RSI", "Workshop SIWEB", "09.00-11.00"));
    }void addDataRabu(){
        jadwalArrayList.clear();
        jadwalArrayList.add(new setJadwal("LT.4", "Struktur Data", "07.00-09.00"));
        jadwalArrayList.add(new setJadwal("LT.4", "Konsep Jaringan Komputer", "09.00-11.00"));
        jadwalArrayList.add(new setJadwal("LT.4", "Matematika Diskrit", "13.00-15.00"));
        jadwalArrayList.add(new setJadwal("LT.4", "Interpersonal Skill", "15.00-17.00"));
    }void addDataKamis(){
        jadwalArrayList.clear();
        jadwalArrayList.add(new setJadwal("3.12", "Workshop Kualitas Perangkat Lunak", "07.00-09.00"));
        jadwalArrayList.add(new setJadwal("3.12", "Workshop Kualitas Perangkat Lunak", "09.00-11.00"));
        jadwalArrayList.add(new setJadwal("Workshop RSI", "Workshop Mobile Application", "13.00-15.00"));
        jadwalArrayList.add(new setJadwal("Workshop RSI", "Workshop Mobile Application", "15.00-17.00"));
    }void addDataJumat(){
        jadwalArrayList.clear();
        jadwalArrayList.add(new setJadwal("Workshop RSI", "Workshop Mobile Application", "13.00-15.00"));
        jadwalArrayList.add(new setJadwal("Workshop RSI", "Workshop Mobile Application", "15.00-17.00"));
    }
}