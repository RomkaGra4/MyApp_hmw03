package com.example.myapp_hmw03.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp_hmw03.R;
import com.example.myapp_hmw03.model.Calculatormpl;
import com.example.myapp_hmw03.model.Operator;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements CalculatorView {


    private TextView resultTxt;

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTxt = findViewById(R.id.total);

        presenter = new CalculatorPresenter(this, new Calculatormpl());

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);
        digits.put(R.id.key_0, 0);


        View.OnClickListener digitclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDigitPress(digits.get(view.getId()));
            }
        };

        findViewById(R.id.key_1).setOnClickListener(digitclickListener);
        findViewById(R.id.key_2).setOnClickListener(digitclickListener);
        findViewById(R.id.key_3).setOnClickListener(digitclickListener);
        findViewById(R.id.key_4).setOnClickListener(digitclickListener);
        findViewById(R.id.key_5).setOnClickListener(digitclickListener);
        findViewById(R.id.key_6).setOnClickListener(digitclickListener);
        findViewById(R.id.key_7).setOnClickListener(digitclickListener);
        findViewById(R.id.key_8).setOnClickListener(digitclickListener);
        findViewById(R.id.key_9).setOnClickListener(digitclickListener);
        findViewById(R.id.key_0).setOnClickListener(digitclickListener);

        Map<Integer, Operator> operators = new HashMap<>();
        operators.put(R.id.key_plus, Operator.ADD);
        operators.put(R.id.key_minus, Operator.SUB);
        operators.put(R.id.key_mult, Operator.MULT);
        operators.put(R.id.key_div, Operator.DIV);


        View.OnClickListener operatorClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOperatorPress(operators.get(view.getId()));
            }
        };

        findViewById(R.id.key_plus).setOnClickListener(operatorClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operatorClickListener);
        findViewById(R.id.key_mult).setOnClickListener(operatorClickListener);
        findViewById(R.id.key_div).setOnClickListener(operatorClickListener);

        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
                                                          @Override
                                                          public void onClick(View view) {
                                                              presenter.onDotPressed();
                                                          }
                                                      }
        );

    }

    @Override
    public void showResult(String total) {
        resultTxt.setText(total);
    }
}