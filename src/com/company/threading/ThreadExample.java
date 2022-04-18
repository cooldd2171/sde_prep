package com.company.threading;


import java.util.Random;
import java.util.concurrent.*;

public class ThreadExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ThreadA threadA=new ThreadA();
//        threadA.run();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        FutureTask[] futureTasks=new FutureTask[5];
        for(int i=0;i<5;i++){
            Callable callable=new CallableA();
            futureTasks[i]=new FutureTask(callable);
            executor.execute(futureTasks[i]);
        }
        for (int i=0;i<5;i++){
            System.out.println(futureTasks[i].get());
        }
        executor.shutdown();

    }

    public static class CallableA implements Callable{

        @Override
        public Object call() throws Exception {
            Random generator = new Random();
            int randomNumber = generator.nextInt(5);

            Thread.sleep( 10000);

            return randomNumber;
        }
    }
    
    public static class ThreadA extends Thread{
        @Override
        public void run() {
           for (int i=0;i<10;i++){
               System.out.println("value of i: "+i);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }
}


