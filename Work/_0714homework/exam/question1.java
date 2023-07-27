package exam;

import java.util.*;
import java.util.stream.Collectors;

public class question1 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random rd = new Random();
		int num = rd.nextInt(200)+1;
		while(list.size()<100){
			if(!list.contains(num)){
				list.add(num);
			}else num = rd.nextInt(200) + 1;
		}
		System.out.println(list);
		ArrayList<Integer> list1 = new ArrayList<>(list.stream().collect(Collectors.toList()));
		while(list.size()!=1){
			for (int i = list.size(); i > 0 ; i--) {
				if (i % 2 == 1) list.remove(i - 1);
			}
		}
		int index = -1;
		for (int i = 0; i < list1.size(); i++) {
			if(Objects.equals(list.get(0), list1.get(i))) {
				index = i;
				break;
			}
		}
		System.out.println("幸存者编号为："+list.get(0));
		System.out.println("一开始的位置为："+ index);
	}
}
