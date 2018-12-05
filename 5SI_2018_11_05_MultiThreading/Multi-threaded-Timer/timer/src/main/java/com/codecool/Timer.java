package com.codecool;

public class Timer implements Runnable {
    private Thread thread;
    int time;
    boolean suspended;
    boolean stopped;

    public Timer(String timerName) {
        thread = new Thread(this, timerName);
        suspended = false;
        stopped = false;
        thread.start();

    }

    public String check() {
        return "Name: " + thread.getName() + ", ThreadId: " + thread.getId() + ", Seconds: " + this.time;
    }

   public void run() {
        while(true) {
            try {
                thread.sleep(1000);
                this.time++;
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if(stopped) {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(thread.getName() + " received interrupt while sleeping");
            }
        }
    }

    public Thread getThread() {
        return thread;
    }

    synchronized void mystop() {
        stopped = true;
        suspended = false;
        notify();
    }

    synchronized void mysuspend() {
        suspended = true;
    }

    synchronized void myresume() {
        suspended = false;
        notify();
    }


}
