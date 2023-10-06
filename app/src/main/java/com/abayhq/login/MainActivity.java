package com.abayhq.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String Username;
    String Password;
    String namaTxt;
    String alamatTxt;
    String emailTxt;
    String tglTxt;
    String NIMtxt;
    String prodiTxt;
    String tlpTxt;
    byte[] byteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = getIntent().getStringExtra("username");
        Password = getIntent().getStringExtra("password");
        namaTxt = getIntent().getStringExtra("nama");
        alamatTxt = getIntent().getStringExtra("alamat");
        emailTxt = getIntent().getStringExtra("email");
        tglTxt = getIntent().getStringExtra("tanggalLahir");
        NIMtxt = getIntent().getStringExtra("nim");
        prodiTxt = getIntent().getStringExtra("prodi");
        tlpTxt = getIntent().getStringExtra("tlp");
        byteArray = getIntent().getByteArrayExtra("img");

        EditText txtSetNm = findViewById(R.id.txtUsrnm);
        EditText txtSetPass = findViewById(R.id.txtPass);
        txtSetNm.setText(Username);
        txtSetPass.setText(Password);

    }

    public void activitySubmit(View view) {

        EditText usrnmnya = findViewById(R.id.txtUsrnm);
        EditText passnya = findViewById(R.id.txtPass);
        String U = usrnmnya.getText().toString();
        String P = passnya.getText().toString();

        if (Username.equals(U) && Password.equals(P)){
            Intent intent = new Intent(this, dasboardActivity.class);
            intent.putExtra("nama", namaTxt);
            intent.putExtra("username", Username);
            intent.putExtra("alamat", alamatTxt);
            intent.putExtra("email", emailTxt);
            intent.putExtra("password", Password);
            intent.putExtra("tanggalLahir", tglTxt);
            intent.putExtra("nim", NIMtxt);
            intent.putExtra("tlp", tlpTxt);
            intent.putExtra("prodi", prodiTxt);
            intent.putExtra("img", byteArray);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
        }
    }

    public void keRegister(View view) {
        Intent intent = new Intent(this, registerActivity.class);
        startActivity(intent);
    }
}