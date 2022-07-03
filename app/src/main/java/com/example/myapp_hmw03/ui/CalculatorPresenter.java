package com.example.myapp_hmw03.ui;

import android.icu.number.NumberFormatter;

import com.example.myapp_hmw03.model.Calculator;
import com.example.myapp_hmw03.model.Calculatormpl;
import com.example.myapp_hmw03.model.Operator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CalculatorPresenter {

    private final DecimalFormat formater = new DecimalFormat("#.##");

    private CalculatorView view;
    private Calculator calculator;

    private double argOne;
    private Double argTwo;

    private Operator selectOperator;

    public CalculatorPresenter (CalculatorView view, Calculator calculator){
        this.view = view;
        this.calculator = calculator;
    }


    public void onDigitPress(int digit) {


        if (argTwo == null) {

            argOne = argOne * 10 + digit;

            showFormatter(argOne);

        } else  {
            argTwo = argTwo * 10 + digit;

            showFormatter(argTwo);
        }

    }

    public void onOperatorPress(Operator operator) {

        if (selectOperator != null){
            argOne = calculator.perform(argOne,argTwo,selectOperator);

            showFormatter(argOne);
        }
            argTwo = 0.0;

        selectOperator = operator;


    }

    public void onDotPressed() {

    }

    private void showFormatter(double value){
        view.showResult(formater.format(value));
    }
}
