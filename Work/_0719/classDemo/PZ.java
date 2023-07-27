package classDemo;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PZ {
    public static void main(String[] args) throws IOException {
        String xingUrl = "https://hanyu.baidu.com/shici/detail?from=kg1&highlight=&pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&srcid=51369";
        String mingUrl = "http://www.haoming8.cn/mingzi/8785.html";
        String xingStr = webCrawler(xingUrl);
        String mingStr = webCrawler(mingUrl);
//        System.out.println(xingStr);
//        System.out.println(mingStr);

        ArrayList<String> dataXing = getData(xingStr ,"(.{4})(，|。)",1);
        ArrayList<String> dataMing = getData(mingStr,"(..、){4}..",0);
//        System.out.println(dataXing);
        System.out.println(dataMing);
    }
    //通过正则找到真正想要的数据

    private static ArrayList<String> getData(String string, String regex ,int index) {
        ArrayList<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()){
            String group = matcher.group(index);
//            System.out.println(group);
            list.add(group);
        }
        return list;
    }

    /*
   从网络中爬取数据，把数据拼接成字符串返回
   形参:网址
   返回值：爬取到的所有数据
    */
    private static String webCrawler(String xingUrl) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        //创建一个url对象
        URL url = new URL(xingUrl);
        //链接上这个网站，并打开一个流把数据放到流里面
        InputStream isr = url.openConnection().getInputStream();
        InputStreamReader sira = new InputStreamReader(isr, StandardCharsets.UTF_8);
        int ch;
        while((ch = sira.read()) != -1){
            stringBuilder.append((char) ch);
        }
        sira.close();
        return stringBuilder.toString();
    }
}
