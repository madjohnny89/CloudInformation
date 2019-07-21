package com.wixoffers.cloudinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.parse.ParseInstallation;

public class MainActivity extends AppCompatActivity {
    Animation anim;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        anim = AnimationUtils.loadAnimation(this,R.anim.alpha);
        title = findViewById(R.id.title);
        title.startAnimation(anim);

    }
    public void onLogin(View view){
        Intent intent = new Intent(MainActivity.this,Login.class);
        startActivity(intent);

    }
    public void onSign(View view){
        Intent intent1 = new Intent(MainActivity.this,SignUp.class);
        startActivity(intent1);

    }
}
