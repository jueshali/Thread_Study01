package cn.other;

/**
 * 项目名：Thread_Study01
 * 描述 分析上下文，起点
 * 1、构造器，哪里调用，就属于哪里
 * 2、非构造器就是本线程自身的
 * @author : Lpc
 * @date : 2019-06-16 21:31
 **/
public class ThreadLocalTest02 {
    //private static ThreadLocalL<Integer> threadLocalL = new ThreadLocal<Integer>();
    /**
     *更改初始化的值
     **/
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->{
        return 200;
    });
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"d"+threadLocal.get());
        new Thread(new MyRun()).start();
    }
    public static class MyRun implements Runnable{
        public MyRun(){
            //是main的注意上下文
            threadLocal.set(100);
            System.out.println(Thread.currentThread().getName()+"d"+threadLocal.get());
        }
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName()+"d"+threadLocal.get());
        }
    }
}
