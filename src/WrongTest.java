import java.lang.Thread;
/**
 * 项目名：Thread_Study01
 * 描述：指令重排测试
 *
 * @author : Lpc
 * @date : 2019-06-14 21:14
 **/
public class WrongTest {
    private static int a = 0;
    private static boolean flag = false;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            a = 0;
            flag =false;
            Thread t1 = new Thread(()->{
                a = 1;
                flag = true;
            });

            Thread t2 = new Thread(()->{
                if(flag){
                    a*=1;
                }
                if (a==0){
                    System.out.println("出现我就是出现了重排a->"+a);
                }
            });
            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
