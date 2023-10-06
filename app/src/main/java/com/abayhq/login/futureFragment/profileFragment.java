package com.abayhq.login.futureFragment;

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
        Bundle bundle = getArguments();
        if (bundle != null) {

            namaTxt = bundle.getString("nama");
            alamatTxt = bundle.getString("alamat");
            emailTxt = bundle.getString("email");
            tglTxt = bundle.getString("tanggalLahir");
            NIMtxt = bundle.getString("nim");
            prodiTxt = bundle.getString("prodi");
            tlpTxt = bundle.getString("tlp");

            namaP.setText(namaTxt);
            alamatP.setText(alamatTxt);
            emailP.setText(emailTxt);
            tglP.setText(tglTxt);
            nimP.setText(NIMtxt);
            prodiP.setText(prodiTxt);
            tlpP.setText(tlpTxt);

            byte[] byteArray = bundle.getByteArray("img");
            if (byteArray != null) {
                Bitmap receivedImageBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

                ImageView imageView = root.findViewById(R.id.forProfile);
                imageView.setImageBitmap(receivedImageBitmap);
            }
        }else{
            Toast.makeText(getContext(), "Data Kosong!!", Toast.LENGTH_SHORT).show();
        }
        return root;
    }
}