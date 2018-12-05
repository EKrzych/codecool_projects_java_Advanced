package com.codecool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws InterruptedException {

        double start = Double.valueOf(args[0]);
        double end = Double.valueOf(args[1]);
        double step = Double.valueOf(args[2]);
        int threadNumber = Integer.valueOf(args[3]);
        double interval = (end - start) / threadNumber;

        Function function = new FunctionToCompute();

        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(threadNumber);
        List<Callable<Double>> todo = new ArrayList(threadNumber);


        for (double i = start; i < end; i += interval) {
            todo.add(new Integrator(function, i, i + interval, step));
        }

        List<Future<Double>> answers = executorService.invokeAll(todo);
        answers.stream().mapToDouble(f -> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return 0;
        }).sum();

        executorService.shutdownNow();

        long stopTime = System.currentTimeMillis();
        long time = stopTime - startTime;
        System.out.println("Time: " + time);
    }
}
