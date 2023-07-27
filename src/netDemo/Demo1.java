package netDemo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println(ip1.getHostName());
        System.out.println(ip1.getHostAddress());
        System.out.println("-------------------------");

        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostAddress());
//        System.out.println(ip2.getHostName());
        System.out.println(ip2.isReachable(6000));
    }
}
