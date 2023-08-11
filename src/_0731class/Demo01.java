package _0731class;

import sun.net.spi.nameservice.dns.DNSNameService;

public class Demo01 {
    public static void main(String[] args) {
        ClassLoader classLoader = DNSNameService.class.getClassLoader();
        System.out.println(classLoader);
    }
}
