package ru.nessing.androidapp;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Buttons extends AppCompatActivity implements View.OnClickListener {

    private TextView fieldInput;
    private String out = "";
    private Calculations calculations;

    private final int[] numberButtonIds = new int[]{
            R.id.button_1, R.id.button_2, R.id.button_3,
            R.id.button_4, R.id.button_5, R.id.button_6,
            R.id.button_7, R.id.button_8, R.id.button_9,
            R.id.button_zero, R.id.button_decimal, R.id.button_cancel,
            R.id.button_plus, R.id.button_minus, R.id.button_multiply,
            R.id.button_decimal, R.id.button_divide, R.id.button_equals
    };

    protected void create(MainActivity mainActivity) {
        calculations = new Calculations();

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

        setNumberButtonIdsListeners(mainActivity);
    }

    private void setNumberButtonIdsListeners(MainActivity mainActivity) {
        for (int i = 0; i < numberButtonIds.length; i++) {
            mainActivity.findViewById(numberButtonIds[i]).setOnClickListener(this);
        }
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
            if (calculations.decimal(out.length())) {
                out += ".";
                fieldInput.setText(out);
            }

            // operations
        } else if (view.getId() == R.id.button_multiply) {
            if (calculations.multiply(out.length())) {
                out += " * ";
                fieldInput.setText(out);
            }
        } else if (view.getId() == R.id.button_divide) {
            if (calculations.divide(out.length())) {
                out += " / ";
                fieldInput.setText(out);
            }

        } else if (view.getId() == R.id.button_plus) {
            if (calculations.plus(out.length())) {
                out += " + ";
                fieldInput.setText(out);
            }
        } else if (view.getId() == R.id.button_minus) {
            out += calculations.minus(out.length());
            fieldInput.setText(out);
        } else if (view.getId() == R.id.button_equals) {
            try {
                fieldInput.setText(String.valueOf(calculations.equals(out)));
                out = String.valueOf(calculations.equals(out));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("expression don't right");
                fieldInput.setText("expression don't right");
                out = "";
                calculations.clean();
            } catch (NumberFormatException e) {
                System.err.println("incorrect expression");
                fieldInput.setText("incorrect expression");
                out = "";
                calculations.clean();
            }

        } else if (view.getId() == R.id.button_cancel) {
            out = "";
            fieldInput.setText(out);
            calculations.clean();
        }
    }
}
