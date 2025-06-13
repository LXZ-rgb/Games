package com.lxz.sanguo;

import java.util.*;

public class Player {
    protected String name;
    protected CardDeck deck;
    protected List<Card> hand;
    protected int maxHandSize = 5;

    public Player(String name) {
        this.name = name;
        this.deck = new CardDeck();
        this.hand = new ArrayList<>();
    }

    public void drawCards(int n) {
        for (int i = 0; i < n && hand.size() < maxHandSize; i++) {
            Card c = deck.drawCard();
            if (c != null)
                hand.add(c);
        }
    }

    public boolean hasAliveCards() {
        return hand.stream().anyMatch(Card::isAlive);
    }

    public Card getAliveCard(int idx) {
        int count = 0;
        for (Card c : hand) {
            if (c.isAlive()) {
                if (count == idx)
                    return c;
                count++;
            }
        }
        return null;
    }

    public int getAliveCount() {
        int cnt = 0;
        for (Card c : hand)
            if (c.isAlive())
                cnt++;
        return cnt;
    }

    public void showHand() {
        System.out.println("[" + name + "] 手牌：");
        int i = 0;
        for (Card c : hand) {
            System.out.printf("  (%d) %s\n", i, c);
            i++;
        }
    }

    public String getName() {
        return name;
    }

    // 玩家选择出牌
    public int chooseCard(Scanner scanner) {
        showHand();
        System.out.print("请选择你要出战的卡牌编号：");
        int idx = -1;
        while (idx < 0 || idx >= hand.size() || !hand.get(idx).isAlive()) {
            try {
                idx = Integer.parseInt(scanner.nextLine());
                if (!hand.get(idx).isAlive()) {
                    System.out.print("该卡已阵亡，请重新选择：");
                    idx = -1;
                }
            } catch (Exception e) {
                System.out.print("输入有误，请再次输入编号：");
            }
        }
        return idx;
    }

    // 玩家选择攻击目标
    public int chooseTarget(Player opponent, Scanner scanner) {
        System.out.println("敌方存活卡牌：");
        int i = 0;
        for (Card c : opponent.hand) {
            if (c.isAlive())
                System.out.printf("  (%d) %s\n", i, c);
            i++;
        }
        System.out.print("请选择攻击目标编号：");
        int idx = -1;
        while (idx < 0 || idx >= opponent.hand.size() || !opponent.hand.get(idx).isAlive()) {
            try {
                idx = Integer.parseInt(scanner.nextLine());
                if (!opponent.hand.get(idx).isAlive()) {
                    System.out.print("该卡已阵亡，请重新选择：");
                    idx = -1;
                }
            } catch (Exception e) {
                System.out.print("输入有误，请再次输入编号：");
            }
        }
        return idx;
    }
}