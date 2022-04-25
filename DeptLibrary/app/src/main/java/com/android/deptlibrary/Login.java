package com.android.deptlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText et_no,et_password;
    Button bt_login;
    Spinner sp_role;
    //DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_no=findViewById(R.id.et_no);
        et_password=findViewById(R.id.et_password);
        bt_login=findViewById(R.id.bt_login);
        sp_role=(Spinner)findViewById(R.id.sp_role);


        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String no = et_no.getText().toString();
                final String password = et_password.getText().toString();
                final String role=sp_role.getSelectedItem().toString();
                if (!no.isEmpty()) {
                    if (!password.isEmpty()) {

                        if(role.equals("Staff"))
                        {
                            //Toast.makeText(Login.this, "You have selected Teacher", Toast.LENGTH_SHORT).show();
                            teacher();
                        }
                        else if(role.equals("Students"))
                        {
                            //Toast.makeText(Login.this, "You have selected Student", Toast.LENGTH_SHORT).show();
                            student();
                            //startActivity(new Intent(getApplicationContext(), student.class));
                        }
                        else if(role.equals("Admin"))
                        {
                            //Toast.makeText(Login.this, "You have selected Admin", Toast.LENGTH_SHORT).show();
                            admin();

                        }
                        else if(role.equals("Select"))
                        {
                            Toast.makeText(Login.this, "Selected role", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Login.this, "Enter password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, "Enter Registration Number or Smart Card Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void teacher(){

        StringRequest request=new StringRequest(Request.Method.POST, "http://192.168.0.107/Library/teacher.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            if (response.contains("CORRECT")) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Wrong Username or password", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            protected Map<String, String> getParams() {

                Map<String, String> params =new HashMap<String, String>();
                params.put("user_name",et_no.getText().toString().trim());
                params.put("pwd",et_password.getText().toString().trim());
                return params;
            }
        };

        Volley.newRequestQueue(Login.this).add(request);

    }

    public void student(){

        StringRequest request=new StringRequest(Request.Method.POST, "http://192.168.0.107/Library/student.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            if (response.contains("1")) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Wrong Username or password", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            protected Map<String, String> getParams() {

                Map<String, String> params =new HashMap<String, String>();
                params.put("smart_card_no",et_no.getText().toString().trim());
                params.put("registration_no",et_password.getText().toString().trim());
                return params;
            }
        };

        Volley.newRequestQueue(Login.this).add(request);

    }
    public void admin(){

        StringRequest request=new StringRequest(Request.Method.POST, "http://192.168.0.107/Library/admin.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            if (response.contains("CORRECT")) {
                                startActivity(new Intent(getApplicationContext(), Dept.class));
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Wrong Username or password", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            protected Map<String, String> getParams() {

                Map<String, String> params =new HashMap<String, String>();
                params.put("user_id",et_no.getText().toString().trim().toLowerCase());
                params.put("password",et_password.getText().toString().trim());

                return params;
            }
        };
        Volley.newRequestQueue(Login.this).add(request);
    }
}
