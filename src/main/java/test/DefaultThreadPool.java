package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class DefaultThreadPool implements ThreadPool{

    // 线程池最大限制数    maximumPoolSize
    private static final int MAX_WORKER_NUMBERS = 10;

    private  static  final  int DEALUT_WORKER_NUMBERS = 5;

    //队列
    private LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    // 工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    DefaultThreadPool(int num){
            for(int i = 0 ; i< num ; i++){
                Worker work = new Worker();
                workers.add(work);
                 new Thread(work).start();
            }

    }

    DefaultThreadPool(){
       this(DEALUT_WORKER_NUMBERS);
    }


    @Override
    public void execute(Runnable job) {
        if( job == null){
            return;
        }
        synchronized (taskQueue){
                System.out.println("方法执行");
                taskQueue.add(job);
                taskQueue.notify();
        }
    }

    class Worker implements Runnable{

        private volatile boolean running = true;


        @Override
        public void run() {
            System.out.println("进入work");
            while (running) {
                    Runnable runnable = null;
                    synchronized (taskQueue){
                        if(taskQueue.isEmpty()){
                            try {
                                System.out.println("方法等待");
                                taskQueue.wait();
                                System.out.println("方法等待执行");
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }

                        }
                        runnable =  taskQueue.poll();

                    }
                if(runnable != null){
                    runnable.run();
                }

            }

        }
    }
    public static void main(String[] args) {

        ThreadPool pool = new DefaultThreadPool(2);
        pool.execute(() -> {
            for(int j = 0 ;j <= 1000;j++){
                System.out.println("鸡腿" + j);
                System.out.println(Thread.currentThread().getName());
            }

        });
        pool.execute(() -> {
            for(int j = 0 ;j <= 1000;j++){
                System.out.println("三明治 " + j);
                System.out.println(Thread.currentThread().getName());
            }

        });
        pool.execute(() -> {
            for(int j = 0 ;j <= 1000;j++){
            System.out.println("可乐 " + j);
            System.out.println(Thread.currentThread().getName());
        }
        });
        pool.execute(() -> {  for(int j = 0 ;j <= 1000;j++){
            System.out.println("牛奶 " + j);
            System.out.println(Thread.currentThread().getName());
        }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }

}