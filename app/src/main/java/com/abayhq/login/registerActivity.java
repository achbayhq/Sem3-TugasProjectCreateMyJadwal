package com.abayhq.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class registerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    public String nama;
    public String pass;
    EditText etDate;
    Calendar myCalendar;
    byte[] byteArray;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imageView = findViewById(R.id.profile);
        Button upload = findViewById(R.id.upload);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(registerActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    // Izin sudah diberikan, Anda dapat mengakses kamera di sini
                    dispatchTakePictureIntent();
                } else {
                    // Izin belum diberikan, maka kita perlu meminta izin kepada pengguna
                    ActivityCompat.requestPermissions(registerActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
                }

            }
        });

        etDate = (EditText) findViewById(R.id.txtTgl);
        myCalendar = Calendar.getInstance();

        Spinner spinner = findViewById(R.id.gender);
        Spinner spinnerProdi = findViewById(R.id.prodi);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this, R.array.pilihan, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence>adapterProdi = ArrayAdapter.createFromResource(this, R.array.prodi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterProdi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinnerProdi.setAdapter(adapterProdi);
        spinnerProdi.setOnItemSelectedListener(this);

        DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };

        etDate.setOnClickListener(view-> {
            new DatePickerDialog(registerActivity.this, date,
                    myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });
    }

    private void updateLabel(){
        String myFormat = "dd MMMM yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        etDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void keLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void udahRegist(View view) {
        EditText usr = findViewById(R.id.txtUsrnmRegist);
        EditText nm = findViewById(R.id.txtNama);
        EditText almt = findViewById(R.id.txtAlamat);
        EditText eml = findViewById(R.id.txtEmail);
        EditText pss = findViewById(R.id.txtPassRegist);
        EditText tgl = findViewById(R.id.txtTgl);
        EditText nim = findViewById(R.id.nim);
        EditText tlp = findViewById(R.id.tlp);
        Spinner prodi = findViewById(R.id.prodi);

        String usrnmFix = usr.getText().toString();
        String passFix = pss.getText().toString();
        String namaTxt = nm.getText().toString();
        String alamatTxt = almt.getText().toString();
        String emailTxt = eml.getText().toString();
        String tglTxt = tgl.getText().toString();
        String NIMTxt = nim.getText().toString();
        String tlpTxt = tlp.getText().toString();
        String prodiTxt = prodi.getSelectedItem().toString();


        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("nama", namaTxt);
        intent.putExtra("username", usrnmFix);
        intent.putExtra("alamat", alamatTxt);
        intent.putExtra("email", emailTxt);
        intent.putExtra("password", passFix);
        intent.putExtra("tanggalLahir", tglTxt);
        intent.putExtra("nim", NIMTxt);
        intent.putExtra("tlp", tlpTxt);
        intent.putExtra("prodi", prodiTxt);
        intent.putExtra("img", byteArray);
        startActivity(intent);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byteArray = stream.toByteArray();
            imageView.setImageBitmap(imageBitmap);
        }
    }

}