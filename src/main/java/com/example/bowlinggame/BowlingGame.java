package com.example.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Integer> rollsArrayList = new ArrayList<>();

    public void setRollsArrayList(List<Integer> rollsArrayList) {
        for (Integer roll : rollsArrayList) {
            if (roll.compareTo(0) < 0 || roll.compareTo(10) > 0)
                throw new IllegalArgumentException("Bad value of point!");
        }

        this.rollsArrayList = rollsArrayList;
    }

    public int score() {
        int score = 0;
        int cursor = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(cursor)) {
                score += 10 + rollsArrayList.get(cursor + 1) + rollsArrayList.get(cursor + 2);
                cursor++;
            }
            else if (isSpare(cursor)) {
                score += 10 + rollsArrayList.get((cursor + 2));
                cursor += 2;
            }
            else {
                score += rollsArrayList.get(cursor) + rollsArrayList.get(cursor + 1);
                cursor += 2;
            }
        }
        return score;
    }

    public boolean isStrike(int cursor) {
        return rollsArrayList.get(cursor) == 10;
    }

    public boolean isSpare(int cursor) {
        return rollsArrayList.get(cursor) + rollsArrayList.get(cursor + 1) == 10;
    }
}
