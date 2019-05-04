package Fragments;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bloodbankmanagementsystem.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import Helper.MyHelper;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

public class RegisterPage extends Fragment {
    private EditText etFullname, etPhoneNo, etEmail, etAddres, etUsername, etPassword, etPassword2;
    private Spinner etGender, etBloodGroup;
    private Button btnRegister, btnReset;
    private ImageView btnImage, btnPhoto;
    Bitmap bitmap;
    View view;
    ByteArrayOutputStream byteArrayOutputStream;
    File file;
    FileOutputStream fileOutputStream;

    public RegisterPage() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_register_page, container, false);
        etFullname = view.findViewById(R.id.etFullname);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        etPassword2 = view.findViewById(R.id.etPassword2);
        etPhoneNo = view.findViewById(R.id.etPhoneNo);
        etEmail = view.findViewById(R.id.etEmail);
        etAddres = view.findViewById(R.id.etAddress);
        etGender = view.findViewById(R.id.etGender);
        etBloodGroup = view.findViewById(R.id.etBloodgroup);
        btnRegister = view.findViewById(R.id.btnRegister);
        btnImage = view.findViewById(R.id.btnImg);
        btnPhoto = view.findViewById(R.id.btnPhoto);
        byteArrayOutputStream = new ByteArrayOutputStream();
        checkPermission();

        final MyHelper myHelper = new MyHelper(getActivity());
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = etPassword.getText().toString();
                String pass2 = etPassword.getText().toString();
                if (!isEmpty()) {
                    login();
                }

            }

            private void login() {
                String pass = etPassword.getText().toString();
                String pass2 = etPassword.getText().toString();
                if (pass.equals(pass2)) {
                    SignUp();
                } else {
                    Toast.makeText(getActivity(), "wrong username or password", Toast.LENGTH_SHORT).show();
                }

            }


            private void SignUp() {
                long id = myHelper.InsertData(etFullname.getText().toString(),etUsername.getText().toString()
                        ,etPassword.getText().toString(),etEmail.getText().toString(),
                        etPhoneNo.getText().toString(), etAddres.getText().toString(),etGender.getSelectedItem().toString(),
                        etBloodGroup.getSelectedItem().toString(), sqLiteDatabase);
                if (id>0){
                    Toast.makeText(getActivity(), "Successfully registered", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }

    private boolean isEmpty() {
        if (TextUtils.isEmpty((etFullname.getText().toString()))) {
            etFullname.setError("Please enter Name");
            etFullname.requestFocus();
            return true;
        } else if (TextUtils.isEmpty((etUsername.getText().toString()))) {
            etUsername.setError("Please enter Username");
            etUsername.requestFocus();
            return true;
        } else if (TextUtils.isEmpty((etPassword.getText().toString()))) {
            etPassword.setError("Please enter Password");
            etPassword.requestFocus();
            return true;
        }else if (TextUtils.isEmpty((etPassword2.getText().toString()))) {
            etPassword2.setError("Please enter Password");
            etPassword2.requestFocus();
            return true;
        }else if (TextUtils.isEmpty((etPhoneNo.getText().toString()))) {
            etPhoneNo.setError("Please enter Phone number");
            etPhoneNo.requestFocus();
            return true;
        }else if (TextUtils.isEmpty((etEmail.getText().toString()))) {
            etEmail.setError("Please enter Email id");
            etEmail.requestFocus();
            return true;
        }else if (TextUtils.isEmpty((etAddres.getText().toString()))) {
            etAddres.setError("Please enter Address");
            etAddres.requestFocus();
            return true;
        }
        return false;
    }


    private void loadCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, 1);
    }


    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 0);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            btnImage.setImageBitmap(imageBitmap);
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 60, byteArrayOutputStream);

            file = new File(Environment.getExternalStorageDirectory() + "DCIM/BloodBank/SampleImage.png");

            try {
                file.createNewFile();

                fileOutputStream = new FileOutputStream(file);

                fileOutputStream.write(byteArrayOutputStream.toByteArray());

                fileOutputStream.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

            Toast.makeText(getActivity(), "Image Saved Successfully", Toast.LENGTH_LONG).show();

        }
    }
}

//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("User", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putString("username", etUsername.getText().toString());
//        editor.putString("password", etPassword.getText().toString());
//        editor.putString("name", etFullname.getText().toString());
//        editor.putString("phone", etPhoneNo.getText().toString());
//        editor.putString("email", etEmail.getText().toString());
//        editor.putString("address", etAddres.getText().toString());
//        editor.putString("gender", etGender.getSelectedItem().toString());
//        editor.putString("blood", etBloodGroup.getSelectedItem().toString());
//
//        editor.commit();
//
//        Toast.makeText(getActivity(), "Successfully registered", Toast.LENGTH_SHORT).show();


