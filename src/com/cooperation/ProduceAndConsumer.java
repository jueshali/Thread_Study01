package com.cooperation;

/**
 *项目名：生产者消费者管道法
 * 描述：多线程，容器{存取——无空间  并发——等待}，操作馒头
 * @author : Lpc
 * @date : 2019-06-13 21:
 **/
public class ProduceAndConsumer {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
        this.container = container;
    }
    @Override
    public void run(){
        //生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产第--》"+i+"个馒头");
            container.push(new Steamedbun(i));
        }
    }

}
//消费者
class Consumer extends Thread{

    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("消费");
            System.out.println("消费第--》"+container.pop().id+"个馒头");

        }
    }
}
//缓冲区
class SynContainer{
    Steamedbun[] buns = new Steamedbun[10];
    int count = 0;
    //存
    public synchronized void push(Steamedbun bun){
        //容器存在空间生产
        if (count==buns.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count++] = bun;
        this.notifyAll();
    }
    //获取
    public synchronized Steamedbun pop(){
        //容器中存在才能消费
        if (count == 0){
            try {
                this.wait();//线程阻塞，生产者通知消费结束阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        this.notifyAll();
        return buns[count];
    }
}
//馒头
class Steamedbun{
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
}