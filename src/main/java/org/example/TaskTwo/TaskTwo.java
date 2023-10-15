package org.example.TaskTwo;

public class TaskTwo {
    private int n;
    private int current;
    private final Object lock = new Object();

    public TaskTwo(int n) {
        this.n = n;
        this.current = 1;
    }

    public void fizz() {
        synchronized (lock) {
            while (current <= n) {
                try {
                    if (current % 3 == 0 && current % 5 != 0) {
                        System.out.println("fizz");
                        current++;
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void buzz() {
        synchronized (lock) {
            while (current <= n) {
                try {
                    if (current % 3 != 0 && current % 5 == 0) {
                        System.out.println("buzz");
                        current++;
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 15;
        TaskTwo taskTwo = new TaskTwo(n);

    }
}
