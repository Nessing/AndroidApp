package ru.nessing.androidapp;


public class Calculations {

    private boolean oneOperation = false;
    private boolean negativeNum = false;
    private boolean decimal = false;
    private boolean decimalSecond = false;
    private float result = 0;

    public boolean decimal(int outLength) {
        if (!decimal && outLength >= 1 && !negativeNum || !oneOperation && outLength >= 3 && negativeNum || decimalSecond) {
            this.decimal = true;
            this.decimalSecond = false;
            return true;
        }
        return false;
    }

    public boolean multiply(int outLength) {
        if (!oneOperation && outLength >= 1 && !negativeNum || !oneOperation && outLength >= 3 && negativeNum) {
            this.oneOperation = true;
            this.decimal = false;
            this.decimalSecond = true;
            return true;
        } else return false;
    }

    public boolean divide(int outLength) {
        if (!oneOperation && outLength >= 1 && !negativeNum || !oneOperation && outLength >= 3 && negativeNum) {
            this.oneOperation = true;
            this.decimal = false;
            this.decimalSecond = true;
        }
        return false;
    }

    public boolean plus(int outLength) {
        if (!oneOperation && outLength >= 1 && !negativeNum || !oneOperation && outLength >= 3 && negativeNum) {
            this.oneOperation = true;
            this.decimal = false;
            this.decimalSecond = true;
            return true;
        }
        return false;
    }

    public String minus(int outLength) {

        if (outLength < 1) {
            this.negativeNum = true;
            return " -";
        } else if (!oneOperation) {
            this.oneOperation = true;
            this.decimalSecond = true;
            return " - ";
        }
        return "";
    }

    public String equals(String str) {
        String[] arr = str.trim().split(" ");
        String outResult;
        if (arr[1].equals("+")) {
            this.result = Float.parseFloat(arr[0]) + Float.parseFloat(arr[2]);
        } else if (arr[1].equals("-")) {
            this.result = Float.parseFloat(arr[0]) - Float.parseFloat(arr[2]);
        } else if (arr[1].equals("*")) {
            this.result = Float.parseFloat(arr[0]) * Float.parseFloat(arr[2]);
        } else if (arr[1].equals("/")) {
            this.result = Float.parseFloat(arr[0]) / Float.parseFloat(arr[2]);
        }
        outResult = String.valueOf(result);
        if (outResult.endsWith(".0")) {
            outResult = outResult.replace(".0", "");
        }
        clean();
        return outResult;
    }

    public void clean() {
        this.oneOperation = false;
        this.negativeNum = false;
        this.decimal = false;
        this.decimalSecond = false;
        this.result = 0;
    }

}
