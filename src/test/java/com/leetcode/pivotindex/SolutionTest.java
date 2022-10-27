package com.leetcode.pivotindex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    com.leetcode.pivotindex.Solution pivot = new Solution();

    @Test
    void pivotIndexIs3() {
        assertEquals(3 , pivot.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    @Test
    void pivotIndexNotFound() {
        assertEquals(-1 , pivot.pivotIndex(new int[]{1,2,3}));
    }

    @Test
    void pivotIndexIs0() {
        assertEquals(0 , pivot.pivotIndex(new int[]{2,1,-1}));
    }

}