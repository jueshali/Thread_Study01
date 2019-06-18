package cn.other;

/**
 * 项目名：Thread_Study01
 * 描述：每个线程自身的存储区域,更改不会影响其他线程
 *get set initial
 * @author : Lpc
 * @date : 2019-06-16 21:31
 **/
public class ThreadLocalTest01 {
    //private static ThreadLocalL<Integer> threadLocalL = new ThreadLocal<Integer>();
    /**
     *更改初始化的值
     **/
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->{
        return 200;
    });
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"d"+threadLocal.get());
        new Thread(()->{
            threadLocal.set(10);
            System.out.println(Thread.currentThread().getName()+"d"+threadLocal.get());
        }).start();
    }
}
