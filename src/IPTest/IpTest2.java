package IPTest;

import java.net.InetSocketAddress;

/**
 * 项目名：Thread_Study01
 * 描述：端口 0-65535 同一个协议下不能冲突，
 * 1、区分软件
 * 2、定义端口越大越号
 * 8080 comcat
 * 1521 orcal
 *
 *
 * @author : Lpc
 * @date : 2019-06-23 22:33
 **/
public class IpTest2 {
    public static void main(String[] args) {

        InetSocketAddress socketAddress = new InetSocketAddress("localhost",9000);
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getPort());

    }
}
