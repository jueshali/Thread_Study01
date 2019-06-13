package com.cooperation;

/**
 * 项目名：Thread_Study01
 * 描述：信号灯法实现生产者和消费者
 *
 * @author : Lpc
 * @date : 2019-06-13 22:12
 **/
public class ProduceAndConsumer2 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }

}
class Player extends Thread{
    Tv tv;
    public Player(Tv tv){
        this.tv = tv;
    }
    @Override
    public void run(){
        for (int i = 0; i <20; i++) {
                 if (i%2==0){
                     tv.play("新闻");
                 }else {
                     tv.play("广告");
                 }
        }
    }
}
class Watcher extends Thread{
    Tv tv;
    public Watcher(Tv tv){
        this.tv = tv;
    }
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }

    }
}
class Tv{
    String voice;
    boolean flag = true;
    //为真表示演员表演，观众等待
    public synchronized void play(String voice){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.voice = voice;
        System.out.println("表演了"+voice);
        this.notifyAll();
        flag = !flag;
    }

    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("看了"+voice);
        this.notifyAll();
        flag = !flag;
    }
}
