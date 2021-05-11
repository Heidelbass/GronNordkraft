package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Kartoner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kartoner);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if (bundle.getString("Hello World!") != null)
                Toast.makeText(getApplicationContext(),
                        "data:" + "Hello :)",
                        Toast.LENGTH_SHORT).show();
        }
    }
}