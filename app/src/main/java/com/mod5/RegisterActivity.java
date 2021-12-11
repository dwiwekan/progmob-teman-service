package com.mod5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mod5.room.AppDatabase;
import com.mod5.room.entity.User;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    ImageButton back;
    AppDatabase database;
    Button daftar;
    EditText nama,email,alamat,telp,password;
    RadioGroup jk;
    CheckBox cb;
    SeekBar umur;
    TextView us;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        database = AppDatabase.getInstance(this);
        daftar = findViewById(R.id.button1);
        nama = findViewById(R.id.nama);
        email = findViewById(R.id.email);
        alamat = findViewById(R.id.alamat);
        telp = findViewById(R.id.notelp);
        password = findViewById(R.id.password);
        jk = findViewById(R.id.rg);
        us = findViewById(R.id.us);
        cb = findViewById(R.id.reguler);
        umur = findViewById(R.id.umur);
        back = findViewById(R.id.back);
        //biar umur di seekbar kelihatan
        umur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                us.setText((i+17) +" Tahun");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //tombol mundur saja
        back.setOnClickListener(view -> {
            finish();
        });
        daftar.setOnClickListener(view -> {
            //validasi data sebelum register
            if(!cb.isChecked()||
                    nama.getText().toString().isEmpty()||
                    email.getText().toString().isEmpty()||
                    alamat.getText().toString().isEmpty()||
                    telp.getText().toString().isEmpty()||
                    password.getText().toString().isEmpty()){
                Toast.makeText(this, "Lengkapi form!",
                        Toast.LENGTH_LONG).show();
            }else{
                User user = new User();
                user.nama = nama.getText().toString();
                user.email = email.getText().toString();
                user.alamat = alamat.getText().toString();
                user.telp = telp.getText().toString();
                user.password = password.getText().toString();
                user.umur = umur.getProgress();
                RadioButton rd = findViewById(jk.getCheckedRadioButtonId());
                user.jk = rd.getText().toString();
                database.UserDAO().RegisterUser(user);
                Toast.makeText(this, "Berhasil daftar!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}