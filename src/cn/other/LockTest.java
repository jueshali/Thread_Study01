package cn.other;

/**
 * 项目名：Thread_Study01
 * 描述：可重用锁
 *
 * @author : Lpc
 * @date : 2019-06-16 21:59
 **/
public class LockTest {
    public void test(){
        synchronized (this){
            while (true){
                synchronized (this){
                    System.out.println("reLock");
                }
            }
        }
    }

    public static void main(String[] args) {
        new LockTest().test();
    }
}
