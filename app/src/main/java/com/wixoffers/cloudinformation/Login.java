package com.wixoffers.cloudinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Login extends AppCompatActivity {
EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1 = findViewById(R.id.lemailAdressEdit);
        e2 = findViewById(R.id.lpassEdit);
    }
    public void onLogin(View view){
        ParseUser.logInInBackground(e1.getText().toString(), e2.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser != null) {
                    Toast.makeText(Login.this,"Login Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this,InfoOrSeeInfo.class);
                    startActivity(intent);
                } else {
                    ParseUser.logOut();
                    Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
