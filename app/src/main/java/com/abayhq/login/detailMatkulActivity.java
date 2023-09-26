package com.abayhq.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class detailMatkulActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private adapterDosen adapter;
    private  ArrayList<setDosen> dosenArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_matkul);

        Intent intent = getIntent();
        if (intent != null) {
            String idMatkul = intent.getStringExtra("id");
            String setMatkul = intent.getStringExtra("mk");
            TextView id = findViewById(R.id.idMkl);
            TextView mkl = findViewById(R.id.nmMkl);
            TextView desnya = findViewById(R.id.desnya);

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
        recyclerView = findViewById(R.id.dosenListnya);
        adapter = new adapterDosen(dosenArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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