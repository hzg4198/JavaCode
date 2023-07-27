package exam;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TestQuestion2 {
	public static void main(String[] args) {
		String userStrs = "10001:张三:男:1990-01-01#10002:李四:女:1989-01-09#10003:" +
				"王五:男:1999-09-09#10004:刘备:男:1899-01-01#10005:孙悟空:男:1900-01-01#10006:" +
				"张三:女:1999-01-01#10007:刘备:女:1999-01-01#10008:张三:女:2003-07-01#10009:" +
				"猪八戒:男:1900-01-01";

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<String> list = Arrays.stream(userStrs.split("#")).collect(Collectors.toList());
		List<User> userList = new ArrayList<User>();
		list.forEach(o->{
			String[] split = o.split(":");
			User u = new User(Long.parseLong(split[0]),split[1],split[2],LocalDate.parse(split[3],dateTimeFormatter));
			userList.add(u);
		});
		System.out.println(userList);

		Map<String,Integer> userMap = new HashMap<>();
		userList.forEach(o->{
			if(userMap.containsKey(o.getName())){
				Integer value = userMap.get(o.getName());
				userMap.put(o.getName(), ++value);
			}else userMap.put(o.getName(),1);
		});
		userMap.forEach((o1,o2)-> System.out.println(o1+":"+o2));
	}
}
