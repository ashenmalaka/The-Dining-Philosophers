package com.company;

public class DiningPhilosophers {

    public static void main(String[] args) throws Exception {

        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for(int i = 0; i<forks.length; i++){
            forks[i] = new Object();
        }

        for(int j = 0; j<philosophers.length; j++){
            Object leftFork = forks[j];
            Object rightFrk = forks[(j+1) % forks.length];

            if(j == philosophers.length - 1){
                //The last philosopher picks up the right fork first
                philosophers[j] = new Philosopher(rightFrk, leftFork);
            }else{
                philosophers[j] = new Philosopher(leftFork, rightFrk);
            }

            Thread thread = new Thread(philosophers[j], "Philosopher " + (j+1));
            thread.start();
        }
    }
}
