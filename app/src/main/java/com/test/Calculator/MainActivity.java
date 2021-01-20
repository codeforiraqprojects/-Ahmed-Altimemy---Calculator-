package com.test.Calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUserName,txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUserName=(EditText) findViewById(R.id.txtUserName);
        txtPassword=(EditText) findViewById(R.id.txtPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
    }
    public void Login(View v)
    {
        if (!txtUserName.getText().toString().equals("") && !txtPassword.getText().toString().equals("")) {
            if (txtUserName.getText().toString().equals("ahmed") && txtPassword.getText().toString().equals("1010")) {
                Intent intent = new Intent(MainActivity.this, MainActivityMain.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "User Name And/Or Password Incorrect", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Please Fill User Name And Password Fields", Toast.LENGTH_SHORT).show();
        }
    }
}
