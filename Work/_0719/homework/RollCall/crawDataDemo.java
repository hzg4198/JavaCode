package homework.RollCall;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.lang.WeightRandom;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.*;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class crawDataDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //----------------准备姓和名的集合-----------------
        String xingUrl = "https://hanyu.baidu.com/shici/detail?from=kg1&highlight=&pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&srcid=51369";
        String mingUrl = "http://www.haoming8.cn/mingzi/8785.html";
        String boyUrl = "http://www.haoming8.cn/mingzi/11006.html";
        String girlUrl = "http://www.haoming8.cn/mingzi/11979.html";

        String xingStr = CrawlerHuTool(xingUrl);//姓的字符串
        String mingStr = CrawlerHuTool(mingUrl);//名的字符串（不分性别）
        String boyStr = CrawlerHuTool(boyUrl);//男名字符串
        String girlStr = CrawlerHuTool(girlUrl);//女名字符串

        List<Character> charXing = Arrays.stream(Convert.toCharArray(ReUtil.findAll("(.{4})(，|。)", xingStr, 1))).collect(Collectors.toList());//姓的字符
        List<String> nameList = getStrings(ReUtil.findAll("(..、){4}..", mingStr, 0));
        List<String> boyList = getStrings(ReUtil.findAll("(..、){4}..", boyStr, 0));
        List<String> girlList = getStrings(ReUtil.findAll("(..、){4}..", girlStr, 0));

        //-----------------------生成指定个数的随机名字--------------------------------
        HashSet<String> name = getName(charXing, nameList, 10);
//        System.out.println(name);
        HashSet<String> boyName = getName(charXing, boyList, 10);//男生
//        System.out.println(boyName);
        HashSet<String> girlName = getName(charXing, girlList, 10);//女生
//        System.out.println(girlName);
        //获取指定个数随机性别的姓名
        List<String> randomNameList = getRandomNameList(charXing, boyList, girlList, 6);
        //将获得的随机姓名集合添加到Person对象集合中 并打印信息
        List<Person> people = contactInfoToPerson(randomNameList);
//        System.out.println(people);

        //--------------------------随机点名-----------------------------
        //按7:3的权重点名,从List<Person> people中随机
        RollCall(people);
        //第三次一定是某同学
//        CertainRollCall(people);
        //被点到的学生不会再被点到；需要在本地创建student.properties序列化写入
//        NoRepeatCall(people);
        
    }
    private static void NoRepeatCall(List<Person> people) throws IOException, ClassNotFoundException {
        File file = new File("student.properties");
        if(!file.exists()) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(people);
            objectOutputStream.close();
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Scanner sc = new Scanner(System.in);
        List<Person> list = (List<Person>) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(list);
        int size = list.size();
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if(count < size){//还没点完一轮
                Person person = RandomUtil.randomEle(list);
                System.out.println("点到了"+person.getName());
                list.remove(person);
                count++;
            }else if(count == size){
                count = 0;
                System.out.println("开始第二轮点名");
                ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(file));
                list = (List<Person>) objectInputStream1.readObject();
                objectInputStream1.close();
            }
            System.out.println("输入1-9继续点名,输入0退出");
            flag = sc.nextInt();
        }
    }


    //第三次一定点到丁真
    private static void CertainRollCall(List<Person> people) {
        Scanner sc = new Scanner(System.in);
        Person p = new Person("丁真","男",22);
        people.add(p);
        int count = 0;
        int flag = 1;
        while(!Objects.equals(flag,0)){
            if(count == 2){
                System.out.println("点到了"+p.getName()+" 大家好 我是来自理塘的丁真");
            }else {
                Person person = RandomUtil.randomEle(people);
                System.out.println("点到了" + person.getName());
            }
            count++;
            if(count != people.size() - 1) System.out.println("输入1-9继续点名,输入0退出");
            else {System.out.println("点名完毕"); return;}
            flag = sc.nextInt();
        }
    }

    //根据7:3权重点名
    private static void RollCall(List<Person> list){
        long boyNum = list.stream().filter(o -> o.getGender().equals("男")).count();
        long girlNum = list.size() - boyNum;
        List<Student> studentList = new ArrayList<>();
        //将Student对象包装成带有权重的对象集合
        List<WeightRandom.WeightObj<Student>> weightObjList = new ArrayList<>();
        list.forEach(o->{
            String name = o.getName();
            String gender = o.getGender();
            double weight;
            if(Objects.equals(gender,"男")){
                weight = list.size()*0.7/(double) boyNum;
            }else weight = list.size()*0.3/(double) girlNum;
            weightObjList.add(new WeightRandom.WeightObj<>(new Student(name ,gender),weight));
        });
        int countBoy = 0;
        int countGirl = 0;
        WeightRandom<Student> random = RandomUtil.weightRandom(weightObjList);
        for (int i = 0; i < 10000; i++) {
            if (random.next().getGender().equals("男"))countBoy++;
            else countGirl++;
        }
        System.out.println("男生次数："+countBoy+"\n"+"女生次数"+countGirl);

    }
    //将获得的随机姓名集合添加到Person对象集合中返回集合
    private static List<Person> contactInfoToPerson(List<String> list){
        List<Person> list1 = new ArrayList<>();
        list.forEach(o->{
            String name = o.split("-")[0];
            String gender = o.split("-")[1];
            int age = Objects.equals(gender,"男") ? RandomUtil.randomInt(25,31) : RandomUtil.randomInt(18,26);
            list1.add(new Person(name ,gender ,age));
        });
        return list1;
    }
    //随机生成指定个数的名字，男女个数随机
    private static List<String> getRandomNameList(List<Character> xingList ,List<String> boyList ,List<String> girlList ,int totalSize){
        List<String> list = new ArrayList<>();
        int boyNum = RandomUtil.randomInt(totalSize);
        HashSet<String> boyName = getName(xingList, boyList, boyNum);
        HashSet<String> girlName = getName(xingList, girlList, totalSize - boyNum);
        list = boyName.stream().map(o -> o.concat("-男")).collect(Collectors.toList());
        list.addAll(girlName.stream().map(o -> o.concat("-女")).collect(Collectors.toList()));
        Collections.shuffle(list);
        return list;
    }

    private static HashSet<String> getName(List<Character> xingList ,List<String> nameList ,int size){
        HashSet<String> name =new HashSet<>();
        while(name.size() < size){
            String str = RandomUtil.randomEle(xingList) + RandomUtil.randomEle(nameList);
            name.add(str);
        }
        return name;
    }

    private static List<String> getStrings(List<String> strings) {
        List<String> nameList = new ArrayList<>();
        for (String string : strings) {
            String[] split = string.split("、");
            Collections.addAll(nameList,split);
        }
        return nameList;
    }

    //huTool
    public static String CrawlerHuTool(String url) throws IOException {
        StrBuilder strBuilder = new StrBuilder();
        BufferedReader reader = URLUtil.getReader(URLUtil.url(url), CharsetUtil.charset("UTF-8"));
        int ch;
        while((ch = reader.read()) != -1){
            strBuilder.append((char) ch);
        }
        reader.close();
        return strBuilder.toString();
    }
}
