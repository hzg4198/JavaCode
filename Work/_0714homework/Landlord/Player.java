package Landlord;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String  name;
    private List<Integer> hand = new ArrayList<>();

    public List<Integer> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }

    public void setHand(List<Integer> hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }
}
