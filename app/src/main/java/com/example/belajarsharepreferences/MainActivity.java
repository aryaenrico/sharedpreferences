package com.example.belajarsharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static  final String MyPreferences   ="Mypref";    // tempat menyimpan data lokal
 public static final String Primary ="KeyValue";  // key untuk data yang di input
SharedPreferences preferences;
EditText txtinput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init(){
        preferences =getSharedPreferences(MyPreferences,Context.MODE_PRIVATE);
        txtinput = (EditText) findViewById(R.id.edInput);
    }



    public void simpan(View view){
        SharedPreferences.Editor editor = preferences.edit();
        String nama =txtinput.getText().toString();
        editor.putString(Primary,nama);
        editor.commit();
        txtinput.setText("");
        Toast.makeText(getApplicationContext(),"Data Berhasil Di Simpan",Toast.LENGTH_LONG).show();
    }
    public void tampil(View view){
        String tampil = preferences.getString("KeyValue","kosong");
        txtinput.setText(tampil);
    }
    public void ubah(View view){
        SharedPreferences.Editor editor = preferences.edit();
        String nama =txtinput.getText().toString();
        editor.putString(Primary,nama);
        editor.commit();
        txtinput.setText("");
        Toast.makeText(getApplicationContext(),"Data Berhasil Di Ubah",Toast.LENGTH_LONG).show();
    }

    public void hapus(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(Primary);
        txtinput.setText("");
        editor.commit();
        Toast.makeText(getApplicationContext(),"Data Berhasil Di Ubah",Toast.LENGTH_LONG).show();
    }


}