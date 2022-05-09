package com.company.lld;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class RateLimiterToken {

    /*We can start with the concept in rate limiting holding 5 tokens capacity
     * And the bucket is being filled at 1token/second
     *  */

    public static void main(String[] args) throws InterruptedException {

        setCapacity(5);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                try {
                    getToken();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }


    static int currentToken = 0;
    static int maxToken;
    static long lastTimeStamp = System.currentTimeMillis();

    static void setCapacity(int size) {
        maxToken = size;
    }

    static synchronized void getToken() throws InterruptedException {
        long currentDifferenceInSeconds = (System.currentTimeMillis() - lastTimeStamp) / 1000;
        System.out.println("CurrentDifference: "+currentDifferenceInSeconds);
        currentToken += currentDifferenceInSeconds;

        if (currentToken > maxToken) {
            currentToken = maxToken;
        }
        if (currentToken == 0) {
            Thread.sleep(1000);
        } else {
            currentToken = currentToken - 1;
        }
        System.out.println("Current Token Count: "+currentToken);
        lastTimeStamp = System.currentTimeMillis();
        System.out.println("Granting " + Thread.currentThread().getName() + " token at " + (System.currentTimeMillis() / 1000));
    }


}
