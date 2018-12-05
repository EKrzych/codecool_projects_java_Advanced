package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class TimerContainer {
    List<Timer> timersList = new ArrayList<>();


    public void handleTimers(String input) {
        String[] inputFromUser = input.split(" ");
        String operation = input;
        String threadName = null;

        if(inputFromUser.length == 2) {
            operation = inputFromUser[0].toLowerCase();
            threadName = inputFromUser[1];
        }
        switch (operation) {
            case "start":
                startNewTimer(threadName);
                break;
            case "check":
                checkTimers(threadName);
                break;
            case "stop":
                stopTimer(threadName);
                break;
        }
    }

    private void stopTimer(String threadName) {
        for(Timer t : timersList) {
            if(t.getThread().getName().equalsIgnoreCase(threadName)) {
                t.mysuspend();
            }
        }
    }

    private void checkTimers(String threadName) {
        if(threadName != null) {
            timersList.stream().filter(n -> n.getThread().getName().equals(threadName)).map(n -> n.check()).forEach(System.out::println);
        } else {
            getAllTimers();
        }
    }

    private void startNewTimer(String threadName) {
        for(Timer t : timersList) {
            if(t.getThread().getName().equalsIgnoreCase(threadName)) {
                t.myresume();
                return;
            }
        }
        Timer timer = new Timer(threadName);
        timersList.add(timer);
    }

    public void getAllTimers() {
        timersList.stream().map(n -> n.check()).forEach(System.out ::println);
    }

    public void stopAllTimers() {
        for(Timer t : timersList) {
            t.mystop();
        }
    }

}
