package com.lxz.sanguo;

public abstract class Skill {
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void activate(Card self, Card target);
}