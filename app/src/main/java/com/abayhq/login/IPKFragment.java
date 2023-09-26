package com.abayhq.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IPKFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IPKFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IPKFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IPKFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IPKFragment newInstance(String param1, String param2) {
        IPKFragment fragment = new IPKFragment();
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
    private adapterIPK adapter;
    private ArrayList<setIPK> IPKArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_i_p_k, container, false);

        addData();
        recyclerView = rootView.findViewById(R.id.listIPK);
        adapter = new adapterIPK(IPKArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    void addData(){
        IPKArrayList = new ArrayList<>();
        IPKArrayList.add(new setIPK("Agama", "A", "4"));
        IPKArrayList.add(new setIPK("Pancasila", "A", "4"));
        IPKArrayList.add(new setIPK("Basic English", "AB", "3.5"));
        IPKArrayList.add(new setIPK("Logika Algoritma", "A", "4"));
        IPKArrayList.add(new setIPK("Konsep Basis Data", "A", "4"));
        IPKArrayList.add(new setIPK("Pemrograman dasar", "B", "3"));
        IPKArrayList.add(new setIPK("Workshop Pengembangan Perakngkat Lunak", "A", "4"));
        IPKArrayList.add(new setIPK("Workshop Basis Data", "A", "4"));
    }
}