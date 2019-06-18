package cn.other;

/**
 * 项目名：Thread_Study01
 * 描述 InheritableThreadLocal继承上下文的数据。
 * 1、构造器，哪里调用，就属于哪里
 * 2、非构造器就是本线程自身的
 * @author : Lpc
 * @date : 2019-06-16 21:31
 **/
public class ThreadLocalTest03 {
   // private static ThreadLocalL<Integer> threadLocalL = new InheritableThreadLocal<Integer>();
//    /**
//     *继承上文的数据，拷贝一份，以后再不影响；
//     **/
   private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->{
       return 200;    });
    public static void main(String[] args) {

       // System.out.println(Thread.currentThread().getName() + "d" + threadLocalL.get());

        new Thread(() -> {
            //System.out.println(Thread.currentThread().getName() + "d" + threadLocalL.get());
        }).start();
    }
}


