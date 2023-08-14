package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView Resulttv, solutions;
    MaterialButton BtnnC, Btnopenbracket, BtnClosebracket;
    MaterialButton Btn0, Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9;
    MaterialButton BtnAc, BtnDot;
    MaterialButton BtnADD, BtnMul, BtnSub, BtnDivide, BtnEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resulttv = findViewById(R.id.result);
        solutions = findViewById(R.id.Solution);

        // Initialize buttons and set click listeners
        assignId(BtnnC, R.id.button_c);
        assignId(Btnopenbracket, R.id.openbracket_btn);
        assignId(BtnClosebracket, R.id.closedbracket_button);
        assignId(Btn0, R.id.btn_0);
        assignId(Btn1, R.id.button_1);
        assignId(Btn2, R.id.btn_2);
        assignId(Btn3, R.id.btn_3);
        assignId(Btn4, R.id.button_4);
        assignId(Btn5, R.id.btn_5);
        assignId(Btn6, R.id.btn_6);
        assignId(Btn7, R.id.button_7);
        assignId(Btn8, R.id.btn_8);
        assignId(Btn9, R.id.btn_9);
        assignId(BtnDot, R.id.btn_dot);
        assignId(BtnAc, R.id.button_ac);
        assignId(BtnEqual, R.id.btn_equal);
        assignId(BtnSub, R.id.btn_Sub);
        assignId(BtnMul, R.id.btn_multiply);
        assignId(BtnADD, R.id.btn_Add);
        assignId(BtnDivide, R.id.divide_button);
    }

    void assignId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutions.getText().toString();
        if (buttonText.equals("AC")) {
            solutions.setText("");
            Resulttv.setText("0");
        } else if (buttonText.equals("=")) {
            solutions.setText(Resulttv.getText());
        } else if (buttonText.equals("C")) {
            if (dataToCalculate.length() > 0) {
                dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
            }
        } else {
            dataToCalculate = dataToCalculate + buttonText;
        }

        solutions.setText(dataToCalculate);
        //String finalResult = getResult(dataToCalculate);
       /* if (!finalResult.equals("Err")) {
            Resulttv.setText(finalResult);
        }*/}
    }

   /* String getResult(String data) {
        try {
            org.mozilla.javascript.Context rhino = org.mozilla.javascript.Context.enter();
            rhino.setOptimizationLevel(-1);
            Scriptable scope = rhino.initStandardObjects();
            Object result = rhino.evaluateString(scope, data, "javascript", 1, null);
            return org.mozilla.javascript.Context.toString(result);
        } catch (Exception e) {
            return "Err";
        } finally {
            org.mozilla.javascript.Context.exit();
        }
    }*/