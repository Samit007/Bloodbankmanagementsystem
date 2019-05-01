package com.example.bloodbankmanagementsystem;

import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {
    CircleImageView imgProfile,tvImage;
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


        SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        String Name=sharedPreferences.getString("name","");
        tvName.setText(Name);
          String Phone=sharedPreferences.getString("phone","");
        tvPhoneNo.setText(Phone);
          String Email=sharedPreferences.getString("email","");
        tvEmail.setText(Email);
          String Address=sharedPreferences.getString("address","");
        tvAddress.setText(Address);
          String Gender=sharedPreferences.getString("gender","");
        tvGender.setText(Gender);
          String Blood=sharedPreferences.getString("blood","");
        tvBlood.setText(Blood);
//        String image=sharedPreferences.getString("gender","");
//        imgProfile.setImageResource(Integer.parseInt(image));


        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            imgProfile.setImageResource(bundle.getInt("image"));
        }

    }
}

