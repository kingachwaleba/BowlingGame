package com.example.bowlinggame;

import java.util.List;

public class BowlingGame {

    public int score(List<Integer> rollsArrayList) {
        int score = 0;
        int cursor = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollsArrayList, cursor)) {
                score += 10 + rollsArrayList.get(cursor + 1) + rollsArrayList.get(cursor + 2);
                cursor++;
            }
            else if (isSpare(rollsArrayList, cursor)) {
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

    public boolean isStrike(List<Integer> rollsArrayList, int cursor) {
        return rollsArrayList.get(cursor) == 10;
    }

    public boolean isSpare(List<Integer> rollsArrayList, int cursor) {
        return rollsArrayList.get(cursor) + rollsArrayList.get(cursor + 1) == 10;
    }
}
