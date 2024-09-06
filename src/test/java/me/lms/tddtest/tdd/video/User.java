package me.lms.tddtest.tdd.video;

public class User {
    private String name;
    private int lendVideoCount;

    public User(String name ){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLendVideoCount() {
        return lendVideoCount;
    }

    public void setLendVideoCount(int lendVideoCount) {
        this.lendVideoCount = lendVideoCount;
    }
}
