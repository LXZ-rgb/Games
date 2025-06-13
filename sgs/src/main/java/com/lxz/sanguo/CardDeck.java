package com.lxz.sanguo;

import java.util.*;

public class CardDeck {
    private List<Card> cards;

    public CardDeck() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty())
            return null;
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    // 排序：按攻击力降序
    public void sortByAttack() {
        cards.sort(Comparator.comparingInt(Card::getAttack).reversed());
    }
}