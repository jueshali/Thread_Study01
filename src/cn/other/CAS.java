package cn.other;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 项目名：Thread_Study01
 * 描述：乐观锁的比较并交换
 *  Atomic是使用了CAS的操作
 * @author : Lpc
 * @date : 2019-06-16 22:22
 **/
public class CAS {
    private static AtomicInteger stock = new AtomicInteger(5);
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = stock.decrementAndGet();
                if (left<1){
                    System.out.println("抢完了");
                    return;
                }
                System.out.println(Thread.currentThread().getName()+"抢了一件");
                System.out.println("剩下"+left);
            }).start();

        }
    }
}
