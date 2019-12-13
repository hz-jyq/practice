package test;

public interface ThreadPool {

    //执行一个任务(Job),这个Job必须实现Runnable
    void execute(Runnable job);
}
