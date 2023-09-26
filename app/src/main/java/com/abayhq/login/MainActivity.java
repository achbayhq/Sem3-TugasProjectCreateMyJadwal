package com.abayhq.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String Nm = "abayhq";
    String Pass = "112233";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nm = getIntent().getStringExtra("nama");
        Pass = getIntent().getStringExtra("passnya");
        EditText txtSetNm = findViewById(R.id.txtUsrnm);
        EditText txtSetPass = findViewById(R.id.txtPass);
        txtSetNm.setText(Nm);
        txtSetPass.setText(Pass);

    }

    public void activitySubmit(View view) {

        EditText usrnmnya = findViewById(R.id.txtUsrnm);
        EditText passnya = findViewById(R.id.txtPass);
        String U = usrnmnya.getText().toString();
        String P = passnya.getText().toString();

        if (Nm.equals(U) && Pass.equals(P)){
            Intent intent = new Intent(this, testCardViewActivity.class);
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