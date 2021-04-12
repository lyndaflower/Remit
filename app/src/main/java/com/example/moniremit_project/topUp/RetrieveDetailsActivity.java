package com.example.moniremit_project.topUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.moniremit_project.R;

public class RetrieveDetailsActivity extends AppCompatActivity {
public static final String TAG = RetrieveDetailsActivity.class.getSimpleName();
    private TextView mLocationTextView;
    Button mContBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_details);

        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        mContBtn =(Button) findViewById(R.id.btn_cont);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText(":Bank name " + location);

        mContBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}