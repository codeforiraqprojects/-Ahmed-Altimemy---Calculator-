package com.test.Calculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivityMain extends AppCompatActivity {
    private Intent intent ;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);
        builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
    }
    public void onClick(View v)
    {
        Button btnLogout = (Button)  findViewById(R.id.btnLogout);
        RadioButton rbAbout = (RadioButton) findViewById(R.id.rbAbout);
        RadioButton rbCalculator = (RadioButton) findViewById(R.id.rbCalculator);
        ToggleButton tbtn = (ToggleButton) findViewById(R.id.tbtn);

        boolean  rbChecked = false;
        boolean  tbtnChecked = false;
        switch(v.getId()) {
            case R.id.rbAbout:
                Toast.makeText(getApplicationContext(), "HI", Toast.LENGTH_SHORT).show();
                rbChecked = ((RadioButton) v).isChecked();
                if (rbChecked)
                    //if AboutActivate is selected
                    intent = new Intent(MainActivityMain.this, MainActivityAbout.class);
                    startActivity(intent);
                break;
            case R.id.rbCalculator:
                rbChecked = ((RadioButton) v).isChecked();
                if (rbChecked)
                    //if CalculatorActivate is selected
                    intent = new Intent(MainActivityMain.this, MainActivityCalc.class);
                    startActivity(intent);
                break;
            case R.id.tbtn:
                    //if ToogleButton is Pressed
                tbtnChecked = ((ToggleButton) v).isChecked();
                if (tbtnChecked) {
                    rbAbout.setEnabled(true);
                    rbCalculator.setEnabled(true);
                }
                    else {
                    rbAbout.setEnabled(false);
                    rbCalculator.setEnabled(false);
            }
                break;
        }
    }

    public void Logout(View v)
    {
        //Uncomment the below code to Set the message and title from the strings.xml file
        builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
        //Setting message manually and performing action on button click
        builder.setMessage("Do you want to Logout ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        intent = new Intent(MainActivityMain.this,MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Logout");
        alert.show();
    }
}
