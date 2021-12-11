package com.mod5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mod5.room.AppDatabase;

public class LoginActivity extends AppCompatActivity {
    EditText telp,password;
    Button login;
    TextView register;
    AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = AppDatabase.getInstance(this);
        telp = findViewById(R.id.notelpLogin);
        password = findViewById(R.id.passwordLogin);
        login = findViewById(R.id.login);
        register = findViewById(R.id.registerLogin);
        register.setOnClickListener(view -> startActivity(new Intent(this,RegisterActivity.class)));
        login.setOnClickListener(view -> {
            //kalo login tidak mengembalikan user sama sekali, gagal login
            if(database.UserDAO().login(telp.getText().toString(),password.getText().toString()).size()==0){
                Toast.makeText(getBaseContext(), "TELP OR PASSWORD SALAH", Toast.LENGTH_LONG).show();
            }else{
                startActivity(new Intent(this,MainActivity.class));
                finish();
            }
        });
    }
}