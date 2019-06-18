package cn.other;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

  /**
 * 项目名：Thread_Study01
 * 描述：
 *
 * @author : Lpc
 * @date : 2019-06-14 20:21
 **/
public class TimerTest01 {
        public static void main(String[] args) {
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run "+ System.currentTimeMillis());
                }
            }, 0, 100, TimeUnit.MILLISECONDS);
        }

}





















