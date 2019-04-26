package com.example.bloodbankmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvIncorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        etUsername = findViewById(R.id.etUsernamelogin);
        etPassword = findViewById(R.id.etPasswordlogin);
        tvIncorrect=findViewById(R.id.tvIncorrect);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = etUsername.getText().toString();
                String pWord = etPassword.getText().toString();
                if (!isEmpty()) {
                    if (uName.equals("admin") && pWord.equals( "admin")) {
                        Intent intent = new Intent(LoginPage.this, Dashboard.class);
                        startActivity(intent);
                    }else {
                        tvIncorrect.setText("incorrect username or password");
                        tvIncorrect.setError("");
                        tvIncorrect.requestFocus();
                        return;
                    }

                }
            }
        });
    }

    private boolean isEmpty() {
        if (TextUtils.isEmpty((etUsername.getText().toString()))) {
            etUsername.setError("Please enter Username");
            etUsername.requestFocus();
            return true;
        } else if (TextUtils.isEmpty((etPassword.getText().toString()))) {
            etPassword.setError("Please enter Password");
            etPassword.requestFocus();
            return true;
        }
        return false;
    }
}
