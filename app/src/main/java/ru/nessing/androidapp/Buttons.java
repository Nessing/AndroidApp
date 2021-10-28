package ru.nessing.androidapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Buttons extends AppCompatActivity implements View.OnClickListener {

    private TextView fieldInput;
    private String out = "";
    private float result;
    private boolean oneOperation, negativeNum, decimal, decimalSecond;
    private Button button1, button2, button3, button4,
            button5, button6, button7, button8,
            button9, button0, buttonDecimal, buttonCancel,
            buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEquals;


    protected void create(MainActivity mainActivity) {
        oneOperation = false;
        negativeNum = false;
        decimal = false;
        decimalSecond = false;

        button1 = mainActivity.findViewById(R.id.button_1);
        button2 = mainActivity.findViewById(R.id.button_2);
        button3 = mainActivity.findViewById(R.id.button_3);
        button4 = mainActivity.findViewById(R.id.button_4);
        button5 = mainActivity.findViewById(R.id.button_5);
        button6 = mainActivity.findViewById(R.id.button_6);
        button7 = mainActivity.findViewById(R.id.button_7);
        button8 = mainActivity.findViewById(R.id.button_8);
        button9 = mainActivity.findViewById(R.id.button_9);
        button0 = mainActivity.findViewById(R.id.button_zero);
        buttonDecimal = mainActivity.findViewById(R.id.button_decimal);

        buttonCancel = mainActivity.findViewById(R.id.button_cancel);
        buttonPlus = mainActivity.findViewById(R.id.button_plus);
        buttonMinus = mainActivity.findViewById(R.id.button_minus);
        buttonMultiply = mainActivity.findViewById(R.id.button_multiply);
        buttonDivide = mainActivity.findViewById(R.id.button_divide);
        buttonEquals = mainActivity.findViewById(R.id.button_equals);
        createButtons(mainActivity);
    }

    public TextView getFieldInput() {
        return fieldInput;
    }

    public String getOut() {
        return out;
    }

    private void createButtons(MainActivity mainActivity) {
        fieldInput = mainActivity.findViewById(R.id.fieldInput);

        button1.setOnClickListener(this);
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
            if (!decimal && out.length() >= 1 && !negativeNum || !oneOperation && out.length() >= 3 && negativeNum || decimalSecond) {
                out += ".";
                fieldInput.setText(out);
                decimal = true;
                decimalSecond = false;
            }

            // operations
        } else if (view.getId() == R.id.button_multiply) {
            if (!oneOperation && out.length() >= 1 && !negativeNum || !oneOperation && out.length() >= 3 && negativeNum) {
                out += " * ";
                fieldInput.setText(out);
                oneOperation = true;
                decimal = false;
                decimalSecond = true;
            }
        } else if (view.getId() == R.id.button_divide) {
            if (!oneOperation && out.length() >= 1 && !negativeNum || !oneOperation && out.length() >= 3 && negativeNum) {
                out += " / ";
                fieldInput.setText(out);
                oneOperation = true;
                decimal = false;
                decimalSecond = true;
            }

        } else if (view.getId() == R.id.button_plus) {
            if (!oneOperation && out.length() >= 1 && !negativeNum || !oneOperation && out.length() >= 3 && negativeNum) {
                out += " + ";
                fieldInput.setText(out);
                oneOperation = true;
                decimal = false;
                decimalSecond = true;
            }
        } else if (view.getId() == R.id.button_minus) {
            if (out.length() < 1) {
                out += " -";
                fieldInput.setText(out);
                negativeNum = true;
            } else if (!oneOperation) {
                out += " - ";
                fieldInput.setText(out);
                oneOperation = true;
                decimalSecond = true;
            }
        } else if (view.getId() == R.id.button_equals) {
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

                setDefaultFlags();

            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("expression don't right");
            } catch (NumberFormatException e) {
                System.err.println("incorrect expression");
                fieldInput.setText("");
                out = "";
                result = 0;

                setDefaultFlags();
            }

        } else if (view.getId() == R.id.button_cancel) {
            out = "";
            fieldInput.setText(out);
            result = 0;
            setDefaultFlags();
        }
    }

    private void setDefaultFlags() {
        oneOperation = false;
        negativeNum = false;
        decimal = false;
        decimalSecond = false;
    }
}
