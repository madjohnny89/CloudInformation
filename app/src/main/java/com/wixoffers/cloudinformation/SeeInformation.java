package com.wixoffers.cloudinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class SeeInformation extends AppCompatActivity {
EditText e1;
TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_information);
        e1 = findViewById(R.id.sNumber);
        t1 = findViewById(R.id.searchedName);
        t2 = findViewById(R.id.searchedAge);
        t3 = findViewById(R.id.searchedNumber);
    }
    public void onSearch (View view){
        ParseQuery <ParseObject> parseQuery = ParseQuery.getQuery("Identity");
        parseQuery.whereEqualTo("Number",e1.getText().toString());
        parseQuery.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e==null){
                    t1.setVisibility(View.VISIBLE);
                    t2.setVisibility(View.VISIBLE);
                    t3.setVisibility(View.VISIBLE);
                    t1.setText(object.get("Name").toString());
                    t2.setText(object.get("Age").toString());
                    t3.setText(object.get("Number").toString());

                }
            }
        });

    }
}
