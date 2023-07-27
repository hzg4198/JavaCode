package homework;
import sun.dc.pr.PathStroker;
import sun.misc.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws Exception {
//        File f1 = new File("Test.txt");
//        File f2 = new File("D:\\Test\\");
//        String srcDir = "D:\\毕业论文";
////        copyFile(f1,f2);
//        File f3 = new File("F:\\Test.txt");
//        File f4 = new File("D:\\毕业论文");
//        File f5 = new File("F:\\copyTest");
//        copyFile(new File("Test.txt"),new File("F:\\Test.txt"));
//        copyDir(new File("D:\\毕业论文"),new File("F:\\copyTest"));
//        File file = new File(f5.getPath() ,f3.getName());
//        System.out.println(file);
//        boolean newFile = file.createNewFile();
        //-----------------------第四题----------------------
        /*File f6 = new File("sortNum.txt");//准备sortNum.txt文件
        OutputStream outputStream = Files.newOutputStream(f6.toPath());
        byte[] b = "2-1-9-4-7-8".getBytes();
        outputStream.write(b);*/
//        sortNum(f6);
        //----------------------GBK转utf-8---------------------------
        File gbkFile = new File("gbkText.txt");
//        readGBKTxt(gbkFile);
        //-----------------------按gbk字符集写入文件-----------------------------
        File writeFile = new File("writeGBK.txt");
//        writeGBKTxt(writeFile);
        //------------------------将gbk文件转为utf-8文件------------------
        File convUTF = new File("uff-8.txt");
//        convertGBKToUTF(gbkFile,convUTF);
        //--------------------------sortTxt------------------
        File sortTxt = new File("sortTxt");
  /*      FileWriter fileWriter = new FileWriter(sortTxt);//准备sortTxt文件
        fileWriter.write("1-君不见，黄河之水天上来，奔流到海不复回。\n" +
                "7-与君歌一曲，请君为我倾耳听。\n" +
                "4-天生我材必有用，千金散尽还复来。\n" +
                "11-主人何为言少钱，径须沽取对君酌。\n" +
                "6-岑夫子，丹丘生，将进酒，杯莫停。\n" +
                "8-钟鼓馔玉不足贵，但愿长醉不愿醒。\n" +
                "9-古来圣贤皆寂寞，惟有饮者留其名。\n" +
                "3-人生得意须尽欢，莫使金樽空对月。\n" +
                "2-君不见，高堂明镜悲白发，朝如青丝暮成雪。\n" +
                "10-陈王昔时宴平乐，斗酒十千恣欢谑。\n" +
                "12-五花马，千金裘，呼儿将出换美酒，与尔同销万古愁\n" +
                "5-烹羊宰牛且为乐，会须一饮三百杯。");
        fileWriter.close();*/
        sortTxt(sortTxt);
        //-----------------------Login-------------------------
//        login();
        //------------------------serialize--------------------
//        serializeObj();
//        deSerializeObj();
    }
    //复制文件
    public static void copyFile(File src ,File to) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(src.toPath()));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(to.toPath()));
        byte[] b = new byte[1024];
        int len;
        while((len = bufferedInputStream.read(b)) != -1){bufferedOutputStream.write(b,0,len);}
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
    //  拷贝文件夹
    public static void copyDir(File src ,File to) throws IOException {
        if(!to.exists()) to.mkdir();
        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if(file.isFile()){
                    copyFile(file ,new File(to.getPath() ,file.getName()));
                }else if(file.isDirectory()){
                    copyDir(file ,new File(to.getPath() ,file.getName()));
                }
            }
        }
    }
    //对文件中的数字排序
    public static void sortNum(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int len;
        while ((len = fileReader.read()) != -1) {
            if (Character.isDigit((char) len)) {
                list.add(Character.getNumericValue((char) len));
            }
        }
        list.stream().sorted().forEach(o -> stringBuilder.append(o).append("-"));
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(String.valueOf(stringBuilder));
        fileWriter.close();
        fileReader.close();
    }
    //读取gbk文件到控制台
    public static void readGBKTxt(File file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
        int len;
        while((len = inputStreamReader.read()) != -1){
            System.out.print((char) len);
        }
        fileInputStream.close();
        inputStreamReader.close();
    }
    //以GBK字符集写入
    public static void writeGBKTxt(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK");
        outputStreamWriter.write("哥们在这跟你说唱\n" +"理塘丁真\n" +"哥们儿名叫丁真");
        outputStreamWriter.close();
    }
    //gbk转uft-8
    public static void convertGBKToUTF(File fileGBK ,File fileUTF) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(fileGBK.toPath()),"GBK");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(fileUTF.toPath()), StandardCharsets.UTF_8);
        int len;
        while((len = inputStreamReader.read()) != -1){
            outputStreamWriter.write((char)len);
        }
        outputStreamWriter.close();
        inputStreamReader.close();
    }
    //sortTxt
    public static void sortTxt(File file) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> list = new ArrayList<>();
        String line;
        while((line = bufferedReader.readLine()) != null){
            list.add(line);
        }
        list.stream().sorted(Comparator.comparingInt(o -> Integer.parseInt(o.split("\\.")[0])))
                .forEach(System.out::println);
        bufferedReader.close();
    }
    //login
    public static void login() throws Exception {
        final String USER_NAME = "qiweikai";
        final String PASSWORD = "123456";
        Scanner sc = new Scanner(System.in);
        File file = new File("count.txt");
        //登录
        if(!file.exists()){//记录次数的文件第一次不存在则创建并且写入次数
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("3");
            fileWriter.close();
        }
        FileReader fileReader = new FileReader(file);
        int count = Character.getNumericValue((char) fileReader.read());
        fileReader.close();
        while(count > 0) {
            System.out.println("你还有"+count+"次登录机会");
            System.out.println("enter username:");
            String username = sc.next();
            System.out.println("enter password:");
            String password = sc.next();
            if (Objects.equals(USER_NAME, username) && Objects.equals(PASSWORD, password)) {
                System.out.println("LOGIN SUCCESS");
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("3");
                fileWriter.close();
                return;
            }else {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(String.valueOf(--count));
                fileWriter.close();
            }
        }
        System.out.println("已经登录过三次，没有登录机会了");
    }
    //serialize
    public static void serializeObj() throws IOException, ClassNotFoundException {
        List<Student> list = new ArrayList<>();
        ObjectOutputStream serialization = new ObjectOutputStream(Files.newOutputStream(Paths.get("serialization.properties")));
        Collections.addAll(list,new Student("张三",22,"成都"),new Student("李四",21,"南京")
        ,new Student("王五",25,"杭州"),new Student("丁真",23,"理塘"));
        serialization.writeObject(list);
        serialization.close();
    }
    //deserialize
    public static void deSerializeObj() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get("serialization.properties")));
        System.out.println(objectInputStream.readObject());
    }

}
