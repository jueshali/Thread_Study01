package cn.other;

/**
 * 项目名：Thread_Study01
 * 描述：DCL单例模式
 * 套路，在多线程环境下，对外存在一个对象
 * 1、构造器私有化，避免外部New构造器
 * 2、提供私有的静态属性，存储对象地址
 * 3、提供公共的静态方法，获取属性。
 * 懒汉式
 *
 * @author : Lpc
 * @date : 2019-06-16 21:13
 **/
public class DoubleCheckedLocking {
    /*
    加入volatile防止指令重排，没有volatile其他线程可能访问一个没有初始化的对象
     */
    private static volatile DoubleCheckedLocking instance;
    private DoubleCheckedLocking(){



    }
    public static DoubleCheckedLocking getInstance(){
        //double checking
        if (instance != null) {
            return instance;
        }

        synchronized (DoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLocking();
                    //开辟空间，初始化对象信息，返回对象的地址给引用
                }
            }
            return instance;
        }
        //为防止多个线程同时创建


    public static void main(String[] args) {

    }
}
