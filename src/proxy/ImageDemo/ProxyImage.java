//package proxy.ImageDemo;
////代理类
//public class ProxyImage implements Image{
//	//代理对象中应该存有原来对象的引用
//	private RealImage realImage;
//	private String fileName;
//
//	public ProxyImage(String filename) {
//		this.fileName = filename;
//	}
//
//	@Override
//	public void display() {
//		//如果是第一次访问img文件，则调用原对象的构造方法获得原对象 并存到代理对象中
//		if(realImage == null){
//			realImage = new RealImage(fileName);
//		}
//		//调用对象的展示方法
////		realImage.display();
//		System.out.println("通过代理对象增强展示图片："+fileName);
//	}
//}
