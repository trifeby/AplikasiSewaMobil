package com.trifeby.aplikasisewamobil;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText txtEmail, txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail= findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);

        btnLogin = findViewById(R.id.btn_login);
    }

    // Empty Validation
    private boolean emptyError() {
        boolean empty = false;
        if (txtEmail.getText().toString().isEmpty()) {
            empty = true;
            txtEmail.setError("Harus diisi!");
        }
        if (txtPassword.getText().toString().isEmpty()) {
            empty = true;
            txtPassword.setError("Data harus diisi!");
        }

        return empty;
    }

    public void login(View v) {
        if(!emptyError()) {
            Toast.makeText(
                    getApplicationContext(),
                    txtEmail.getText() + "\n" + txtPassword.getText(),
                    Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putString("email", txtEmail.getText().toString());
            bundle.putString("password", txtPassword.getText().toString());

            Intent i = new Intent(this,DashboardActivity.class);
            i.putExtras(bundle);
            startActivity(i);
        }
    }

    public void a_register(View v) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    public  void a_forgotpassword(View v) {

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
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
