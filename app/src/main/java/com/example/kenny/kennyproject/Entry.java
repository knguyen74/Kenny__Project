package com.example.kenny.kennyproject;

import java.io.Serializable;

/**
 * Created by Kenny on 3/28/2017.
 */

public class Entry implements Serializable {
    private String name;
    private String score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
