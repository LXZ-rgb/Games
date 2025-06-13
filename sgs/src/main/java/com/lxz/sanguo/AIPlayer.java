package com.lxz.sanguo;

import java.util.*;

public class AIPlayer extends Player {
    private Random random = new Random();

    public AIPlayer(String name) {
        super(name);
    }

    public int chooseCard() {
        List<Integer> aliveIdx = new ArrayList<>();
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).isAlive())
                aliveIdx.add(i);
        }
        if (aliveIdx.isEmpty())
            return -1;
        return aliveIdx.get(random.nextInt(aliveIdx.size()));
    }

    public int chooseTarget(Player opponent) {
        List<Integer> aliveIdx = new ArrayList<>();
        for (int i = 0; i < opponent.hand.size(); i++) {
            if (opponent.hand.get(i).isAlive())
                aliveIdx.add(i);
        }
        if (aliveIdx.isEmpty())
            return -1;
        return aliveIdx.get(random.nextInt(aliveIdx.size()));
    }
}