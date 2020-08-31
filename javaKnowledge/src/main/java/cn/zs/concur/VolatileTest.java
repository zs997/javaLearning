package cn.zs.concur;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class VolatileTest {
    private static volatile int x = 0;
    public static void main(String args[]) throws InterruptedException {
//      new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //线程A
//                try {
//                    TimeUnit.MILLISECONDS.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                ints[0] = 2;
//            }
//        }).start();
        //volatile 不保证原子性 countDownLatch到0之前都会阻塞主线程
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //自增会引发并发安全问题
                  //  x++;
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
       // TimeUnit.SECONDS.sleep(3);
        System.out.println(x);

    }
}
