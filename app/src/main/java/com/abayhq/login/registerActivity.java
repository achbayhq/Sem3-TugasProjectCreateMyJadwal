package com.abayhq.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class registerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    public String nama;
    public String pass;
    EditText etDate;
    Calendar myCalendar;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        etDate = (EditText) findViewById(R.id.txtTgl);
        myCalendar = Calendar.getInstance();

        Spinner spinner = findViewById(R.id.gender);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this, R.array.pilihan, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

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
        String myFormat = "MM/dd/yy";
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
        EditText pss = findViewById(R.id.txtPassRegist);
        String usrnmFix = usr.getText().toString();
        String passFix = pss.getText().toString();

        setNama(usrnmFix);
        setPass(passFix);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("nama", getNama());
        intent.putExtra("passnya", getPass());
        startActivity(intent);

    }
}