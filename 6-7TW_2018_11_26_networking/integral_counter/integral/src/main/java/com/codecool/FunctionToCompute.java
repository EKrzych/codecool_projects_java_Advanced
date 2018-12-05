package com.codecool;

public class FunctionToCompute implements Function {


    @Override
    public double getValue(double x) {
        return x * x + 2 * x;
    }
}
