package com.example.bloodbankmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnRegisterpage,btnLoginpage,btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegisterpage=findViewById(R.id.btnRegisterpage);
        btnLoginpage=findViewById(R.id.btnLoginpage);
        btnSearch=findViewById(R.id.btnSearch);
        btnRegisterpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, RegisterPage.class);
            startActivity(intent);
            }
        });
        btnLoginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Search_blood.class);
                startActivity(intent);
            }
        });
    }
}
