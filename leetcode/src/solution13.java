import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//罗马数字转数字
//66 LXVI
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
public class solution13 {
    public static void main(String[] args) {
        String s = "LVIII";
        String s1 = "MCMXCIV";
        System.out.println(romanToInt(s));
        System.out.println(romanToInt(s1));
    }
    public static int romanToInt(String s) {
        Map<Character ,Integer> map = new HashMap<>();
        map.put('I',1);map.put('V',5);map.put('X',10);map.put('L',50);map.put('C',100);map.put('D',500);map.put('M',1000);
        int length = s.length();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(s.charAt(i));
        }
        if(arr.length == 1)return arr[0];
        int ans = arr[arr.length - 1];
        for (int i = arr.length - 2 ; i >= 0 ;i--){
            if(arr[i] < arr[i + 1] ){
                ans -= arr[i];
            }else ans += arr[i];
        }
        return ans;
    }
}
