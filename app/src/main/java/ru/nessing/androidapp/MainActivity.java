package ru.nessing.androidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String SAVED = "SAVED";
    private TextView fieldInput;
    private String out = "";
    private float result;
    private boolean oneOperation, negativeNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fieldInput = findViewById(R.id.fieldInput);

        oneOperation = false;
        negativeNum = false;

        Button button = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button button0 = findViewById(R.id.button_zero);
        Button buttonDecimal = findViewById(R.id.button_decimal);

        Button buttonCancel = findViewById(R.id.button_cancel);
        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_divide);
        Button buttonEquals = findViewById(R.id.button_equals);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonDecimal.setOnClickListener(this);

        buttonCancel.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED, out);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fieldInput.setText(savedInstanceState.getString(SAVED));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_1) {
            out += 1;
            fieldInput.setText(out);
        } else if (view.getId() == R.id.button_2) {
            out += 2;
            fieldInput.setText(out);
        } else if (view.getId() == R.id.button_3) {
            out += 3;
            fieldInput.setText(out);
        } else if (view.getId() == R.id.button_4) {
            out += 4;
            fieldInput.setText(out);
        } else if (view.getId() == R.id.button_5) {
            out += 5;
            fieldInput.setText(out);
        } else if (view.getId() == R.id.button_6) {
            out += 6;
            fieldInput.setText(out);
        } else if (view.getId() == R.id.button_7) {
            out += 7;
            fieldInput.setText(out);
        } else if (view.getId() == R.id.button_8) {
            out += 8;
            fieldInput.setText(out);
        } else if (view.getId() == R.id.button_9) {
            out += 9;
            fieldInput.setText(out);
        } else if (view.getId() == R.id.button_zero) {
            out += 0;
            fieldInput.setText(out);
        } else if (view.getId() == R.id.button_decimal) {
            out += ".";
            fieldInput.setText(out);

            // operations
        } else if (view.getId() == R.id.button_multiply) {
            if (!oneOperation && out.length() >= 1 && !negativeNum || !oneOperation && out.length() >= 3 && negativeNum) {
                out += " * ";
                fieldInput.setText(out);
                oneOperation = true;
            }
        } else if (view.getId() == R.id.button_divide) {
            if (!oneOperation && out.length() >= 1 && !negativeNum || !oneOperation && out.length() >= 3 && negativeNum) {
                out += " / ";
                fieldInput.setText(out);
                oneOperation = true;
            }

        } else if (view.getId() == R.id.button_plus) {
            if (!oneOperation && out.length() >= 1 && !negativeNum || !oneOperation && out.length() >= 3 && negativeNum) {
                out += " + ";
                fieldInput.setText(out);
                oneOperation = true;
            }
        } else if (view.getId() == R.id.button_minus) {
            if (out.length() <= 1) {
                out += " -";
                fieldInput.setText(out);
                negativeNum = true;
            }
            else if (!oneOperation) {
                out += " - ";
                fieldInput.setText(out);
                oneOperation = true;
            }
        }
        else if (view.getId() == R.id.button_equals) {
            String[] arr = out.trim().split(" ");
            try {
                if (arr[1].equals("+")) {
                    result = Float.parseFloat(arr[0]) + Float.parseFloat(arr[2]);
                } else if (arr[1].equals("-")) {
                    result = Float.parseFloat(arr[0]) - Float.parseFloat(arr[2]);
                } else if (arr[1].equals("*")) {
                    result = Float.parseFloat(arr[0]) * Float.parseFloat(arr[2]);
                } else if (arr[1].equals("/")) {
                    result = Float.parseFloat(arr[0]) / Float.parseFloat(arr[2]);
                }
                fieldInput.setText(String.valueOf(result));
                out = String.valueOf(result);
                oneOperation = false;
                negativeNum = false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("expression don't right");
            }

        } else if (view.getId() == R.id.button_cancel) {
            out = "";
            fieldInput.setText(out);
            oneOperation = false;
            negativeNum = false;
        }
    }
}