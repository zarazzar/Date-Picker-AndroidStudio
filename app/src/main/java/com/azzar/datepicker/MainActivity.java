package com.azzar.datepicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button btnTanggal,btnKonfirmasi;
private TextView tvTanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTanggal = findViewById(R.id.btn_tanggal);
        btnKonfirmasi = findViewById(R.id.btn_konfirmasi);
        tvTanggal = findViewById(R.id.tv_tanggal);

        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment fragmentTanggal = new DatePickerFragment();
                fragmentTanggal.show(getSupportFragmentManager(),"datePicker");

            }
        });

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tampilDialog();
            }
        });

    }


    public void processDatePickerResult(int year,int month,int day){

        String tahun = Integer.toString(year);
        String bulan = Integer.toString(month+1);
        String tanggal = Integer.toString(day);

        String choosenDate = tanggal + " - " + bulan + " - " + tahun;
        tvTanggal.setText(choosenDate);
    }

    private void tampilDialog(){
        AlertDialog.Builder dialog= new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Perhatian");
        dialog.setMessage("Apakah Anda yakin data yang anda isi sudah benar?");

        dialog.setPositiveButton("ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "TerimaKasih", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        dialog.setNegativeButton("tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.show();
    }

}