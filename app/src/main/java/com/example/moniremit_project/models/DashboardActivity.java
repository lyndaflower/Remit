package com.example.moniremit_project.models;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.moniremit_project.R;
import com.example.moniremit_project.topUp.CardActivity;
import com.example.moniremit_project.topUp.TopUpActivity;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    CardView topUp;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    CardView sendMoney;

    CardView statements;
    CardView quotation;

    //    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        topUp = findViewById(R.id.top_up);
        sendMoney = findViewById(R.id.send_money);
        statements = findViewById(R.id.statements);
        quotation = findViewById(R.id.quotation);

//        Set onclick listener on card view

        sendMoney.setOnClickListener(this::onClick);
        statements.setOnClickListener(this::onClick);
        quotation.setOnClickListener(this::onClick);

        topUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_bus:
                Intent intent = new Intent(DashboardActivity.this, TopUpActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_login:
                menu.findItem(R.id.nav_logout).setVisible(true);
                menu.findItem(R.id.nav_profile).setVisible(true);
                menu.findItem(R.id.nav_login).setVisible(false);
                break;
            case R.id.nav_logout:
                menu.findItem(R.id.nav_logout).setVisible(false);
                menu.findItem(R.id.nav_profile).setVisible(false);
                menu.findItem(R.id.nav_login).setVisible(true);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v == sendMoney) {
            Intent send_money = new Intent(DashboardActivity.this, SendMoneyActivity.class);
            startActivity(send_money);
            finish();
        }
        if (v == statements) {
            Intent statement = new Intent(DashboardActivity.this, TopUpActivity.class);
            startActivity(statement);
            finish();
        }
        if (v == quotation) {
            Intent quotations = new Intent(DashboardActivity.this, TopUpActivity.class);
            startActivity(quotations);
            finish();
        }
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(DashboardActivity.this);
        alertDialog.setTitle("How would you like to top up your wallet");
        String[] items = {"Credit/Debit Card", "Bank(instant EFT)", "Agent"};
        boolean[] checkedItems = {false, false, false, false, false, false};
        alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                switch (which) {
                    case 0:
                        if (isChecked) {
                            Toast.makeText(DashboardActivity.this, "Clicked on Credit/Debit Card", Toast.LENGTH_LONG).show();
                            Intent card = new Intent(DashboardActivity.this, CardActivity.class);
                            startActivity(card);
                            finish();
                        }
                        break;
                    case 1:
                        if (isChecked)
                            Toast.makeText(DashboardActivity.this, "Clicked on Bank(instant EFT)", Toast.LENGTH_LONG).show();
                        Intent card = new Intent(DashboardActivity.this, TopUpActivity.class);
                        startActivity(card);
                        finish();
                        break;
                    case 2:
                        if (isChecked)
                            Toast.makeText(DashboardActivity.this, "Clicked on Agent", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }
}