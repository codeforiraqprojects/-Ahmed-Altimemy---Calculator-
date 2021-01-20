package com.test.Calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivityAbout extends AppCompatActivity {

    private Button btnBackToMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_about);
        btnBackToMain=(Button)findViewById(R.id.btnLogout);
        
    }

        public void onClick (View v)
        {

        }

    public void BackToMain(View v)
    {
        Intent intent = new Intent(MainActivityAbout.this,MainActivityMain.class);
        startActivity(intent);
    }
}
