package sync;

import genc.Inter;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.stream.Stream;

public class SynchoronizedDemo {
    //synchronized 修饰非静态方法
    public synchronized void function() throws InterruptedException {
        for (int i=0; i < 3; i++){
            Thread.sleep(1000);
            System.out.println("function running...");
        }
    }

    public static void startFunction() throws InterruptedException {
        for (int i=0;i< 3;i++){
            Thread.sleep(1000);
            System.out.println("Static function running...");
        }
    }

    public static void main(String[] args){
        final SynchoronizedDemo demo =new SynchoronizedDemo();
        //创建线程执行静态方法 1.23    7.1
        Thread t1 = new Thread(()->{
            try {
                startFunction();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });


        //创建线程执行非静态方法
        Thread t2 =new Thread(()->{
            try {
                demo.function();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    @Test
    public void run(){
        String str="my name is 007";
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);
    }
}
