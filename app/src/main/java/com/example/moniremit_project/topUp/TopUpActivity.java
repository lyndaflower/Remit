package com.example.moniremit_project.topUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.moniremit_project.R;

public class TopUpActivity extends AppCompatActivity {

    EditText mBankLocation;
    Button mContinue;
    CheckBox mBankKigali,mAccessBank, mKcb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        mBankLocation = (EditText) findViewById(R.id.bank_location);
        mContinue = (Button) findViewById(R.id.btn_bank_location);
        mBankKigali = (CheckBox) findViewById(R.id.checkBox);
        mAccessBank = (CheckBox) findViewById(R.id.checkBox2);
        mKcb = (CheckBox) findViewById(R.id.checkBox3);

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = mBankLocation.getText().toString();
                Intent intent = new Intent(TopUpActivity.this, RetrieveDetailsActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}