package com.example.moniremit_project.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.moniremit_project.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView createAcc;
    private TextView forgotPin;
    private Button logInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createAcc = (TextView)findViewById(R.id.createnewac);
        forgotPin=(TextView)findViewById(R.id.forgot_pin);
        logInBtn=(Button)findViewById(R.id.btnlogin);

        createAcc.setOnClickListener(this::onClick);
        forgotPin.setOnClickListener(this::onClick);
        logInBtn.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
     if (v == createAcc){
         Intent i= new Intent(LoginActivity.this,RegistrationActivity.class);
         startActivity(i);
         finish();
     }
     if (v == forgotPin){
         Intent forgot= new Intent(LoginActivity.this,Reset_pinActivity.class);
         startActivity(forgot);
         finish();
     }
     if (v == logInBtn){
         Intent logIn= new Intent(LoginActivity.this,MainActivity.class);
         startActivity(logIn);
         finish();
     }
    }
}