package com.trifeby.aplikasisewamobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "Register";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private EditText txtEmail, txtPassword, txtconfirmPassword, txtFullName, txtBirthdate, txtTelepon;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);
        txtconfirmPassword = findViewById(R.id.txt_confirm_password);
        txtFullName = findViewById(R.id.txt_fullname);
        txtBirthdate = findViewById(R.id.txt_birthdate);
        txtTelepon = findViewById(R.id.txt_telepon);
        btnDaftar = findViewById(R.id.btn_daftar);
    }

    private boolean isValidEmaillId(String email){
        return Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+").matcher(email).matches();
    }

    // Empty Validation
    private boolean emptyError() {
        boolean empty = false;
        if (txtEmail.getText().toString().isEmpty()) {
            empty = true;
            txtEmail.setError("Data tidak boleh kosong!");
        }
        if (txtPassword.getText().toString().isEmpty()) {
            empty = true;
            txtPassword.setError("Data tidak boleh kosong!");
        }
        if (txtconfirmPassword.getText().toString().isEmpty()) {
            empty = true;
            txtconfirmPassword.setError("Data tidak boleh kosong!");
        }
        if (txtFullName.getText().toString().isEmpty()) {
            empty = true;
            txtFullName.setError("Data tidak boleh kosong!");
        }
        if (txtBirthdate.getText().toString().isEmpty()) {
            empty = true;
            txtBirthdate.setError("Data tidak boleh kosong!");
        }
        if (txtTelepon.getText().toString().isEmpty()) {
            empty = true;
            txtTelepon.setError("Data tidak boleh kosong!");
        }

        //Email Validation
        if (!isValidEmaillId(txtEmail.getText().toString().trim())) {
            txtEmail.setError("Email Tidak Valid!");
        }

        return empty;
    }

    public void register(View v) {
        if(!emptyError()) {
            Toast.makeText(
                    getApplicationContext(),
                    txtEmail.getText() + "\n" + txtFullName.getText() + "\n" + txtTelepon.getText(),
                    Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putString("email", txtEmail.getText().toString());
            bundle.putString("nama", txtFullName.getText().toString());
            bundle.putString("telepon", txtTelepon.getText().toString());

            Intent i = new Intent(this,LoginActivity.class);
            i.putExtras(bundle);
            startActivity(i);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
