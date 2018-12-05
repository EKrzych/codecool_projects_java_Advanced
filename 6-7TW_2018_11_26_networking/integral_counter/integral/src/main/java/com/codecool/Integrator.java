package com.codecool;

import java.util.concurrent.Callable;

public class Integrator implements Callable {
    private Function f;
    private double start;
    private double end;
    private double step;



    public Integrator(Function f, double start, double end, double step) {
        this.f = f;
        this.start = start;
        this.end = end;
        this.step = step;
    }

    double integrateFunction() {
        double area = 0;
        for(double i = start; i + step <= end; i += step ) {
            area += f.getValue(i) * step;
        }
        return area;
    }

    @Override
    public Double call() throws Exception {
        return integrateFunction();
    }
}
