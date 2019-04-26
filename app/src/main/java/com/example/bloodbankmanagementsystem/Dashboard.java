package com.example.bloodbankmanagementsystem;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends Activity {
    private TextView tvusernameinlogin,tvuserdetail,name;
    private Button btnUpdateDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tvusernameinlogin=findViewById(R.id.tvusernameinlogin);
        tvuserdetail=findViewById(R.id.tvuserdetail);
        btnUpdateDetail=findViewById(R.id.btnUpdateDetail);
        name=findViewById(R.id.etUsername);
//       String fname= name.getText().toString();
       tvusernameinlogin.setText("Welcome "+name);

    }
}
