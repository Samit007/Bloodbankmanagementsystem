package com.example.bloodbankmanagementsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {
    CircleImageView imgProfile;
    TextView tvName,tvPhoneNo,tvEmail,tvAddress,tvGender,tvBlood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imgProfile=findViewById(R.id.imgProfile);
        tvName=findViewById(R.id.tvName);
        tvPhoneNo=findViewById(R.id.tvPhoneNo);
        tvEmail=findViewById(R.id.tvEmail);
        tvAddress=findViewById(R.id.tvAddress);
        tvBlood=findViewById(R.id.tvBlood);
        tvGender=findViewById(R.id.tvGender);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            imgProfile.setImageResource(bundle.getInt("image"));
            tvName.setText(bundle.getString("name"));
            tvPhoneNo.setText(bundle.getString("phone"));
            tvEmail.setText(bundle.getString("email"));
            tvAddress.setText(bundle.getString("address"));
            tvGender.setText(bundle.getString("gender"));
            tvBlood.setText(bundle.getString("blood"));
        }

    }
}

