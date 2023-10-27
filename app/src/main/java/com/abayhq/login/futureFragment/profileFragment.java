package com.abayhq.login.futureFragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.abayhq.login.R;
import com.abayhq.login.database.dbProfileHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public profileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static profileFragment newInstance(String param1, String param2) {
        profileFragment fragment = new profileFragment();
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

    String namaTxt;
    String alamatTxt;
    String emailTxt;
    String tglTxt;
    String NIMtxt;
    String prodiTxt;
    String tlpTxt;
    String img;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_profile, container, false);
        TextView namaP = root.findViewById(R.id.namaProfile);
        TextView alamatP = root.findViewById(R.id.alamatProfile);
        TextView emailP = root.findViewById(R.id.emailProfile);
        TextView tglP = root.findViewById(R.id.tglProfile);
        TextView nimP = root.findViewById(R.id.nimProfile);
        TextView prodiP = root.findViewById(R.id.prodiProfile);
        TextView tlpP = root.findViewById(R.id.tlpProfile);

        dbProfileHelper dbHelper = new dbProfileHelper(getContext(), dbProfileHelper.DB_NAME, null, dbProfileHelper.DB_VER);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] field = {"nama", "nim", "email", "telephone", "tanggal_lahir", "prodi", "alamat", "img"};
        Cursor cursor = db.query(
                "profile",
                field,
                null,
                null,
                null,
                null,
                "no ASC"
        );
        while (cursor.moveToNext()) {
            namaTxt = cursor.getString(cursor.getColumnIndexOrThrow("nama"));
            alamatTxt = cursor.getString(cursor.getColumnIndexOrThrow("alamat"));
            emailTxt = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            tglTxt = cursor.getString(cursor.getColumnIndexOrThrow("tanggal_lahir"));
            NIMtxt = cursor.getString(cursor.getColumnIndexOrThrow("nim"));
            prodiTxt = cursor.getString(cursor.getColumnIndexOrThrow("prodi"));
            tlpTxt = cursor.getString(cursor.getColumnIndexOrThrow("telephone"));
            img = cursor.getString(cursor.getColumnIndexOrThrow("img"));
        }
        cursor.close();

        namaP.setText(namaTxt);
        alamatP.setText(alamatTxt);
        emailP.setText(emailTxt);
        tglP.setText(tglTxt);
        nimP.setText(NIMtxt);
        prodiP.setText(prodiTxt);
        tlpP.setText(tlpTxt);

        ImageView imgView = root.findViewById(R.id.forProfile);
        Bitmap imageBitmap = BitmapFactory.decodeFile(img);
        imgView.setImageBitmap(imageBitmap);

        return root;
    }
}