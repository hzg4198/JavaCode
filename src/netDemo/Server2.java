package netDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server2 {
    public static void main(String[] args) {
        server();
    }

    public static void server() {
        try (ServerSocket ss = new ServerSocket(12346)) {
            System.out.println("服务器已启动，等待客户端连接...");

            while (true) {
                Socket accept = ss.accept();
                System.out.println("客户端连接成功：");

                Thread clientHandlerThread = new Thread(() -> {
                    try (InputStream inputStream = accept.getInputStream();
                         BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                         BufferedWriter bwServer = new BufferedWriter(
                                 new OutputStreamWriter(accept.getOutputStream()))) {

                        String request = br.readLine();
                        System.out.println(request);

                        if ("upload".equals(request)) {
                            String username = br.readLine();
                            String filename = br.readLine();
                            String fileLength = br.readLine();
                            File userDir = new File("user_files/" + username);
                            System.out.println(username + "请求上传：" + filename + "\t文件大小：" + fileLength);

                            if (!userDir.exists()) {
                                userDir.mkdirs();
                            }

                            String filePath = "user_files/" + username + "/" + filename;
                            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
                            BufferedInputStream fis = new BufferedInputStream(accept.getInputStream());

                            byte[] buffer = new byte[1024];
                            int length;
                            long totalLength = Long.parseLong(fileLength);
                            long bytesRead = 0;

                            while ((length = fis.read(buffer)) != -1) {
                                bos.write(buffer, 0, length);
                                bos.flush();
                                bytesRead += length;
                            }
                            System.out.println("已接收：" + (double) bytesRead / totalLength * 100 + "%");
                            bos.close();

                            bwServer.write("上传成功");
                            bwServer.newLine();
                            bwServer.flush();

                        } else if ("download".equals(request)) {
                            String username = br.readLine();
                            File userDir = new File("user_files/" + username);
                            File[] listFiles = userDir.listFiles();
                            int num = 0;
                            for (File file : listFiles) {
                                if (file.isFile() && file.getName().endsWith("txt")) {
                                    num++;
                                }
                            }

                            bwServer.write(num + "");
                            bwServer.newLine();
                            bwServer.flush();

                            for (File file : listFiles) {
                                if (file.isFile() && file.getName().endsWith("txt")) {
                                    bwServer.write(file.getName() + " 文件大小:" + file.length());
                                    bwServer.newLine();
                                    bwServer.flush();
                                }
                            }

                            String filename = br.readLine();
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            System.out.println(username + "请求下载" + filename);
                            String filePath = "user_files/" + username + "/" + filename;
                            File file = new File(filePath);

                            if (file.exists()) {
                                bwServer.write(file.length() + "");
                                bwServer.newLine();
                                bwServer.flush();

                                try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file))) {
                                    byte[] buffer = new byte[1024];
                                    int bytesRead;
                                    long totalLength = file.length();
                                    long bytesReadCount = 0;

                                    while ((bytesRead = fis.read(buffer)) != -1) {
                                        accept.getOutputStream().write(buffer, 0, bytesRead);
                                        bytesReadCount += bytesRead;
                                    }
                                    System.out.println("已发送：" + (double) bytesReadCount / totalLength);
                                }

                            } else {
                                System.out.println(filename + "不存在");
                                bwServer.write("dontexist");
                                bwServer.newLine();
                                bwServer.flush();
                            }

                        } else if ("downloadfile".equals(request)) {
                            String username = br.readLine();
                            File userDir = new File("user_files/" + username);
                            File[] listFiles = userDir.listFiles();
                            int num = 0;
                            for (File file : listFiles) {
                                if (file.isFile() && file.getName().endsWith("")) {
                                    num++;
                                }
                            }

                            bwServer.write(num + "");
                            bwServer.newLine();
                            bwServer.flush();

                            for (File file : listFiles) {
                                if (file.isFile() && file.getName().endsWith("")) {
                                    bwServer.write(file.getName() + " 文件大小:" + file.length());
                                    bwServer.newLine();
                                    bwServer.flush();
                                }
                            }

                            String filename = br.readLine();
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            System.out.println(username + "请求下载" + filename);
                            String filePath = "user_files/" + username + "/" + filename;
                            File file = new File(filePath);

                            if (file.exists()) {
                                bwServer.write(file.length() + "");
                                bwServer.newLine();
                                bwServer.flush();

                                try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file))) {
                                    byte[] buffer = new byte[1024];
                                    int bytesRead;
                                    long totalLength = file.length();
                                    long bytesReadCount = 0;

                                    while ((bytesRead = fis.read(buffer)) != -1) {
                                        accept.getOutputStream().write(buffer, 0, bytesRead);
                                        bytesReadCount += bytesRead;
                                        System.out.println("已发送：" + (double) bytesReadCount / totalLength);
                                    }
                                }

                            } else {
                                System.out.println(filename + "不存在");
                                bwServer.write("dontexist");
                                bwServer.newLine();
                                bwServer.flush();
                            }

                        }

                        System.out.println("处理完成");

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            accept.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                clientHandlerThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
