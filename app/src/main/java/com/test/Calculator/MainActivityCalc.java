package com.test.Calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.fathzer.soft.javaluator.DoubleEvaluator;

public class MainActivityCalc extends AppCompatActivity {
    private String op = "";
    private EditText txtView,txtWrite;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnCE,btnC,btnDot,btnDivision,btnMultiplication,btnAddition,btnSubtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maincalc);
        txtView=(EditText)findViewById(R.id.txtView);
        txtWrite=(EditText)findViewById(R.id.txtWrite);
        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btnCE=(Button)findViewById(R.id.btnCE);
        btnC=(Button)findViewById(R.id.btnC);
        btnDot=(Button)findViewById(R.id.btnDot);
        btnDivision=(Button)findViewById(R.id.btnDivision);
        btnMultiplication=(Button)findViewById(R.id.btnMultiplication);
        btnAddition=(Button)findViewById(R.id.btnAddition);
        btnSubtraction=(Button)findViewById(R.id.btnSubtraction);
    }


    // Anonymous implementation of OnClickListener
        public void getButtonID(View v) {

            Button b = (Button)v;
            String btntxt = b.getText().toString();

            String txtW = txtWrite.getText().toString();

            String txtV = txtView.getText().toString();

            switch (v.getId()) {
                case R.id.btnCE:
                    txtWrite.setText("");
                    op = "";
                    break;
                case R.id.btnC:
                    txtWrite.setText("");
                    txtView.setText("");
                    break;
                case R.id.btnDivision:
                case R.id.btnMultiplication:
                case R.id.btnSubtraction:
                case R.id.btnAddition:
                    if (!txtWrite.getText().toString().equals("")) {
                        if (btntxt.equals("/") || btntxt.equals("*") || btntxt.equals("-")
                                || btntxt.equals("+") || !btntxt.equals(".")) {

                            txtWrite.setText("");

                            op = b.getText().toString();

                            //txtV = txtW.toString();

                            txtView.setText(txtV + txtW + op);

                        }
                    }
                    break;
                case R.id.btnDot:
                case R.id.btn0:
                case R.id.btn1:
                case R.id.btn2:
                case R.id.btn3:
                case R.id.btn4:
                case R.id.btn5:
                case R.id.btn6:
                case R.id.btn7:
                case R.id.btn8:
                case R.id.btn9:
                    txtW = txtW + btntxt;
                    txtWrite.setText(txtW);
                    break;

                case R.id.btnEqual:
                    if (!txtWrite.getText().equals("")) {
                        txtWrite.setText("");
                        txtView.setText(txtV + txtW);
                        String expression = txtView.getText().toString();
                        Double result = new DoubleEvaluator().evaluate(expression);
                        txtView.setText(result.toString());
                    }
                    break;
                default:
                    break;

            }

        }

    public void BackToMain(View v)
    {
//        Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivityCalc.this,MainActivityMain.class);
        startActivity(intent);
    }

}
