package cn.other;

/**
 * 项目名：Thread_Study01
 * 描述：不可重入锁，
 *弄懂了码？
 *
 * @author : Lpc
 * @date : 2019-06-16 22:01
 **/
public class LockTest2 {
    Lock lock = new Lock();
    public void a(){
        lock.lock();
        doSomething();
        lock.release();
    }
    //不可重入
    public void doSomething(){
        lock.lock();
        //!!!
        lock.release();
    }
    public static void main(String[] args) {
        LockTest2 test = new LockTest2();
        test.a();
        test.doSomething();
    }

}
class Lock{
    //是否占用
    private boolean isLocked = false;
    public void lock(){
       while (isLocked){
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           isLocked = true;
       }
    }
    public void release(){
        isLocked = false;
        notifyAll();

    }
}
