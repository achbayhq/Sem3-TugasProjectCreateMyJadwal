package com.abayhq.login.futureFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abayhq.login.R;
import com.abayhq.login.adapterDosen;
import com.abayhq.login.setDosen;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link detailMatkulFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class detailMatkulFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public detailMatkulFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment detailMatkulFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static detailMatkulFragment newInstance(String param1, String param2) {
        detailMatkulFragment fragment = new detailMatkulFragment();
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
    private ArrayList<setDosen> dosenArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_detail_matkul, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String idMatkul = bundle.getString("id");
            String setMatkul = bundle.getString("mk");
            TextView id = rootView.findViewById(R.id.idMkl);
            TextView mkl = rootView.findViewById(R.id.nmMkl);
            TextView desnya = rootView.findViewById(R.id.desnya);

            id.setText(idMatkul);
            mkl.setText(setMatkul);
            switch(idMatkul){
                case "TIF10101" :
                    desnya.setText("Mata kuliah ini merupakan bagian dari program studi atau kursus yang " +
                            "fokus pada pengembangan dan implementasi sistem informasi berbasis web. Dalam " +
                            "mata kuliah ini, mahasiswa akan mempelajari konsep-konsep dasar dalam pembangunan " +
                            "sistem informasi web, termasuk pemahaman tentang teknologi web, desain antarmuka " +
                            "pengguna (UI/UX), pengembangan aplikasi web, manajemen basis data, dan keamanan " +
                            "informasi. Mahasiswa akan diajak untuk memahami secara praktis bagaimana merancang, " +
                            "mengembangkan, dan memelihara sistem informasi berbasis web yang efisien dan responsif.");
                    addData01();
                    break;
                case "TIF10102" :
                    desnya.setText("Mata kuliah ini merupakan bagian penting dari program studi atau pelatihan dalam " +
                            "bidang pengembangan perangkat lunak. Workshop ini bertujuan untuk memberikan pemahaman " +
                            "mendalam tentang praktik-praktik terbaik dalam memastikan kualitas perangkat lunak yang " +
                            "dihasilkan. Selama mata kuliah ini, mahasiswa akan belajar tentang berbagai metode dan " +
                            "alat yang digunakan dalam pengujian perangkat lunak, identifikasi dan perbaikan bug, " +
                            "serta pengelolaan proses pengembangan perangkat lunak untuk mencapai standar kualitas " +
                            "yang tinggi.");
                    addData02();
                    break;
                case "TIF10103" :
                    desnya.setText("Mata kuliah Struktur Data merupakan salah satu komponen penting dalam ilmu " +
                            "komputer dan pemrograman. Mata kuliah ini fokus pada pemahaman dan penerapan berbagai " +
                            "cara untuk menyimpan, mengelola, dan mengakses data dalam program komputer. Tujuan " +
                            "utamanya adalah untuk memungkinkan pengembang perangkat lunak merancang algoritma " +
                            "yang efisien dan efektif dalam memproses data.");
                    addData03();
                    break;
                case "TIF10104" :
                    desnya.setText("Dalam mata kuliah ini, mahasiswa akan mempelajari konsep-konsep kunci seperti" +
                            " topologi jaringan, arsitektur jaringan, jenis-jenis jaringan (seperti LAN, WAN, dan " +
                            "MAN), serta komponen-komponen yang terlibat dalam pembentukan jaringan, seperti router, " +
                            "switch, dan hub. Selain itu, mahasiswa juga akan memahami masalah keamanan jaringan, " +
                            "manajemen jaringan, dan masalah kinerja.");
                    addData04();
                    break;
                case "TIF10105" :
                    desnya.setText("IMata kuliah \"Konsep Matematika Diskrit\" adalah salah satu kursus yang " +
                            "mempelajari dasar-dasar matematika yang terfokus pada objek-objek diskrit " +
                            "atau terpisah, daripada objek-objek yang kontinu. Mata kuliah ini membahas berbagai " +
                            "topik penting dalam matematika diskrit, seperti teori himpunan, logika matematika, " +
                            "teori graf, kombinatorika, dan algoritma. Tujuan utama mata kuliah ini adalah untuk " +
                            "mengajarkan siswa cara berpikir secara abstrak, menganalisis masalah matematika yang " +
                            "melibatkan objek-objek diskrit, dan mengembangkan keterampilan dalam pemecahan masalah " +
                            "matematika.");
                    addData05();
                    break;
                case "TIF10108" :
                    desnya.setText("Mata kuliah \"Interpersonal Skill\" adalah kursus yang dirancang untuk membantu" +
                            " mahasiswa mengembangkan keterampilan komunikasi dan hubungan antarpribadi yang efektif." +
                            " Dalam mata kuliah ini, mahasiswa akan mempelajari berbagai aspek penting, termasuk cara" +
                            " berkomunikasi dengan baik, mendengarkan dengan penuh perhatian, mengelola konflik, " +
                            "membangun hubungan yang sehat, dan meningkatkan pemahaman tentang dinamika hubungan " +
                            "antarpribadi.");
                    addData06();
                    break;
                case "TIF10111" :
                    desnya.setText("IMata kuliah \"Workshop Mobile Application\" adalah sebuah program pembelajaran " +
                            "yang dirancang untuk memberikan pemahaman dan keterampilan praktis dalam pengembangan " +
                            "aplikasi mobile. Dalam mata kuliah ini, mahasiswa akan belajar tentang konsep dasar " +
                            "pengembangan aplikasi mobile, serta praktik terbaik dalam merancang, mengembangkan, " +
                            "dan menguji aplikasi yang berjalan pada perangkat mobile seperti smartphone");
                    addData07();
                    break;
            }
        }
        recyclerView = rootView.findViewById(R.id.dosenListnya);
        adapter = new adapterDosen(dosenArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    void addData01(){
        dosenArrayList = new ArrayList<>();
        int dsn1 = R.drawable.aji;
        int dsn2 = R.drawable.khafid;
        dosenArrayList.add(new setDosen(dsn1, "Aji Seto Arifianto, S.ST., M.T."));
        dosenArrayList.add(new setDosen(dsn2, "Khafidurrohman Agustianto, S.Pd, M.Eng"));
    }
    void addData02(){
        dosenArrayList = new ArrayList<>();
        int dsn1 = R.drawable.adi_heru;
        int dsn2 = R.drawable.maya;
        int dsn3 = R.drawable.ratih;
        dosenArrayList.add(new setDosen(dsn1, "Dr. Adi Heru Utomo, S.Kom, M.Kom"));
        dosenArrayList.add(new setDosen(dsn2, "Trismayanti Dwi P, S.Kom, M.Cs"));
        dosenArrayList.add(new setDosen(dsn3, "Ratih Ayuninghemi, S.ST, M.Kom"));
    }
    void addData03(){
        dosenArrayList = new ArrayList<>();
        int dsn1 = R.drawable.vani;
        int dsn2 = R.drawable.maya;
        dosenArrayList.add(new setDosen(dsn1, "Zilvanhisna Emka Fitri, ST. MT"));
        dosenArrayList.add(new setDosen(dsn2, "Trismayanti Dwi P, S.Kom, M.Cs"));
    }
    void addData04(){
        dosenArrayList = new ArrayList<>();
        int dsn1 = R.drawable.aji;
        int dsn2 = R.drawable.nugroho;
        int dsn3 = R.drawable.syamsul;
        dosenArrayList.add(new setDosen(dsn1, "Aji Seto Arifianto, S.ST., M.T."));
        dosenArrayList.add(new setDosen(dsn2, "Nugroho Setyo Wibowo, ST. MT"));
        dosenArrayList.add(new setDosen(dsn3, "Syamsul Arifin, S.Kom, M.Cs"));
    }
    void addData05(){
        dosenArrayList = new ArrayList<>();
        int dsn1 = R.drawable.vani;
        int dsn2 = R.drawable.arvita;
        dosenArrayList.add(new setDosen(dsn1, "Zilvanhisna Emka Fitri, ST. MT"));
        dosenArrayList.add(new setDosen(dsn2, "Arvita Agus Kurniasari, S.ST.,M.Tr.Kom"));
    }
    void addData06(){
        dosenArrayList = new ArrayList<>();
        int dsn1 = R.drawable.khafid;
        int dsn2 = R.drawable.aji;
        dosenArrayList.add(new setDosen(dsn1, "Khafidurrohman Agustianto, S.Pd, M.Eng"));
        dosenArrayList.add(new setDosen(dsn2, "Aji Seto Arifianto, S.ST., M.T."));
    }
    void addData07(){
        dosenArrayList = new ArrayList<>();
        int dsn1 = R.drawable.wiryawan;
        int dsn2 = R.drawable.prawidya;
        int dsn3 = R.drawable.adi_heru;
        int dsn4 = R.drawable.maya;
        dosenArrayList.add(new setDosen(dsn1, "I Gede Wiryawan, S.Kom., M.Kom."));
        dosenArrayList.add(new setDosen(dsn2, "Prawidya Destarianto, S.Kom, M.T"));
        dosenArrayList.add(new setDosen(dsn3, "Dr. Adi Heru Utomo, S.Kom, M.Kom"));
        dosenArrayList.add(new setDosen(dsn4, "Trismayanti Dwi P, S.Kom, M.Cs"));
    }
}