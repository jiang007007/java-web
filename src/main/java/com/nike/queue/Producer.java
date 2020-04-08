package com.nike.queue;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    //true   生产者一直执行,false  停掉生产者
    private volatile boolean isRunning =true;
    //公共资源
    private final Vector sharedQueue;

    private final  int SIZE;


    private static AtomicInteger count = new AtomicInteger();

    public Producer(Vector sharedQueue,int SIZE){
        this.sharedQueue =sharedQueue;
        this.SIZE =SIZE;
    }
    @Override
    public void run() {
        int data =0;
        Random r = new Random();
        try {
            while (isRunning){
                Thread.sleep(r.nextInt(1000));
                //当队列满时阻塞
                while (sharedQueue.size() ==SIZE){
                    synchronized (sharedQueue){
                        sharedQueue.wait();
                    }
                }
                synchronized (sharedQueue){
                    data =count.incrementAndGet();
                    sharedQueue.add(data);
                    System.out.println("producer create data: " + sharedQueue.size());
                    sharedQueue.notifyAll();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
