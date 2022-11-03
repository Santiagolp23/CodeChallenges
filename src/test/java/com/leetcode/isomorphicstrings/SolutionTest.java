package com.leetcode.isomorphicstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    com.leetcode.isomorphicstrings.Solution testing = new com.leetcode.isomorphicstrings.Solution();

    @Test
    void isIsomorphic() {
        assertTrue(testing.isIsomorphic("egg", "add"));
    }

    @Test
    void isNotIsomorphic() {
        assertTrue(testing.isIsomorphic("foo","bar"));
    }

    @Test
    void isIsomorphic2() {
        assertTrue(testing.isIsomorphic("badc","baba"));
    }
}