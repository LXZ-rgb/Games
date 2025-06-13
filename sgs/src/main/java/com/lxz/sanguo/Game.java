package com.lxz.sanguo;

import java.util.*;

public class Game {
    private Player player;
    private AIPlayer ai;
    private Scanner scanner = new Scanner(System.in);

    public Game() {
        // 构造卡池和技能
        List<Card> cardPool = Arrays.asList(
                new Card("刘备", "蜀", 7, 4, 28, new Skill("仁德") {
                    public void activate(Card self, Card target) {
                        System.out.println(self.getName() + "发动[仁德]，自身回复6点生命");
                        self.heal(6);
                    }
                }),
                new Card("关羽", "蜀", 10, 3, 22, new Skill("武圣") {
                    public void activate(Card self, Card target) {
                        System.out.println(self.getName() + "发动[武圣]，对敌方造成2倍攻击！");
                        target.takeDamage(self.getAttack() * 2);
                    }
                }),
                new Card("张飞", "蜀", 12, 2, 20, null),
                new Card("曹操", "魏", 8, 4, 26, new Skill("奸雄") {
                    public void activate(Card self, Card target) {
                        System.out.println(self.getName() + "发动[奸雄]，吸取目标4点生命");
                        target.takeDamage(4);
                        self.heal(4);
                    }
                }),
                new Card("典韦", "魏", 11, 4, 23, null),
                new Card("郭嘉", "魏", 6, 2, 18, new Skill("遗计") {
                    public void activate(Card self, Card target) {
                        System.out.println(self.getName() + "发动[遗计]，自身本回合免疫伤害");
                        // 简单模拟一回合内不会被打死
                    }
                }),
                new Card("孙权", "吴", 7, 5, 25, new Skill("制衡") {
                    public void activate(Card self, Card target) {
                        System.out.println(self.getName() + "发动[制衡]，恢复自身最大生命的1/3");
                        self.heal(self.getHp() / 3);
                    }
                }),
                new Card("周瑜", "吴", 9, 2, 20, new Skill("反间") {
                    public void activate(Card self, Card target) {
                        System.out.println(self.getName() + "发动[反间]，对敌方造成随机9~15点伤害");
                        int dmg = 9 + new Random().nextInt(7);
                        target.takeDamage(dmg);
                    }
                }),
                new Card("吕蒙", "吴", 8, 5, 22, null),
                new Card("黄忠", "蜀", 10, 3, 21, null),
                new Card("许褚", "魏", 12, 2, 20, null));
        // 玩家和AI各抽5张
        List<Card> playerCards = new ArrayList<>(cardPool.subList(0, 5));
        List<Card> aiCards = new ArrayList<>(cardPool.subList(5, cardPool.size()));

        player = new Player("主公");
        ai = new AIPlayer("电脑");
        player.deck.addCards(playerCards);
        ai.deck.addCards(aiCards);
        player.deck.shuffle();
        ai.deck.shuffle();
        player.drawCards(5);
        ai.drawCards(5);
    }

    public void start() {
        System.out.println("==== 三国策略卡牌对战 ====");
        while (true) {
            if (!player.hasAliveCards()) {
                System.out.println("你所有卡牌已阵亡，游戏失败！");
                break;
            }
            if (!ai.hasAliveCards()) {
                System.out.println("你击败了所有敌方卡牌，获胜！");
                break;
            }
            // 玩家回合
            System.out.println("\n【你的回合】");
            player.showHand();
            int cardIdx = player.chooseCard(scanner);
            int targetIdx = player.chooseTarget(ai, scanner);
            Card myCard = player.hand.get(cardIdx);
            Card aiCard = ai.hand.get(targetIdx);

            System.out.printf("你派出 %s 攻击 %s\n", myCard.getName(), aiCard.getName());
            aiCard.takeDamage(myCard.getAttack());
            if (myCard.getSkill() != null && aiCard.isAlive()) {
                myCard.useSkill(aiCard);
            }
            if (!aiCard.isAlive()) {
                System.out.println("敌方 " + aiCard.getName() + " 被击败！");
            }

            // AI回合
            System.out.println("\n【电脑回合】");
            int aiCardIdx = ai.chooseCard();
            int aiTargetIdx = ai.chooseTarget(player);
            Card aiAtk = ai.hand.get(aiCardIdx);
            Card myTarget = player.hand.get(aiTargetIdx);

            System.out.printf("电脑派出 %s 攻击你的 %s\n", aiAtk.getName(), myTarget.getName());
            myTarget.takeDamage(aiAtk.getAttack());
            if (aiAtk.getSkill() != null && myTarget.isAlive()) {
                aiAtk.useSkill(myTarget);
            }
            if (!myTarget.isAlive()) {
                System.out.println("你的 " + myTarget.getName() + " 被击败！");
            }
        }
        System.out.println("=== 游戏结束 ===");
    }
}