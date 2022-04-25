package com.android.deptlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class Adminoperation extends AppCompatActivity {
    String domno,domname,bookno,bookt,aut,pub,donated,avail,deleted,user1,user2;
    EditText bno,btitle,etauthor,etpub,etdonated,etavail,etdeleted,etuser1,etuser2;
    Spinner dno,dname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminoperation);
        dno=findViewById(R.id.dno);
        dname=findViewById(R.id.dname);
        bno=findViewById(R.id.bno);
        btitle=findViewById(R.id.btitle);
        etauthor=findViewById(R.id.etauthor);
        etpub=findViewById(R.id.etpub);
        etdonated=findViewById(R.id.etdonated);
        etavail=findViewById(R.id.etavail);
        etdeleted=findViewById(R.id.etdeleted);
        etuser1=findViewById(R.id.etuser1);
        etuser2=findViewById(R.id.etuser2);
    }

    public void insert(View view)
    {
        domno =dno.getSelectedItem().toString();
        domname=dname.getSelectedItem().toString();
        bookno =bno.getText().toString();
        bookt=btitle.getText().toString();
        aut =etauthor.getText().toString();
        pub=etpub.getText().toString();
        donated =etdonated.getText().toString();
        avail=etavail.getText().toString();
        deleted =etdeleted.getText().toString();
        user1=etuser1.getText().toString();
        user2 =etuser2.getText().toString();
        String type="insert";

        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type,domno,domname,bookno,bookt,aut,pub,donated,avail,deleted,user1,user2);


    }
}
