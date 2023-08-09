package proxy.ImageDemo;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
	public static void main(String[] args) {
		Image realImage = new RealImage("preview.jpg");
		Image proxyImage = new ProxyImage("preview.jpg");


		realImage.display();
		System.out.println("-------------");
		// 图像将从磁盘加载
		proxyImage.display();
		System.out.println("------------");
		// 图像不需要从磁盘加载
		proxyImage.display();
/*		RealImage realImage = new RealImage("preview.jpg");
		Image imgInstance =(Image) Proxy.newProxyInstance(realImage.getClass().getClassLoader(),
				new Class[]{Image.class}, new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if(method.getName().equals("display")){
							System.out.print("通过动态代理调用display:");
						}
						return method.invoke(realImage, args);
					}
				});
		imgInstance.display();*/
	}
}
