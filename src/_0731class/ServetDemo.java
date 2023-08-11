package _0731class;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class ServetDemo {
    public static void main(String[] args) throws Exception {
        boolean judge = true;
        while (judge) {
            ServerSocket ssjudge = new ServerSocket(12378);
            Socket acceptjudge = ssjudge.accept();
            BufferedReader brjudge = new BufferedReader(new InputStreamReader(acceptjudge.getInputStream()));
            brjudge.close();
            ssjudge.close();

            ServerSocket ss = new ServerSocket(12345);
            Socket accept = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            String flag = br.readLine().toString();
            String name = br.readLine().toString();
            String time = br.readLine().toString();
            File file1 =new File(name+"upload\\");
            File[] listFiles = file1.listFiles();
            String date= Arrays.toString(listFiles);
            if (flag.equals("upload")) {
                File file = new File(name + "upload");
                if (!file.exists()) {//如果文件夹不存在
                    file.mkdir();//创建文件夹
                }
                BufferedWriter bw = new BufferedWriter(new FileWriter(name + "upload" + "\\" + time + "copy.txt"));
                String line;
                while ((line = br.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                    bw.flush();
                }
                BufferedWriter bwServer=new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                bwServer.write("上传成功");
                bwServer.newLine();
                bwServer.flush();
                br.close();
                bw.close();
                ss.close();
            } else if (flag.equals("download")) {
                ss.close();
                Socket s = new Socket("192.168.1.107", 10086);
                File file = new File(name + "upload" + "\\" + time + "copy.txt");
                if (!file.exists()) {
                    s.close();
                } else {
                    BufferedReader br1 = new BufferedReader(new FileReader(name + "upload" + "\\" + time + "copy.txt"));
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                    String line;
                    while ((line = br1.readLine()) != null) {
                        bw.write(line);
                        bw.newLine();
                        bw.flush();
                    }
                    bw.close();
                    s.shutdownOutput();
                    br.close();
                    s.close();
                }
            }else if(flag.equals("uploadOther")){
                ss.close();
                ServerSocket s = new ServerSocket(12346);
                Socket a = s.accept();
                BufferedInputStream bis;
                bis = new BufferedInputStream(a.getInputStream());
                //本地流io流，把数据写道本地文件中，实现永久存储
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(name+"upload\\"+time));
                int b;
                while ((b = bis.read()) != -1) {
                    bos.write(b);
                }
                bos.flush();
                bos.close();
                s.close();
            } else if (flag.equals("downloadOther")) {
                ss.close();
                Socket scoket=new Socket("192.168.1.107",12347);
                File file=new File(time);
                if(!file.exists()){
                    scoket.close();
                }else {
                    BufferedInputStream fis=new BufferedInputStream(new FileInputStream(time));
                    //获取网络中的流
                    OutputStream outputStream = scoket.getOutputStream();
                    BufferedOutputStream bos=new BufferedOutputStream(outputStream);
                    int b;
                    while((b=fis.read())!=-1){
                        bos.write(b);
                    }
                    scoket.shutdownOutput();
                    fis.close();
                    scoket.close();
                }

            } else if (flag.equals("showzhangwu")) {
                File file = new File(name + "upload");
                if (!file.exists()) {//如果文件夹不存在
                }else {
                    BufferedWriter bwServer=new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                    bwServer.write(date);
                    bwServer.newLine();
                    bwServer.flush();
                    br.close();
                    ss.close();
                }

            } else if (flag.equals("showfile")) {
                File file = new File(name + "upload");
                if (!file.exists()) {//如果文件夹不存在
                }else {
                    File[] listFiles1 = file.listFiles();
                    String date1= Arrays.toString(listFiles1);
                    BufferedWriter bwServer=new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                    bwServer.write(date1);
                    bwServer.newLine();
                    bwServer.flush();
                    br.close();
                    ss.close();
                }
            }
        }
    }
}
