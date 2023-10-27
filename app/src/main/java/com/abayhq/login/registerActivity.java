package com.abayhq.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
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

import com.abayhq.login.database.dbProfileHelper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class registerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText nama, nim, usrnm, pass, email, telephone, pp, alamat;
    Spinner spinnerProdi;
    EditText etDate;
    Calendar myCalendar;
    String img;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nama = findViewById(R.id.txtNama);
        nim = findViewById(R.id.nim);
        usrnm = findViewById(R.id.txtUsrnmRegist);
        pass = findViewById(R.id.txtPassRegist);
        email = findViewById(R.id.txtEmail);
        telephone = findViewById(R.id.tlp);
        alamat = findViewById(R.id.txtAlamat);
        Spinner spinner = findViewById(R.id.gender);
        spinnerProdi = findViewById(R.id.prodi);

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
        dbProfileHelper dbHelper = new dbProfileHelper(this, dbProfileHelper.DB_NAME, null, dbProfileHelper.DB_VER);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nama", nama.getText().toString());
        values.put("nim", nim.getText().toString());
        values.put("username", usrnm.getText().toString());
        values.put("pass", pass.getText().toString());
        values.put("email", email.getText().toString());
        values.put("telephone", telephone.getText().toString());
        values.put("tanggal_lahir", etDate.getText().toString());
        values.put("prodi", spinnerProdi.getSelectedItem().toString());
        values.put("alamat", alamat.getText().toString());
        values.put("img", img);

        long newRowId = db.insert("profile", null, values);
        db.close();

        Intent intent = new Intent(this, MainActivity.class);
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
            img = saveImageToInternalStorage(imageBitmap);
            imageView.setImageBitmap(imageBitmap);
        }
    }

    private String saveImageToInternalStorage(Bitmap imageBitmap) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + ".jpg";

        // Mendapatkan direktori penyimpanan internal
        File storageDir = getApplicationContext().getFilesDir();

        // Membuat path lengkap untuk file gambar
        File imageFile = new File(storageDir, imageFileName);

        try {
            // Membuat output stream untuk menulis gambar ke file
            FileOutputStream outputStream = new FileOutputStream(imageFile);

            // Kompres dan simpan gambar ke file
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

            // Tutup output stream
            outputStream.close();

            // Mengembalikan path file gambar
            return imageFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            // Penanganan kesalahan, Anda bisa melemparkan atau mengembalikan null, tergantung pada kebutuhan Anda
            return null;
        }
    }

}