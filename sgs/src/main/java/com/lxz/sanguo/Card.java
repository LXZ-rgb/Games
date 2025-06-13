package com.lxz.sanguo;

public class Card {
    private String name;
    private String camp;
    private int attack;
    private int defense;
    private int hp;
    private Skill skill;
    private boolean alive = true;

    public Card(String name, String camp, int attack, int defense, int hp, Skill skill) {
        this.name = name;
        this.camp = camp;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.skill = skill;
    }

    public void useSkill(Card target) {
        if (alive && target.isAlive() && skill != null) {
            skill.activate(this, target);
        }
    }

    public void takeDamage(int dmg) {
        int realDmg = Math.max(0, dmg - defense);
        hp -= realDmg;
        if (hp <= 0) {
            alive = false;
            hp = 0;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHp() {
        return hp;
    }

    public String getCamp() {
        return camp;
    }

    public Skill getSkill() {
        return skill;
    }

    public void heal(int val) {
        if (alive)
            hp += val;
    }

    @Override
    public String toString() {
        return String.format("%s[%s] ATK:%d DEF:%d HP:%d %s", name, camp, attack, defense, hp,
                (skill != null ? "SKILL:" + skill.getName() : ""));
    }
}