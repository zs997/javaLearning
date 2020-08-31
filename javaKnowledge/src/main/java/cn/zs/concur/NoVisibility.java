package cn.zs.concur;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.locks.ReentrantLock;

public class NoVisibility {
      private static boolean ready;
      private static int number;
      private static class ReaderThread extends Thread {
              @Override
             public void run() {
                     while(!ready) {
                             Thread.yield();
                         }
                   System.out.println(number);
              }
     }
     private static class MyThread extends Thread{
         @Override
         public void run() {
             try {
                 Thread.sleep(1000);
                 System.out.println("111111111");
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
     public static void test1() throws Exception {
         ReaderThread readerThread = new ReaderThread();
         readerThread.start();

         //调用该线程句柄的join  使调用者处于waited状态
         readerThread.join(100);
         number = 42;
         ready = true;
         //wait 由锁对象调用 该线程拿到锁之后 可以调用
         //使得该线程让出锁 等待状态
         ReentrantLock reentrantLock = new ReentrantLock();
         reentrantLock.lock();
         reentrantLock.wait();
         reentrantLock.unlock();
         Object o = new Object();
         // o.wait();
         synchronized (o){
             o.wait();
         }
     }
     public static void main(String[] args) throws Exception {
         MyThread myThread = new MyThread();
         myThread.start();
         //主线程使用join 等待myThread执行完毕 否则一直处于waited，还可以设置等待多久
         myThread.join(100);
         System.out.println("222222222222");


     }
 }
