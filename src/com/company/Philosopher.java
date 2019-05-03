package com.company;

public class Philosopher implements Runnable {

    //These are the folks on the dining table on either side of this Philospher
    private final Object leftFork;
    private final Object rightFork;

    Philosopher(Object left, Object right){
        this.leftFork = left;
        this.rightFork = right;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random()*100)));
    }

    @java.lang.Override
    public void run() {
        try{
            while(true){
                //Thinking what to do
                doAction(System.nanoTime() + ": Thinking");
                synchronized (leftFork) {
                    doAction(System.nanoTime() + ": Picked up left fork");
                    synchronized (rightFork) {
                        doAction(System.nanoTime() + ": Picked up right fork & started to eat");
                        doAction(System.nanoTime() + ": Put down right fork");
                    }
                    doAction(System.nanoTime() + ": Put down left fork & returned to start thinking again");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
