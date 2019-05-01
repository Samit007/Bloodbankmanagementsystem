package com.example.bloodbankmanagementsystem;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Fragments.LoginPage;
import Fragments.RegisterPage;

import static com.example.bloodbankmanagementsystem.R.id.fragmentContainer;

public class MainActivity extends AppCompatActivity {
    private Button btnSearch, btnFrag;
    private Integer status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Search_blood.class);
                startActivity(intent);
            }
        });
        btnFrag=findViewById(R.id.btnLoginpage);
        btnFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (status == 0) {
                    LoginPage loginFragment = new LoginPage();
                    fragmentTransaction.replace(fragmentContainer, loginFragment);
                    fragmentTransaction.commit();
                    btnFrag.setText("Register Form");
                    status = 1;
                }else if(status==1) {
                    RegisterPage registerPage=new RegisterPage();
                    fragmentTransaction.replace(fragmentContainer, registerPage);
                    fragmentTransaction.commit();
                    btnFrag.setText("Login Form");
                    status = 0;
                }
            }
        });
    }
}
