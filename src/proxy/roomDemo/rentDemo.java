package proxy.roomDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class rentDemo {
    public static void main(String[] args) {
//        UserServiceProxy userServiceProxy = new UserServiceProxy();
//        userServiceProxy.rent();


        UserServiceImpl fangDong = new UserServiceImpl();
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(rentDemo.class.getClassLoader(),
                new Class[]{UserService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态代理开始");
                        System.out.println("通过中介租房");
                        System.out.println("通过中介收押金");
                        fangDong.rent();
                        return null;
                    }
                });
        proxyInstance.rent();
    }
}
