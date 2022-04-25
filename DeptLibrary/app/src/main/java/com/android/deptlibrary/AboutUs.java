package com.android.deptlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity {
    Button hlogin,habout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().hide();

        hlogin=findViewById(R.id.hlogin);
        habout=findViewById(R.id.habout);

        hlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

        habout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutUs.this, "About Us", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),About.class));
            }
        });

    }
}
