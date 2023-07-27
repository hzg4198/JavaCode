import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo0714 {
	public static void main(String[] args) {
//        practise3();
		int[] arr1 = {1,3,4,7};
		int[] arr2 = {3,4,5,6,2};
//        contactArr(arr1,arr2);
//        int[] target = Arrays.copyOf(arr1,arr1.length + arr2.length);
//        System.arraycopy(arr2, 0, target,arr1.length,arr2.length);
//        System.out.println(Arrays.toString(target));
//        practise1();
		practise2();

	}



	public static void practise1(){//保留年龄大于等于24岁的
		ArrayList<String> list = new ArrayList<>();
		Collections.addAll(list,"张三,23","李四,24","王五,25");
		Map<String, Integer> collect = list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24).collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
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
//		collect.addAll(list2.stream().filter(s->!s.equals(list2.get(0))).filter(s->s.startsWith("林")).toList());
		System.out.println(collect);

	}

	public static void contactArr(int[] arr1,int[] arr2){//contactArr
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		int[] target = Arrays.copyOf(arr1,arr1.length + arr2.length);
		System.arraycopy(arr2, 0, target,arr1.length,arr2.length);
		for (int i : target) {
			if(hashMap.containsKey(i)){
				Integer value = hashMap.get(i);
				value++;
				hashMap.put(i,value);
			}else {
				hashMap.put(i,1);
			}
		}
//        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//        }
		hashMap.forEach((o1,o2)->{
			if(hashMap.get(o1)==1) System.out.println(o1);
		});
	}

	public static void practise3(){//给定出现次数 输出字符
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a string: ");
		String str = sc.next();
		System.out.println("enter a num represents times");
		int times = sc.nextInt();
		HashMap<Character,Integer> hashMap = new HashMap<>();
		char[] chars = str.toCharArray();
		for (char c : chars) {
			if(hashMap.containsKey(c)){
				Integer value = hashMap.get(c);
				value++;
				hashMap.put(c,value);
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

	public static void practise4(){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
	}

	public static ArrayList<String> distinctList(ArrayList<String> list) {


		System.out.println();

		return list;
	}

}