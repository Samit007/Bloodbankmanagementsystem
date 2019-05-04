package com.example.bloodbankmanagementsystem;

import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {
    CircleImageView imgProfile, tvImage;
    TextView tvName, tvPhoneNo, tvEmail, tvAddress, tvGender, tvBlood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
//        imgProfile=findViewById(R.id.imgProfile);
        tvName = findViewById(R.id.tvName);
        tvPhoneNo = findViewById(R.id.tvPhoneNo);
        tvEmail = findViewById(R.id.tvEmail);
        tvAddress = findViewById(R.id.tvAddress);
        tvBlood = findViewById(R.id.tvBlood);
        tvGender = findViewById(R.id.tvGender);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tvName.setText(bundle.getString("fullname"));
            tvPhoneNo.setText(bundle.getString("phoneNo"));
            tvEmail.setText(bundle.getString("email"));
            tvAddress.setText(bundle.getString("address"));
            tvGender.setText(bundle.getString("gender"));
            tvBlood.setText(bundle.getString("blood"));
        }
    }
}

