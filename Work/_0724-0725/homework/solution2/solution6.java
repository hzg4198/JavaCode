package homework.solution2;


import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;

//使用多线程实现多个文件同步复制功能，并在控制台显示复制的进度，进度以百分比表示。
public class solution6 {
	public static void main(String[] args) {
		CopyFile f1 = new CopyFile("gbkText.txt", "b1.txt");
		CopyFile f2 = new CopyFile("gbkText.txt", "b2.txt");
		CopyFile f3 = new CopyFile("gbkText.txt", "b3.txt");
		new Thread(f1,"复制任务一").start();
		new Thread(f2,"复制任务二").start();
		new Thread(f3,"复制任务三").start();
	}

	static class CopyFile implements Runnable{
		private File srcFile;
		private File destFile;

		public CopyFile(String srcFile, String destFile) {
			this.srcFile = new File(srcFile);
			this.destFile = new File(destFile);
		}
		//复制方法
		@Override
		public void run() {
			try {
				String name = Thread.currentThread().getName();
				FileInputStream fileInputStream = new FileInputStream(srcFile);
				FileOutputStream fileOutputStream = new FileOutputStream(destFile);
				long length = srcFile.length();//获取源文件大小
				double temp = 0;//已经复制的大小
				int len;//每次传输的字节大小
				byte[] b = new byte[new Random().nextInt(100)+50];
				System.out.println(name+"的源文件大小为"+length);
				DecimalFormat fd = new DecimalFormat("##%");
				while ((len = fileInputStream.read(b))!=-1){
					Thread.sleep(1000);
					fileOutputStream.write(b,0,len);
					temp += len;
					double d = temp / length;
					System.out.println(name+"已经复制了"+fd.format(d));
				}
				System.out.println(name+"--复制完成");
			} catch (IOException | InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
