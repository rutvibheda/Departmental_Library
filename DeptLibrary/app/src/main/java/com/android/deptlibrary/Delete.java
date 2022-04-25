package com.android.deptlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Delete extends AppCompatActivity {
    String bookno;
    EditText bno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        bno=findViewById(R.id.bno);
    }
    public void delete(View view){
        bookno =bno.getText().toString();
        String type="delete";

        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type,bookno);
    }

}
