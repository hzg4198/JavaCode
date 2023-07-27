package Landlord;

import java.util.*;
import java.util.stream.Collectors;

public class Poker {
    public static void main(String[] args) {

        ArrayList<String> poker = new ArrayList<>();
        String[] suits = {"♥", "♦", "♠", "♣"};
        String[] nums = {"3", "4", "5,", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        //准备一副牌
        HashMap<String, Integer> pokerMap = new LinkedHashMap<>();//创建牌面和索引的对应map
        ArrayList<Integer> indexList = new ArrayList<>();//创建牌面索引list，与map里的value一一对应
        int index = 0;
        for (String num : nums) {//在循环创建扑克牌的时候已经有序，先循环数字，再循环花色，使得同一数字的不同花色排在一起
            for (String suit : suits) {
                String card = suit + num;//牌面
                pokerMap.put(card,index);//每张牌面创建时和索引一起添加到map中
                indexList.add(index++);//将该牌面创建时对应的索引添加到list中
            }
        }
        pokerMap.put("小王",index);
        indexList.add(index++);
        pokerMap.put("大王",index);
        indexList.add(index++);

        Collections.shuffle(indexList);//洗牌后发牌

        Player p1 = new Player("梁朝伟");//创建玩家对象
        Player p2 = new Player("刘德华");
        Player p3 = new Player("周润发");
        Player downCards =new Player("底牌");
        p1.setHand(indexList.stream().limit(17).collect(Collectors.toList()));//每个玩家依次获得自己的手牌序列
        p2.setHand(indexList.stream().skip(17).limit(17).collect(Collectors.toList()));
        p3.setHand(indexList.stream().skip(34).limit(17).collect(Collectors.toList()));
        downCards.setHand(indexList.stream().skip(51).collect(Collectors.toList()));
        System.out.println("----打印手牌---");
        //调用printCards()方法，通过玩家手牌序列在pokermap中寻找对应的牌
        printCards(pokerMap,p1);
        printCards(pokerMap,p2);
        printCards(pokerMap,p3);
        printCards(pokerMap,downCards);
    }

    public static void printCards(Map<String, Integer> pokerMap,Player player){//打印玩家手牌并排序
        System.out.print("Playername:"+player.getName()+",Hand: ");
        Collections.sort(player.getHand());
        pokerMap.forEach((o1,o2)->{
            if(player.getHand().contains(o2)) System.out.print(o1+" ");
        });
        System.out.println();

    }
}
