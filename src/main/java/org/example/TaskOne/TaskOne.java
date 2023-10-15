package org.example.TaskOne;

public class TaskOne {
    public static void main(String[] args) {
        Thread timeThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                long currentTime = System.currentTimeMillis();
                long time = (currentTime - startTime) / 1000;
                System.out.println(time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timeThread.start();
    }
}