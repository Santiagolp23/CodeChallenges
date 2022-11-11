package com.leetcode.isomorphicstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    com.leetcode.isomorphicstrings.Solution testing = new com.leetcode.isomorphicstrings.Solution();

    @Test
    void isIsomorphic() {
        assertTrue(testing.isIsomorphic("egg", "add"));
    }

    @Test
    void isIsomorphic2() {
        assertTrue(testing.isIsomorphic("paper", "title"));
    }

    @Test
    void isIsomorphic3() {
        assertTrue(testing.isIsomorphic("abab", "baba"));
    }


    @Test
    void isNotIsomorphic() {
        assertFalse(testing.isIsomorphic("foo", "bar"));
    }

    @Test
    void isNotIsomorphic2() {
        assertFalse(testing.isIsomorphic("badc", "baba"));
    }

    @Test
    void isNotIsomorphic3() {
        assertFalse(testing.isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    @Test
    void isNotIsomorphic4() {
        assertFalse(testing.isIsomorphic("egcd", "adfd"));
    }

}