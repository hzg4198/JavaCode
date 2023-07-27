package homework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Homework0714 {
    public static void main(String[] args) {

//        String str = "YUANzhi1987";
//        codeString(str);

//        int[] arr1 = new int[]{1,2,3};
//        int[] arr2 = new int[]{3,4,5,2};
//        contactArr(arr1,arr2);
//        practise1();
//        countNums(-10.8,5.9,2.1,6.0);
        practise2();

    }


    //保留年龄大于等于24岁的
    public static void practise1(){
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张三,23","李四,24","王五,25");
        Map<String, Integer> collect = list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
        for (Map.Entry<String, Integer> entry : collect.entrySet()) {
            System.out.println("name = " + entry.getKey() + ", age = " + entry.getValue());
        }
    }

    public static void practise2(){
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list1,"张三丰","梁朝伟","胡歌","吴京","周星驰","刘德华");
        Collections.addAll(list2,"林志颖","刘亦菲","赵丽颖","林心如","章子怡","林静");
        List<String> collect = list1.stream().filter(s -> s.length() == 3).limit(3).collect(Collectors.toList());
        collect.addAll(list2.stream().filter(s->!s.equals(list2.get(0))).filter(s->s.startsWith("林")).collect(Collectors.toList()));
        System.out.println(collect);

    }
    //contactArr
    public static void contactArr(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int[] target = Arrays.copyOf(arr1,arr1.length + arr2.length);
        System.arraycopy(arr2, 0, target,arr1.length,arr2.length);
        for (int i : target) {
            if(hashMap.containsKey(i)){
                Integer value = hashMap.get(i);
                hashMap.put(i,++value);
            }else {
                hashMap.put(i,1);
            }
        }
        List<Integer> rs = new ArrayList<>();
        hashMap.forEach((o1,o2)->{
            if(hashMap.get(o1)==1) rs.add(o1);
        });
        System.out.println(rs);
    }
    //给定出现次数 输出字符
    public static void practise3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string: ");
        String str = sc.next();
        System.out.println("enter a num represents times");
        int times = sc.nextInt();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            if(hashMap.containsKey(c)){
                Integer value = hashMap.get(c);
                hashMap.put(c,++value);
            }else{
                hashMap.put(c,1);
            }
        }
        hashMap.forEach((o1,o2)->{
            if(o2 == times){
                System.out.println(o1);
            }
        });
    }

    public static void codeString(String str){
        StringBuilder stringBuilder = new StringBuilder();
        //创建字符ASCII值与输出结果的映射关系map，
        Map<Integer, Integer> codeMap = IntStream.rangeClosed('A', 'Z').boxed().collect(Collectors.toMap(o -> o, o -> o + 33));
        codeMap.put(90,97);//输出Z的时候加密为a
        codeMap.putAll(IntStream.rangeClosed('0','9').boxed().collect(Collectors.toMap(o->o,o->o)));
        codeMap.putAll(IntStream.rangeClosed('a','c').boxed().collect(Collectors.toMap(o->o,o->50)));
        codeMap.putAll(IntStream.rangeClosed('d','f').boxed().collect(Collectors.toMap(o->o,o->51)));
        codeMap.putAll(IntStream.rangeClosed('g','i').boxed().collect(Collectors.toMap(o->o,o->52)));
        codeMap.putAll(IntStream.rangeClosed('j','l').boxed().collect(Collectors.toMap(o->o,o->53)));
        codeMap.putAll(IntStream.rangeClosed('m','o').boxed().collect(Collectors.toMap(o->o,o->54)));
        codeMap.putAll(IntStream.rangeClosed('p','s').boxed().collect(Collectors.toMap(o->o,o->55)));
        codeMap.putAll(IntStream.rangeClosed('t','v').boxed().collect(Collectors.toMap(o->o,o->56)));
        codeMap.putAll(IntStream.rangeClosed('w','z').boxed().collect(Collectors.toMap(o->o,o->57)));
        byte[] bytes = str.getBytes();//获得待加密字符串每个字符的ascii值数组
        int[] strASCII = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) strASCII[i] = bytes[i];//转化为int类型的数组
        for (int i : strASCII) {//遍历字符ascii数组
            codeMap.forEach((o1,o2)->{//遍历codeMap通过映射关系得出每个字符加密后的ascii值
                if(o1 == i) stringBuilder.append((char) o2.intValue());
            });
        }
        System.out.println(stringBuilder);
    }

    public static void distinctList(ArrayList<String> list) {
        System.out.println(new HashSet<>(list));
    }

    //计算在一个区间内绝对值大于high或者小于low的整数有多少个
    public static void countNums(Number leftRange,Number rightRange,Double low,Double high){
        List<Number> numList = new ArrayList<>();
        IntStream.rangeClosed((int)Math.floor((Double) leftRange) + 1,(int)Math.ceil((Double) rightRange)-1)
                .forEach(o->{
                    if(Math.abs(o)>high || Math.abs(o)<low) numList.add(o);
                });

        System.out.println(numList);
        System.out.println("一共有"+numList.size()+"个");
    }
}
