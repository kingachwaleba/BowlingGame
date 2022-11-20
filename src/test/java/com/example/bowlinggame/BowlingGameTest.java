package com.example.bowlinggame;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void score_returnsZero_ifAllZeros() {
        bowlingGame.setRollsArrayList(new ArrayList<>(Arrays.asList(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0)));
        assertEquals(0, bowlingGame.score());
    }

    @Test
    public void score_returns300_ifPerfectGame() {
        bowlingGame.setRollsArrayList(new ArrayList<>(Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)));
        assertEquals(300, bowlingGame.score());
    }

    @Test
    public void score_returns72_ifOneStrike() {
        bowlingGame.setRollsArrayList(new ArrayList<>(Arrays.asList(5,2, 10, 7,1, 0,8, 3,2, 9,0, 6,2, 1,2, 1,1, 4,0)));
        assertEquals(72, bowlingGame.score());
    }

    @Test
    public void score_returns71_ifOneSpare() {
        bowlingGame.setRollsArrayList(new ArrayList<>(Arrays.asList(5,2, 4,6, 7,1, 0,8, 3,2, 9,0, 6,2, 1,2, 1,1, 4,0)));
        assertEquals(71, bowlingGame.score());
    }

    @Test
    public void score_returns61_ifNotSpareOrStrike() {
        bowlingGame.setRollsArrayList(new ArrayList<>(Arrays.asList(5,2, 4,3, 7,1, 0,8, 3,2, 9,0, 6,2, 1,2, 1,1, 4,0)));
        assertEquals(61, bowlingGame.score());
    }

    @Test(expected = IllegalArgumentException.class)
    public void score_throwsIllegalArgumentException_ifOneRollLessThanZero() {
        bowlingGame.setRollsArrayList(
                new ArrayList<>(Arrays.asList(5,2, 4,6, -7,1, 0,8, 3,2, 9,0, 6,2, 1,2, 1,1, 4,0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void score_throwsIllegalArgumentException_ifOneRollIsGreaterThanTen() {
        bowlingGame.setRollsArrayList(
                new ArrayList<>(Arrays.asList(5,2, 4,6, 11,1, 0,8, 3,2, 9,0, 6,2, 1,2, 1,1, 4,0)));
    }
}