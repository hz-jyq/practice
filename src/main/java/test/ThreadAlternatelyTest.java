package test;


import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAlternatelyTest {
    private static  AtomicInteger i  = new AtomicInteger(0);
    private static Integer       threadLock  = new Integer(0);
    private static Integer       threadLock1 = new Integer(0);
    public static  Integer       count       = 0;
    public static  Integer       lock        = new Integer(0);

    public static void main(String[] args) throws InterruptedException {
       /* thread(1, threadLock).start();
        thread(2, threadLock1).start();
        synchronized (lock) {
            if (count != 2) {
                lock.wait();
            }
        }
        while (i.get() < 100) {
            synchronized (threadLock) {
                if (i.get() % 2 == 0) {
                    threadLock.notify();
                }
            }
            synchronized (threadLock1) {
                if (i.get() % 2 != 0) {
                    threadLock1.notify();
                }
            }
        }
        Thread.currentThread().sleep(1000000);*/


    }

    public static Thread thread(int number, Object object) throws InterruptedException {
        return new Thread(() ->
        {
            while (true) {
                synchronized (object) {
                    System.out.println("线程" + number + "启动");
                    try {
                        synchronized (lock) {
                            if (++count == 2 && count < 3) {
                                lock.notify();
                            }
                        }
                        object.wait();
                        System.out.println("线程" + number + "输出" + i.incrementAndGet());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}