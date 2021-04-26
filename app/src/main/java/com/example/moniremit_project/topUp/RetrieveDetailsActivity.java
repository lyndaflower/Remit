package com.example.moniremit_project.topUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moniremit_project.R;
import com.example.moniremit_project.models.DashboardActivity;

public class RetrieveDetailsActivity extends AppCompatActivity {
public static final String TAG = RetrieveDetailsActivity.class.getSimpleName();
    private TextView mLocationTextView , mBankName;
    Button mContBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_details);

        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        mContBtn = (Button) findViewById(R.id.btn_cont);
        mBankName = (TextView) findViewById(R.id.bank_name);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        String kigaliBank = intent.getStringExtra("kigaliBank");
        mLocationTextView.setText(":Bank name " + location);
        mBankName.setText("kigaliBank" + kigaliBank);

        mContBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( v == mContBtn){
                    Intent intent = new Intent(RetrieveDetailsActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}