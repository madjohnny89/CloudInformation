package com.wixoffers.cloudinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class EnterInformation extends AppCompatActivity {
    EditText e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_information);
        e1= findViewById(R.id.enterName);
        e2 = findViewById(R.id.ageEdit);
        e3 = findViewById(R.id.enterNumber);
    }
    public  void onProceed(View view){
        ParseObject identity =  new ParseObject("Identity");
        identity.put("Name",e1.getText().toString());
        identity.put("Age",e2.getText().toString());
        identity.put("Number",e3.getText().toString());
        identity.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e==null){
                    Intent intent = new Intent(EnterInformation.this,InfoOrSeeInfo.class);
                    startActivity(intent);
                    Toast.makeText(EnterInformation.this,"Data Saved Successfully", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(EnterInformation.this,"Could not save", Toast.LENGTH_LONG).show();

            }
        });


    }
}
