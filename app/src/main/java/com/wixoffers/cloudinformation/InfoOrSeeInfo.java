package com.wixoffers.cloudinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InfoOrSeeInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_or_see_info);
    }
    public void onEnterInfo(View view){
        Intent intent = new Intent(InfoOrSeeInfo.this,EnterInformation.class);
        startActivity(intent);

    }
    public void onSeeInfo(View view){
        Intent intent = new Intent(InfoOrSeeInfo.this,SeeInformation.class);
        startActivity(intent);

    }
}
