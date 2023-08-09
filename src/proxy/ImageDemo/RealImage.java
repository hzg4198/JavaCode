package proxy.ImageDemo;

//接口实现类 也就是原对象类
public class RealImage implements Image {
	//文件名
	private String fileName;
	//构造方法
	public RealImage(String fileName) {
		this.fileName = fileName;
		//因为是实体类直接访问img对象 所以每次都要从磁盘里加载img文件
		loadFromDisk(fileName);
	}
	//
	private void loadFromDisk(String fileName) {
		System.out.println("从磁盘加载 " + fileName);
	}

	@Override
	public void display() {
		System.out.println("展示 " + fileName);
	}
}
