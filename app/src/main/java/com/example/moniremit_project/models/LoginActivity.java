package com.example.moniremit_project.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.moniremit_project.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
private TextView createAcc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createAcc = (TextView)findViewById(R.id.createnewac);
        createAcc.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
     if (v == createAcc){
         Intent i= new Intent(LoginActivity.this,RegistrationActivity.class);
         startActivity(i);
         finish();
     }
    }
}