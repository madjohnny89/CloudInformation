package com.wixoffers.cloudinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity {
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        e1 = findViewById(R.id.emailAdressEdit);
        e2 = findViewById(R.id.passEdit);

    }
    public void onSignUp(View view){
       //
        ParseUser user = new ParseUser();
// Set the user's username and password, which can be obtained by a forms
        user.setUsername(e1.getText().toString());
        user.setPassword(e2.getText().toString());
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignUp.this,"Signed up Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignUp.this,Login.class);
                    startActivity(intent);
                } else {
                    ParseUser.logOut();
                    Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
