package com.projetCC.domain;

public class Stats {
    private int id;
    private int level;
    private int deathcount;
    private int playtime;
    private int rank;
    private int power;
    private int userId;

    public Stats(int id, int level, int deathcount, int playtime, int rank, int power, int userId) {
        this.id = id;
        this.level = level;
        this.deathcount = deathcount;
        this.playtime = playtime;
        this.rank = rank;
        this.power = power;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDeathcount() {
        return deathcount;
    }

    public void setDeathcount(int deathcount) {
        this.deathcount = deathcount;
    }

    public int getPlaytime() {
        return playtime;
    }

    public void setPlaytime(int playtime) {
        this.playtime = playtime;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
