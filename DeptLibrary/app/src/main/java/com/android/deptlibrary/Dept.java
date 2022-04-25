package com.android.deptlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dept extends AppCompatActivity {

    Button bt_operation,bt_updoperation,bt_deloperation,bt_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept);
        getSupportActionBar().hide();

        bt_operation=findViewById(R.id.bt_operation);
        bt_updoperation=findViewById(R.id.bt_updoperation);
        bt_deloperation=findViewById(R.id.bt_deloperation);
        bt_view=findViewById(R.id.bt_view);

        bt_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });
        bt_updoperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),Update.class));

            }
        });
        bt_deloperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),Delete.class));

            }
        });
        bt_operation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),Adminoperation.class));

            }
        });
    }
}
