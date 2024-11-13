package models.account;

import models.card.TempDeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TempAccount {
    private String username;
    private String password;
    private AccountType accountType;
    private Collection collection;
    private List<TempDeck> decks = new ArrayList<>();
    private String mainDeckName;
    private List<MatchHistory> matchHistories = new ArrayList<>();
    private int money;
    private int wins;

    public String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public Collection getCollection() {
        return collection;
    }

    // Added public by TTamas
    public List<TempDeck> getDecks() {
        return Collections.unmodifiableList(decks);
    }

    // Added public by TTamas
    public String getMainDeckName() {
        return mainDeckName;
    }

    // Added public by TTamas
    public List<MatchHistory> getMatchHistories() {
        return Collections.unmodifiableList(matchHistories);
    }

    // Added public by TTamas
    public int getMoney() {
        return money;
    }

    public int getWins() {
        return wins;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}
